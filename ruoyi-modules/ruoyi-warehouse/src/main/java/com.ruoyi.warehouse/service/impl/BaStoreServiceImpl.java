package com.ruoyi.warehouse.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warehouse.mapper.BaStoreMapper;
import com.ruoyi.warehouse.domain.BaStore;
import com.ruoyi.warehouse.service.IBaStoreService;

/**
 * 仓库定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Service
public class BaStoreServiceImpl implements IBaStoreService 
{
    @Autowired
    private BaStoreMapper baStoreMapper;

    /**
     * 查询仓库定义
     * 
     * @param id 仓库定义主键
     * @return 仓库定义
     */
    @Override
    public BaStore selectBaStoreById(Long id)
    {
        return baStoreMapper.selectBaStoreById(id);
    }

    /**
     * 查询仓库定义列表
     * 
     * @param baStore 仓库定义
     * @return 仓库定义
     */
    @Override
    public List<BaStore> selectBaStoreList(BaStore baStore)
    {
        return baStoreMapper.selectBaStoreList(baStore);
    }

    /**
     * 新增仓库定义
     * 
     * @param baStore 仓库定义
     * @return 结果
     */
    @Override
    public int insertBaStore(BaStore baStore)
    {
        return baStoreMapper.insertBaStore(baStore);
    }

    /**
     * 修改仓库定义
     * 
     * @param baStore 仓库定义
     * @return 结果
     */
    @Override
    public int updateBaStore(BaStore baStore)
    {
        return baStoreMapper.updateBaStore(baStore);
    }

    /**
     * 批量删除仓库定义
     * 
     * @param ids 需要删除的仓库定义主键
     * @return 结果
     */
    @Override
    public int deleteBaStoreByIds(Long[] ids)
    {
        return baStoreMapper.deleteBaStoreByIds(ids);
    }

    /**
     * 删除仓库定义信息
     * 
     * @param id 仓库定义主键
     * @return 结果
     */
    @Override
    public int deleteBaStoreById(Long id)
    {
        return baStoreMapper.deleteBaStoreById(id);
    }
}
