package com.ruoyi.warehouse.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.warehouse.domain.BaStore;
import com.ruoyi.warehouse.service.IBaStoreService;
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
import com.ruoyi.warehouse.domain.MdBin;
import com.ruoyi.warehouse.service.IMdBinService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 储位定义Controller
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
@RestController
@RequestMapping("/bin")
public class MdBinController extends BaseController
{
    @Autowired
    private IMdBinService mdBinService;

    @Autowired
    private IBaStoreService baStoreService;

    /**
     * 查询储位定义列表
     */
    @RequiresPermissions("warehouse:bin:list")
    @GetMapping("/list")
    public TableDataInfo list(MdBin mdBin)
    {
        startPage();
        List<MdBin> list = mdBinService.selectMdBinList(mdBin);
        return getDataTable(list);
    }

    /**
     * 导出储位定义列表
     */
    @RequiresPermissions("warehouse:bin:export")
    @Log(title = "储位定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdBin mdBin)
    {
        List<MdBin> list = mdBinService.selectMdBinList(mdBin);
        ExcelUtil<MdBin> util = new ExcelUtil<MdBin>(MdBin.class);
        util.exportExcel(response, list, "储位定义数据");
    }

    /**
     * 获取储位定义详细信息
     */
    @RequiresPermissions("warehouse:bin:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdBinService.selectMdBinById(id));
    }

    /**
     * 新增储位定义
     */
    @RequiresPermissions("warehouse:bin:add")
    @Log(title = "储位定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdBin mdBin)
    {
        BaStore baStore = baStoreService.selectBaStoreById(mdBin.getStoreId());
        mdBin.setBinStore(baStore.getStoreName());
        return toAjax(mdBinService.insertMdBin(mdBin));
    }

    /**
     * 修改储位定义
     */
    @RequiresPermissions("warehouse:bin:edit")
    @Log(title = "储位定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdBin mdBin)
    {
        return toAjax(mdBinService.updateMdBin(mdBin));
    }

    /**
     * 删除储位定义
     */
    @RequiresPermissions("warehouse:bin:remove")
    @Log(title = "储位定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdBinService.deleteMdBinByIds(ids));
    }
}
