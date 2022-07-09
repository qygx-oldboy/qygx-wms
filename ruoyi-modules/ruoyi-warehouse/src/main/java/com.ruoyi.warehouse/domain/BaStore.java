package com.ruoyi.warehouse.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 仓库定义对象 ba_store
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public class BaStore extends BaseEntity
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
    private String sysOrgCode;

    /** 所属公司 */
    private String sysCompanyCode;

    /** 仓库代码 */
    @Excel(name = "仓库代码")
    private String storeCode;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String storeName;

    /** 仓库属性 */
    @Excel(name = "仓库属性")
    private String storeText;

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
    public void setStoreCode(String storeCode) 
    {
        this.storeCode = storeCode;
    }

    public String getStoreCode() 
    {
        return storeCode;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setStoreText(String storeText) 
    {
        this.storeText = storeText;
    }

    public String getStoreText() 
    {
        return storeText;
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
            .append("storeCode", getStoreCode())
            .append("storeName", getStoreName())
            .append("storeText", getStoreText())
            .toString();
    }
}
