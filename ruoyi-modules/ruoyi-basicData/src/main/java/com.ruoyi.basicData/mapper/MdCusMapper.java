package com.ruoyi.basicData.mapper;

import java.util.List;
import com.ruoyi.basicData.domain.MdCus;

/**
 * 客户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface MdCusMapper 
{
    /**
     * 查询客户信息
     * 
     * @param id 客户信息主键
     * @return 客户信息
     */
    public MdCus selectMdCusById(Long id);

    /**
     * 查询客户信息列表
     * 
     * @param mdCus 客户信息
     * @return 客户信息集合
     */
    public List<MdCus> selectMdCusList(MdCus mdCus);

    /**
     * 新增客户信息
     * 
     * @param mdCus 客户信息
     * @return 结果
     */
    public int insertMdCus(MdCus mdCus);

    /**
     * 修改客户信息
     * 
     * @param mdCus 客户信息
     * @return 结果
     */
    public int updateMdCus(MdCus mdCus);

    /**
     * 删除客户信息
     * 
     * @param id 客户信息主键
     * @return 结果
     */
    public int deleteMdCusById(Long id);

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdCusByIds(Long[] ids);
}
