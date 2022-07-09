package com.ruoyi.warehouse.service;

import java.util.List;
import com.ruoyi.warehouse.domain.BaStore;

/**
 * 仓库定义Service接口
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public interface IBaStoreService 
{
    /**
     * 查询仓库定义
     * 
     * @param id 仓库定义主键
     * @return 仓库定义
     */
    public BaStore selectBaStoreById(Long id);

    /**
     * 查询仓库定义列表
     * 
     * @param baStore 仓库定义
     * @return 仓库定义集合
     */
    public List<BaStore> selectBaStoreList(BaStore baStore);

    /**
     * 新增仓库定义
     * 
     * @param baStore 仓库定义
     * @return 结果
     */
    public int insertBaStore(BaStore baStore);

    /**
     * 修改仓库定义
     * 
     * @param baStore 仓库定义
     * @return 结果
     */
    public int updateBaStore(BaStore baStore);

    /**
     * 批量删除仓库定义
     * 
     * @param ids 需要删除的仓库定义主键集合
     * @return 结果
     */
    public int deleteBaStoreByIds(Long[] ids);

    /**
     * 删除仓库定义信息
     * 
     * @param id 仓库定义主键
     * @return 结果
     */
    public int deleteBaStoreById(Long id);
}
