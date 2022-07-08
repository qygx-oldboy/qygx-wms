package com.ruoyi.basicData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.basicData.mapper.MdCusMapper;
import com.ruoyi.basicData.domain.MdCus;
import com.ruoyi.basicData.service.IMdCusService;

/**
 * 客户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class MdCusServiceImpl implements IMdCusService 
{
    @Autowired
    private MdCusMapper mdCusMapper;

    /**
     * 查询客户信息
     * 
     * @param id 客户信息主键
     * @return 客户信息
     */
    @Override
    public MdCus selectMdCusById(Long id)
    {
        return mdCusMapper.selectMdCusById(id);
    }

    /**
     * 查询客户信息列表
     * 
     * @param mdCus 客户信息
     * @return 客户信息
     */
    @Override
    public List<MdCus> selectMdCusList(MdCus mdCus)
    {
        return mdCusMapper.selectMdCusList(mdCus);
    }

    /**
     * 新增客户信息
     * 
     * @param mdCus 客户信息
     * @return 结果
     */
    @Override
    public int insertMdCus(MdCus mdCus)
    {
        return mdCusMapper.insertMdCus(mdCus);
    }

    /**
     * 修改客户信息
     * 
     * @param mdCus 客户信息
     * @return 结果
     */
    @Override
    public int updateMdCus(MdCus mdCus)
    {
        return mdCusMapper.updateMdCus(mdCus);
    }

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的客户信息主键
     * @return 结果
     */
    @Override
    public int deleteMdCusByIds(Long[] ids)
    {
        return mdCusMapper.deleteMdCusByIds(ids);
    }

    /**
     * 删除客户信息信息
     * 
     * @param id 客户信息主键
     * @return 结果
     */
    @Override
    public int deleteMdCusById(Long id)
    {
        return mdCusMapper.deleteMdCusById(id);
    }
}
