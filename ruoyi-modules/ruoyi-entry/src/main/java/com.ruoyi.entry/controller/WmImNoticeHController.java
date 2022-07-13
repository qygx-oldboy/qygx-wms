package com.ruoyi.entry.controller;

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
import com.ruoyi.entry.domain.WmImNoticeH;
import com.ruoyi.entry.service.IWmImNoticeHService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 预约通知抬头Controller
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@RestController
@RequestMapping("/imNoticeH")
public class WmImNoticeHController extends BaseController
{
    @Autowired
    private IWmImNoticeHService wmImNoticeHService;

    /**
     * 查询预约通知抬头列表
     */
    @RequiresPermissions("entry:imNoticeH:list")
    @GetMapping("/list")
    public TableDataInfo list(WmImNoticeH wmImNoticeH)
    {
        startPage();
        List<WmImNoticeH> list = wmImNoticeHService.selectWmImNoticeHList(wmImNoticeH);
        return getDataTable(list);
    }

    /**
     * 导出预约通知抬头列表
     */
    @RequiresPermissions("entry:imNoticeH:export")
    @Log(title = "预约通知抬头", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmImNoticeH wmImNoticeH)
    {
        List<WmImNoticeH> list = wmImNoticeHService.selectWmImNoticeHList(wmImNoticeH);
        ExcelUtil<WmImNoticeH> util = new ExcelUtil<WmImNoticeH>(WmImNoticeH.class);
        util.exportExcel(response, list, "预约通知抬头数据");
    }

    /**
     * 获取预约通知抬头详细信息
     */
    @RequiresPermissions("entry:imNoticeH:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wmImNoticeHService.selectWmImNoticeHById(id));
    }

    /**
     * 新增预约通知抬头
     */
    @RequiresPermissions("entry:imNoticeH:add")
    @Log(title = "预约通知抬头", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmImNoticeH wmImNoticeH)
    {
        return toAjax(wmImNoticeHService.insertWmImNoticeH(wmImNoticeH));
    }

    /**
     * 修改预约通知抬头
     */
    @RequiresPermissions("entry:imNoticeH:edit")
    @Log(title = "预约通知抬头", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmImNoticeH wmImNoticeH)
    {
        return toAjax(wmImNoticeHService.updateWmImNoticeH(wmImNoticeH));
    }

    /**
     * 删除预约通知抬头
     */
    @RequiresPermissions("entry:imNoticeH:remove")
    @Log(title = "预约通知抬头", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmImNoticeHService.deleteWmImNoticeHByIds(ids));
    }
}
