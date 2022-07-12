package com.ruoyi.basicData.mapper;

import java.util.List;
import com.ruoyi.basicData.domain.MdSup;

/**
 * 供应商Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-11
 */
public interface MdSupMapper 
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
     * 删除供应商
     * 
     * @param id 供应商主键
     * @return 结果
     */
    public int deleteMdSupById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdSupByIds(Long[] ids);
}
