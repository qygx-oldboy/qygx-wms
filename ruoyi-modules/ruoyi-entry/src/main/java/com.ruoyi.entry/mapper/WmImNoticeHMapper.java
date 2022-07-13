package com.ruoyi.entry.mapper;

import java.util.List;
import com.ruoyi.entry.domain.WmImNoticeH;
import com.ruoyi.entry.domain.WmImNoticeI;

/**
 * 预约通知抬头Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public interface WmImNoticeHMapper 
{
    /**
     * 查询预约通知抬头
     * 
     * @param id 预约通知抬头主键
     * @return 预约通知抬头
     */
    public WmImNoticeH selectWmImNoticeHById(Long id);

    /**
     * 查询预约通知抬头列表
     * 
     * @param wmImNoticeH 预约通知抬头
     * @return 预约通知抬头集合
     */
    public List<WmImNoticeH> selectWmImNoticeHList(WmImNoticeH wmImNoticeH);

    /**
     * 新增预约通知抬头
     * 
     * @param wmImNoticeH 预约通知抬头
     * @return 结果
     */
    public int insertWmImNoticeH(WmImNoticeH wmImNoticeH);

    /**
     * 修改预约通知抬头
     * 
     * @param wmImNoticeH 预约通知抬头
     * @return 结果
     */
    public int updateWmImNoticeH(WmImNoticeH wmImNoticeH);

    /**
     * 删除预约通知抬头
     * 
     * @param id 预约通知抬头主键
     * @return 结果
     */
    public int deleteWmImNoticeHById(Long id);

    /**
     * 批量删除预约通知抬头
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmImNoticeHByIds(Long[] ids);

    /**
     * 批量删除预约进货行项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmImNoticeIByImNoticeHIds(Long[] ids);
    
    /**
     * 批量新增预约进货行项目
     * 
     * @param wmImNoticeIList 预约进货行项目列表
     * @return 结果
     */
    public int batchWmImNoticeI(List<WmImNoticeI> wmImNoticeIList);
    

    /**
     * 通过预约通知抬头主键删除预约进货行项目信息
     * 
     * @param id 预约通知抬头ID
     * @return 结果
     */
    public int deleteWmImNoticeIByImNoticeHId(Long id);
}
