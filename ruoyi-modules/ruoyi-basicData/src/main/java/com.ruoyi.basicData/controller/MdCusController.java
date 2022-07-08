package com.ruoyi.basicData.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.basicData.domain.MdCus;
import com.ruoyi.basicData.service.IMdCusService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/cus")
public class MdCusController extends BaseController
{
    @Autowired
    private IMdCusService mdCusService;

    /**
     * 查询客户信息列表
     */
    @RequiresPermissions("basicData:cus:list")
    @GetMapping("/list")
    public TableDataInfo list(MdCus mdCus)
    {
        startPage();
        List<MdCus> list = mdCusService.selectMdCusList(mdCus);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @RequiresPermissions("basicData:cus:export")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdCus mdCus)
    {
        List<MdCus> list = mdCusService.selectMdCusList(mdCus);
        ExcelUtil<MdCus> util = new ExcelUtil<MdCus>(MdCus.class);
        util.exportExcel(response, list, "客户信息数据");
    }

    /**
     * 获取客户信息详细信息
     */
    @RequiresPermissions("basicData:cus:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdCusService.selectMdCusById(id));
    }

    /**
     * 新增客户信息
     */
    @RequiresPermissions("basicData:cus:add")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdCus mdCus)
    {
        return toAjax(mdCusService.insertMdCus(mdCus));
    }

    /**
     * 修改客户信息
     */
    @RequiresPermissions("basicData:cus:edit")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdCus mdCus)
    {
        return toAjax(mdCusService.updateMdCus(mdCus));
    }

    /**
     * 删除客户信息
     */
    @RequiresPermissions("basicData:cus:remove")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdCusService.deleteMdCusByIds(ids));
    }
}
