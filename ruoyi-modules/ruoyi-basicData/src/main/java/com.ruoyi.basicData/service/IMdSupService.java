package com.ruoyi.basicData.service;

import java.util.List;
import com.ruoyi.basicData.domain.MdSup;

/**
 * 供应商Service接口
 * 
 * @author ruoyi
 * @date 2022-07-11
 */
public interface IMdSupService 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    public MdSup selectMdSupById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param mdSup 供应商
     * @return 供应商集合
     */
    public List<MdSup> selectMdSupList(MdSup mdSup);

    /**
     * 新增供应商
     * 
     * @param mdSup 供应商
     * @return 结果
     */
    public int insertMdSup(MdSup mdSup);

    /**
     * 修改供应商
     * 
     * @param mdSup 供应商
     * @return 结果
     */
    public int updateMdSup(MdSup mdSup);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的供应商主键集合
     * @return 结果
     */
    public int deleteMdSupByIds(Long[] ids);

    /**
     * 删除供应商信息
     * 
     * @param id 供应商主键
     * @return 结果
     */
    public int deleteMdSupById(Long id);
}
