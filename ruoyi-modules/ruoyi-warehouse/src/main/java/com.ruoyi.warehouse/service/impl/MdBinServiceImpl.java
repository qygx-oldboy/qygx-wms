package com.ruoyi.warehouse.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warehouse.mapper.MdBinMapper;
import com.ruoyi.warehouse.domain.MdBin;
import com.ruoyi.warehouse.service.IMdBinService;

/**
 * 储位定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
@Service
public class MdBinServiceImpl implements IMdBinService 
{
    @Autowired
    private MdBinMapper mdBinMapper;

    /**
     * 查询储位定义
     * 
     * @param id 储位定义主键
     * @return 储位定义
     */
    @Override
    public MdBin selectMdBinById(Long id)
    {
        return mdBinMapper.selectMdBinById(id);
    }

    /**
     * 查询储位定义列表
     * 
     * @param mdBin 储位定义
     * @return 储位定义
     */
    @Override
    public List<MdBin> selectMdBinList(MdBin mdBin)
    {
        return mdBinMapper.selectMdBinList(mdBin);
    }

    /**
     * 新增储位定义
     * 
     * @param mdBin 储位定义
     * @return 结果
     */
    @Override
    public int insertMdBin(MdBin mdBin)
    {
        return mdBinMapper.insertMdBin(mdBin);
    }

    /**
     * 修改储位定义
     * 
     * @param mdBin 储位定义
     * @return 结果
     */
    @Override
    public int updateMdBin(MdBin mdBin)
    {
        return mdBinMapper.updateMdBin(mdBin);
    }

    /**
     * 批量删除储位定义
     * 
     * @param ids 需要删除的储位定义主键
     * @return 结果
     */
    @Override
    public int deleteMdBinByIds(Long[] ids)
    {
        return mdBinMapper.deleteMdBinByIds(ids);
    }

    /**
     * 删除储位定义信息
     * 
     * @param id 储位定义主键
     * @return 结果
     */
    @Override
    public int deleteMdBinById(Long id)
    {
        return mdBinMapper.deleteMdBinById(id);
    }
}
