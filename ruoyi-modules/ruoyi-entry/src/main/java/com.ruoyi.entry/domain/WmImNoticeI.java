package com.ruoyi.entry.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 预约进货行项目对象 wm_im_notice_i
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public class WmImNoticeI extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建人名称 */
    @Excel(name = "创建人名称")
    private String createName;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新人名称 */
    @Excel(name = "更新人名称")
    private String updateName;

    /** 更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String sysCompanyCode;

    /** 到货通知单号 */
    @Excel(name = "到货通知单号")
    private String imNoticeId;

    /** 到货通知项目 */
    @Excel(name = "到货通知项目")
    private String imNoticeItem;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String goodsCode;

    /** 数量 */
    @Excel(name = "数量")
    private String goodsCount;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date goodsPrdData;

    /** 批次 */
    @Excel(name = "批次")
    private String goodsBatch;

    /** 库位整理 */
    @Excel(name = "库位整理")
    private String binPre;

    /** 体积 */
    @Excel(name = "体积")
    private String goodsFvol;

    /** 重量 */
    @Excel(name = "重量")
    private String goodsWeight;

    /** 计划库位 */
    @Excel(name = "计划库位")
    private String binPlan;

    /** 单位 */
    @Excel(name = "单位")
    private String goodsUnit;

    /** 未清数量 */
    @Excel(name = "未清数量")
    private String goodsWqmCount;

    /** 批量收货数量 */
    @Excel(name = "批量收货数量")
    private String goodsQmCount;

    /** 行项目状态 */
    @Excel(name = "行项目状态")
    private String noticeiSta;

    /** 基本单位 */
    @Excel(name = "基本单位")
    private String baseUnit;

    /** 基本单位数量 */
    @Excel(name = "基本单位数量")
    private String baseGoodscount;

    /** 基本单位收货数量 */
    @Excel(name = "基本单位收货数量")
    private String baseQmcount;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 第三方客户ID */
    @Excel(name = "第三方客户ID")
    private String otherId;

    /** 预约通知抬头ID */
    @Excel(name = "预约通知抬头ID")
    private Long imNoticeHId;

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
    public void setImNoticeId(String imNoticeId) 
    {
        this.imNoticeId = imNoticeId;
    }

    public String getImNoticeId() 
    {
        return imNoticeId;
    }
    public void setImNoticeItem(String imNoticeItem) 
    {
        this.imNoticeItem = imNoticeItem;
    }

    public String getImNoticeItem() 
    {
        return imNoticeItem;
    }
    public void setGoodsCode(String goodsCode) 
    {
        this.goodsCode = goodsCode;
    }

    public String getGoodsCode() 
    {
        return goodsCode;
    }
    public void setGoodsCount(String goodsCount) 
    {
        this.goodsCount = goodsCount;
    }

    public String getGoodsCount() 
    {
        return goodsCount;
    }
    public void setGoodsPrdData(Date goodsPrdData) 
    {
        this.goodsPrdData = goodsPrdData;
    }

    public Date getGoodsPrdData() 
    {
        return goodsPrdData;
    }
    public void setGoodsBatch(String goodsBatch) 
    {
        this.goodsBatch = goodsBatch;
    }

    public String getGoodsBatch() 
    {
        return goodsBatch;
    }
    public void setBinPre(String binPre) 
    {
        this.binPre = binPre;
    }

    public String getBinPre() 
    {
        return binPre;
    }
    public void setGoodsFvol(String goodsFvol) 
    {
        this.goodsFvol = goodsFvol;
    }

    public String getGoodsFvol() 
    {
        return goodsFvol;
    }
    public void setGoodsWeight(String goodsWeight) 
    {
        this.goodsWeight = goodsWeight;
    }

    public String getGoodsWeight() 
    {
        return goodsWeight;
    }
    public void setBinPlan(String binPlan) 
    {
        this.binPlan = binPlan;
    }

    public String getBinPlan() 
    {
        return binPlan;
    }
    public void setGoodsUnit(String goodsUnit) 
    {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsUnit() 
    {
        return goodsUnit;
    }
    public void setGoodsWqmCount(String goodsWqmCount) 
    {
        this.goodsWqmCount = goodsWqmCount;
    }

    public String getGoodsWqmCount() 
    {
        return goodsWqmCount;
    }
    public void setGoodsQmCount(String goodsQmCount) 
    {
        this.goodsQmCount = goodsQmCount;
    }

    public String getGoodsQmCount() 
    {
        return goodsQmCount;
    }
    public void setNoticeiSta(String noticeiSta) 
    {
        this.noticeiSta = noticeiSta;
    }

    public String getNoticeiSta() 
    {
        return noticeiSta;
    }
    public void setBaseUnit(String baseUnit) 
    {
        this.baseUnit = baseUnit;
    }

    public String getBaseUnit() 
    {
        return baseUnit;
    }
    public void setBaseGoodscount(String baseGoodscount) 
    {
        this.baseGoodscount = baseGoodscount;
    }

    public String getBaseGoodscount() 
    {
        return baseGoodscount;
    }
    public void setBaseQmcount(String baseQmcount) 
    {
        this.baseQmcount = baseQmcount;
    }

    public String getBaseQmcount() 
    {
        return baseQmcount;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setOtherId(String otherId) 
    {
        this.otherId = otherId;
    }

    public String getOtherId() 
    {
        return otherId;
    }
    public void setImNoticeHId(Long imNoticeHId) 
    {
        this.imNoticeHId = imNoticeHId;
    }

    public Long getImNoticeHId() 
    {
        return imNoticeHId;
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
            .append("imNoticeId", getImNoticeId())
            .append("imNoticeItem", getImNoticeItem())
            .append("goodsCode", getGoodsCode())
            .append("goodsCount", getGoodsCount())
            .append("goodsPrdData", getGoodsPrdData())
            .append("goodsBatch", getGoodsBatch())
            .append("binPre", getBinPre())
            .append("goodsFvol", getGoodsFvol())
            .append("goodsWeight", getGoodsWeight())
            .append("binPlan", getBinPlan())
            .append("goodsUnit", getGoodsUnit())
            .append("goodsWqmCount", getGoodsWqmCount())
            .append("goodsQmCount", getGoodsQmCount())
            .append("noticeiSta", getNoticeiSta())
            .append("baseUnit", getBaseUnit())
            .append("baseGoodscount", getBaseGoodscount())
            .append("baseQmcount", getBaseQmcount())
            .append("goodsName", getGoodsName())
            .append("otherId", getOtherId())
            .append("imNoticeHId", getImNoticeHId())
            .toString();
    }
}
