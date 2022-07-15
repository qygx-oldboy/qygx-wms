package com.ruoyi.basicData.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.basicData.domain.MdCus;
import com.ruoyi.basicData.service.IMdCusService;
import com.ruoyi.common.core.utils.barcode.BarcodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.basicData.domain.MdGoods;
import com.ruoyi.basicData.service.IMdGoodsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品信息Controller
 *
 * @author ruoyi
 * @date 2022-07-12
 */
@RestController
@RequestMapping("/goods")
public class MdGoodsController extends BaseController
{
    @Autowired
    private IMdGoodsService mdGoodsService;

    @Autowired
    private IMdCusService mdCusService;

    /**
     * 查询商品信息列表
     */
    @RequiresPermissions("basicData:goods:list")
    @GetMapping("/list")
    public TableDataInfo list(MdGoods mdGoods)
    {
        startPage();
        List<MdGoods> list = mdGoodsService.selectMdGoodsList(mdGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @RequiresPermissions("basicData:goods:export")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdGoods mdGoods)
    {
        List<MdGoods> list = mdGoodsService.selectMdGoodsList(mdGoods);
        ExcelUtil<MdGoods> util = new ExcelUtil<MdGoods>(MdGoods.class);
        util.exportExcel(response, list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
    @RequiresPermissions("basicData:goods:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdGoodsService.selectMdGoodsById(id));
    }

    /**
     * 新增商品信息
     */
    @RequiresPermissions("basicData:goods:add")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdGoods mdGoods)
    {
        //todo 拿到货主id，查询货主名称
        MdCus mdCus = mdCusService.selectMdCusById(mdGoods.getSupId());
        mdGoods.setSuoShuKeHu(mdCus.getZhongWenQch());
        return toAjax(mdGoodsService.insertMdGoods(mdGoods));
    }

    /**
     * 修改商品信息
     */
    @RequiresPermissions("basicData:goods:edit")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdGoods mdGoods)
    {
        return toAjax(mdGoodsService.updateMdGoods(mdGoods));
    }

    /**
     * 删除商品信息
     */
    @RequiresPermissions("basicData:goods:remove")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdGoodsService.deleteMdGoodsByIds(ids));
    }

    /**
     * 生成条形码
     */
    @RequiresPermissions("basicData:goods:query")
    @GetMapping(value = "/getBarCode/{shpBianMa}")
    public void getBarCode(@PathVariable String shpBianMa,HttpServletResponse response) throws IOException {
        // 设置响应流信息
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        OutputStream stream = response.getOutputStream();
        BufferedImage image = BarcodeUtils.insertWords(BarcodeUtils.getBarCode(shpBianMa),shpBianMa);
        ImageIO.write(image, "jpg", stream);
    }


}
