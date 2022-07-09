package com.ruoyi.warehouse.controller;

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
import com.ruoyi.warehouse.domain.BaStore;
import com.ruoyi.warehouse.service.IBaStoreService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 仓库定义Controller
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@RestController
@RequestMapping("/store")
public class BaStoreController extends BaseController
{
    @Autowired
    private IBaStoreService baStoreService;

    /**
     * 查询仓库定义列表
     */
    @RequiresPermissions("warehouse:store:list")
    @GetMapping("/list")
    public TableDataInfo list(BaStore baStore)
    {
        startPage();
        List<BaStore> list = baStoreService.selectBaStoreList(baStore);
        return getDataTable(list);
    }

    /**
     * 导出仓库定义列表
     */
    @RequiresPermissions("warehouse:store:export")
    @Log(title = "仓库定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaStore baStore)
    {
        List<BaStore> list = baStoreService.selectBaStoreList(baStore);
        ExcelUtil<BaStore> util = new ExcelUtil<BaStore>(BaStore.class);
        util.exportExcel(response, list, "仓库定义数据");
    }

    /**
     * 获取仓库定义详细信息
     */
    @RequiresPermissions("warehouse:store:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baStoreService.selectBaStoreById(id));
    }

    /**
     * 新增仓库定义
     */
    @RequiresPermissions("warehouse:store:add")
    @Log(title = "仓库定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaStore baStore)
    {
        return toAjax(baStoreService.insertBaStore(baStore));
    }

    /**
     * 修改仓库定义
     */
    @RequiresPermissions("warehouse:store:edit")
    @Log(title = "仓库定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaStore baStore)
    {
        return toAjax(baStoreService.updateBaStore(baStore));
    }

    /**
     * 删除仓库定义
     */
    @RequiresPermissions("warehouse:store:remove")
    @Log(title = "仓库定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baStoreService.deleteBaStoreByIds(ids));
    }
}
