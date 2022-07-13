package com.ruoyi.entry.service;

import java.util.List;
import com.ruoyi.entry.domain.WmImNoticeH;

/**
 * 预约通知抬头Service接口
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public interface IWmImNoticeHService 
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
     * 批量删除预约通知抬头
     * 
     * @param ids 需要删除的预约通知抬头主键集合
     * @return 结果
     */
    public int deleteWmImNoticeHByIds(Long[] ids);

    /**
     * 删除预约通知抬头信息
     * 
     * @param id 预约通知抬头主键
     * @return 结果
     */
    public int deleteWmImNoticeHById(Long id);
}
