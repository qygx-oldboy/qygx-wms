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
import com.ruoyi.basicData.domain.MdSup;
import com.ruoyi.basicData.service.IMdSupService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author ruoyi
 * @date 2022-07-11
 */
@RestController
@RequestMapping("/sup")
public class MdSupController extends BaseController
{
    @Autowired
    private IMdSupService mdSupService;

    /**
     * 查询供应商列表
     */
    @RequiresPermissions("basicData:sup:list")
    @GetMapping("/list")
    public TableDataInfo list(MdSup mdSup)
    {
        startPage();
        List<MdSup> list = mdSupService.selectMdSupList(mdSup);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @RequiresPermissions("basicData:sup:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdSup mdSup)
    {
        List<MdSup> list = mdSupService.selectMdSupList(mdSup);
        ExcelUtil<MdSup> util = new ExcelUtil<MdSup>(MdSup.class);
        util.exportExcel(response, list, "供应商数据");
    }

    /**
     * 获取供应商详细信息
     */
    @RequiresPermissions("basicData:sup:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdSupService.selectMdSupById(id));
    }

    /**
     * 新增供应商
     */
    @RequiresPermissions("basicData:sup:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdSup mdSup)
    {
        return toAjax(mdSupService.insertMdSup(mdSup));
    }

    /**
     * 修改供应商
     */
    @RequiresPermissions("basicData:sup:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdSup mdSup)
    {
        return toAjax(mdSupService.updateMdSup(mdSup));
    }

    /**
     * 删除供应商
     */
    @RequiresPermissions("basicData:sup:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdSupService.deleteMdSupByIds(ids));
    }
}
