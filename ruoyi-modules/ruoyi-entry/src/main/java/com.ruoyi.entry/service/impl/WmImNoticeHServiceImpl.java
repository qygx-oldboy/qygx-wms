package com.ruoyi.entry.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.core.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.entry.domain.WmImNoticeI;
import com.ruoyi.entry.mapper.WmImNoticeHMapper;
import com.ruoyi.entry.domain.WmImNoticeH;
import com.ruoyi.entry.service.IWmImNoticeHService;

/**
 * 预约通知抬头Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Service
public class WmImNoticeHServiceImpl implements IWmImNoticeHService 
{
    @Autowired
    private WmImNoticeHMapper wmImNoticeHMapper;

    /**
     * 查询预约通知抬头
     * 
     * @param id 预约通知抬头主键
     * @return 预约通知抬头
     */
    @Override
    public WmImNoticeH selectWmImNoticeHById(Long id)
    {
        return wmImNoticeHMapper.selectWmImNoticeHById(id);
    }

    /**
     * 查询预约通知抬头列表
     * 
     * @param wmImNoticeH 预约通知抬头
     * @return 预约通知抬头
     */
    @Override
    public List<WmImNoticeH> selectWmImNoticeHList(WmImNoticeH wmImNoticeH)
    {
        return wmImNoticeHMapper.selectWmImNoticeHList(wmImNoticeH);
    }

    /**
     * 新增预约通知抬头
     * 
     * @param wmImNoticeH 预约通知抬头
     * @return 结果
     */
    @Transactional
    @Override
    public int insertWmImNoticeH(WmImNoticeH wmImNoticeH)
    {
        int rows = wmImNoticeHMapper.insertWmImNoticeH(wmImNoticeH);
        insertWmImNoticeI(wmImNoticeH);
        return rows;
    }

    /**
     * 修改预约通知抬头
     * 
     * @param wmImNoticeH 预约通知抬头
     * @return 结果
     */
    @Transactional
    @Override
    public int updateWmImNoticeH(WmImNoticeH wmImNoticeH)
    {
        wmImNoticeHMapper.deleteWmImNoticeIByImNoticeHId(wmImNoticeH.getId());
        insertWmImNoticeI(wmImNoticeH);
        return wmImNoticeHMapper.updateWmImNoticeH(wmImNoticeH);
    }

    /**
     * 批量删除预约通知抬头
     * 
     * @param ids 需要删除的预约通知抬头主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmImNoticeHByIds(Long[] ids)
    {
        wmImNoticeHMapper.deleteWmImNoticeIByImNoticeHIds(ids);
        return wmImNoticeHMapper.deleteWmImNoticeHByIds(ids);
    }

    /**
     * 删除预约通知抬头信息
     * 
     * @param id 预约通知抬头主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmImNoticeHById(Long id)
    {
        wmImNoticeHMapper.deleteWmImNoticeIByImNoticeHId(id);
        return wmImNoticeHMapper.deleteWmImNoticeHById(id);
    }

    /**
     * 新增预约进货行项目信息
     * 
     * @param wmImNoticeH 预约通知抬头对象
     */
    public void insertWmImNoticeI(WmImNoticeH wmImNoticeH)
    {
        List<WmImNoticeI> wmImNoticeIList = wmImNoticeH.getWmImNoticeIList();
        Long id = wmImNoticeH.getId();
        if (StringUtils.isNotNull(wmImNoticeIList))
        {
            List<WmImNoticeI> list = new ArrayList<WmImNoticeI>();
            for (WmImNoticeI wmImNoticeI : wmImNoticeIList)
            {
                wmImNoticeI.setImNoticeHId(id);
                list.add(wmImNoticeI);
            }
            if (list.size() > 0)
            {
                wmImNoticeHMapper.batchWmImNoticeI(list);
            }
        }
    }
}
