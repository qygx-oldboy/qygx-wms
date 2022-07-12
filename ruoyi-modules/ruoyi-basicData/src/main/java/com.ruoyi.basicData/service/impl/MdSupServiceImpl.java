package com.ruoyi.basicData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.basicData.mapper.MdSupMapper;
import com.ruoyi.basicData.domain.MdSup;
import com.ruoyi.basicData.service.IMdSupService;

/**
 * 供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-11
 */
@Service
public class MdSupServiceImpl implements IMdSupService 
{
    @Autowired
    private MdSupMapper mdSupMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    @Override
    public MdSup selectMdSupById(Long id)
    {
        return mdSupMapper.selectMdSupById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param mdSup 供应商
     * @return 供应商
     */
    @Override
    public List<MdSup> selectMdSupList(MdSup mdSup)
    {
        return mdSupMapper.selectMdSupList(mdSup);
    }

    /**
     * 新增供应商
     * 
     * @param mdSup 供应商
     * @return 结果
     */
    @Override
    public int insertMdSup(MdSup mdSup)
    {
        return mdSupMapper.insertMdSup(mdSup);
    }

    /**
     * 修改供应商
     * 
     * @param mdSup 供应商
     * @return 结果
     */
    @Override
    public int updateMdSup(MdSup mdSup)
    {
        return mdSupMapper.updateMdSup(mdSup);
    }

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteMdSupByIds(Long[] ids)
    {
        return mdSupMapper.deleteMdSupByIds(ids);
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商主键
     * @return 结果
     */
    @Override
    public int deleteMdSupById(Long id)
    {
        return mdSupMapper.deleteMdSupById(id);
    }
}
