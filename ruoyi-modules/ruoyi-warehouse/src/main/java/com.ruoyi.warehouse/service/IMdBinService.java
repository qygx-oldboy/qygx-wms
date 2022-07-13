package com.ruoyi.warehouse.service;

import java.util.List;
import com.ruoyi.warehouse.domain.MdBin;

/**
 * 储位定义Service接口
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
public interface IMdBinService 
{
    /**
     * 查询储位定义
     * 
     * @param id 储位定义主键
     * @return 储位定义
     */
    public MdBin selectMdBinById(Long id);

    /**
     * 查询储位定义列表
     * 
     * @param mdBin 储位定义
     * @return 储位定义集合
     */
    public List<MdBin> selectMdBinList(MdBin mdBin);

    /**
     * 新增储位定义
     * 
     * @param mdBin 储位定义
     * @return 结果
     */
    public int insertMdBin(MdBin mdBin);

    /**
     * 修改储位定义
     * 
     * @param mdBin 储位定义
     * @return 结果
     */
    public int updateMdBin(MdBin mdBin);

    /**
     * 批量删除储位定义
     * 
     * @param ids 需要删除的储位定义主键集合
     * @return 结果
     */
    public int deleteMdBinByIds(Long[] ids);

    /**
     * 删除储位定义信息
     * 
     * @param id 储位定义主键
     * @return 结果
     */
    public int deleteMdBinById(Long id);
}
