package com.ruoyi.entry.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 预约通知抬头对象 wm_im_notice_h
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public class WmImNoticeH extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建人名称 */
    private String createName;

    /** 创建日期 */
    private Date createDate;

    /** 更新人名称 */
    private String updateName;

    /** 更新日期 */
    private Date updateDate;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String sysCompanyCode;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String cusCode;

    /** 预计到货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计到货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date imData;

    /** 客户订单号 */
    @Excel(name = "客户订单号")
    private String imCusCode;

    /** 司机 */
    @Excel(name = "司机")
    private String imCarDri;

    /** 司机电话 */
    @Excel(name = "司机电话")
    private String imCarMobile;

    /** 车号 */
    @Excel(name = "车号")
    private String imCarNo;

    /** 订单类型 */
    @Excel(name = "订单类型")
    private String orderTypeCode;

    /** 月台 */
    @Excel(name = "月台")
    private String platformCode;

    /** 备注 */
    @Excel(name = "备注")
    private String imBeizhu;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String imSta;

    /** 进货通知单号 */
    @Excel(name = "进货通知单号")
    private String noticeId;

    /** 附件 */
    @Excel(name = "附件")
    private String fuJian;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supName;

    /** 预约进货行项目信息 */
    private List<WmImNoticeI> wmImNoticeIList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateName(String updateName) 
    {
        this.updateName = updateName;
    }

    public String getUpdateName() 
    {
        return updateName;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setSysOrgCode(String sysOrgCode) 
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode() 
    {
        return sysOrgCode;
    }
    public void setSysCompanyCode(String sysCompanyCode) 
    {
        this.sysCompanyCode = sysCompanyCode;
    }

    public String getSysCompanyCode() 
    {
        return sysCompanyCode;
    }
    public void setCusCode(String cusCode) 
    {
        this.cusCode = cusCode;
    }

    public String getCusCode() 
    {
        return cusCode;
    }
    public void setImData(Date imData) 
    {
        this.imData = imData;
    }

    public Date getImData() 
    {
        return imData;
    }
    public void setImCusCode(String imCusCode) 
    {
        this.imCusCode = imCusCode;
    }

    public String getImCusCode() 
    {
        return imCusCode;
    }
    public void setImCarDri(String imCarDri) 
    {
        this.imCarDri = imCarDri;
    }

    public String getImCarDri() 
    {
        return imCarDri;
    }
    public void setImCarMobile(String imCarMobile) 
    {
        this.imCarMobile = imCarMobile;
    }

    public String getImCarMobile() 
    {
        return imCarMobile;
    }
    public void setImCarNo(String imCarNo) 
    {
        this.imCarNo = imCarNo;
    }

    public String getImCarNo() 
    {
        return imCarNo;
    }
    public void setOrderTypeCode(String orderTypeCode) 
    {
        this.orderTypeCode = orderTypeCode;
    }

    public String getOrderTypeCode() 
    {
        return orderTypeCode;
    }
    public void setPlatformCode(String platformCode) 
    {
        this.platformCode = platformCode;
    }

    public String getPlatformCode() 
    {
        return platformCode;
    }
    public void setImBeizhu(String imBeizhu) 
    {
        this.imBeizhu = imBeizhu;
    }

    public String getImBeizhu() 
    {
        return imBeizhu;
    }
    public void setImSta(String imSta) 
    {
        this.imSta = imSta;
    }

    public String getImSta() 
    {
        return imSta;
    }
    public void setNoticeId(String noticeId) 
    {
        this.noticeId = noticeId;
    }

    public String getNoticeId() 
    {
        return noticeId;
    }
    public void setFuJian(String fuJian) 
    {
        this.fuJian = fuJian;
    }

    public String getFuJian() 
    {
        return fuJian;
    }
    public void setSupCode(String supCode) 
    {
        this.supCode = supCode;
    }

    public String getSupCode() 
    {
        return supCode;
    }
    public void setSupName(String supName) 
    {
        this.supName = supName;
    }

    public String getSupName() 
    {
        return supName;
    }

    public List<WmImNoticeI> getWmImNoticeIList()
    {
        return wmImNoticeIList;
    }

    public void setWmImNoticeIList(List<WmImNoticeI> wmImNoticeIList)
    {
        this.wmImNoticeIList = wmImNoticeIList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createName", getCreateName())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateName", getUpdateName())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("sysOrgCode", getSysOrgCode())
            .append("sysCompanyCode", getSysCompanyCode())
            .append("cusCode", getCusCode())
            .append("imData", getImData())
            .append("imCusCode", getImCusCode())
            .append("imCarDri", getImCarDri())
            .append("imCarMobile", getImCarMobile())
            .append("imCarNo", getImCarNo())
            .append("orderTypeCode", getOrderTypeCode())
            .append("platformCode", getPlatformCode())
            .append("imBeizhu", getImBeizhu())
            .append("imSta", getImSta())
            .append("noticeId", getNoticeId())
            .append("fuJian", getFuJian())
            .append("supCode", getSupCode())
            .append("supName", getSupName())
            .append("wmImNoticeIList", getWmImNoticeIList())
            .toString();
    }
}
