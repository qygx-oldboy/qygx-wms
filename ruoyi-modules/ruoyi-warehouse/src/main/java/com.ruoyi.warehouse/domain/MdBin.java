package com.ruoyi.warehouse.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 储位定义对象 md_bin
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
public class MdBin extends BaseEntity
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

    /** 库位名称 */
    @Excel(name = "库位名称")
    private String kuWeiMingCheng;

    /** 库位编码 */
    @Excel(name = "库位编码")
    private String kuWeiBianMa;

    /** 库位条码 */
    @Excel(name = "库位条码")
    private String kuWeiTiaoMa;

    /** 库位类型 */
    @Excel(name = "库位类型")
    private String kuWeiLeiXing;

    /** 库位属性 */
    @Excel(name = "库位属性")
    private String kuWeiShuXing;

    /** 上架次序 */
    @Excel(name = "上架次序")
    private String shangJiaCiXu;

    /** 取货次序 */
    @Excel(name = "取货次序")
    private String quHuoCiXu;

    /** 所属客户 */
    @Excel(name = "所属客户")
    private String suoShuKeHu;

    /** 体积单位 */
    @Excel(name = "体积单位")
    private String tiJiDanWei;

    /** 重量单位 */
    @Excel(name = "重量单位")
    private String zhongLiangDanWei;

    /** 面积单位 */
    @Excel(name = "面积单位")
    private String mianJiDanWei;

    /** 最大体积 */
    @Excel(name = "最大体积")
    private String zuiDaTiJi;

    /** 最大重量 */
    @Excel(name = "最大重量")
    private String zuiDaZhongLiang;

    /** 最大面积 */
    @Excel(name = "最大面积")
    private String zuiDaMianJi;

    /** 最大托盘 */
    @Excel(name = "最大托盘")
    private String zuiDaTuoPan;

    /** 长度 */
    @Excel(name = "长度")
    private String chang;

    /** 宽度 */
    @Excel(name = "宽度")
    private String kuan;

    /** 高度 */
    @Excel(name = "高度")
    private String gao;

    /** 停用 */
    @Excel(name = "停用")
    private String tingYong;

    /** 明细 */
    @Excel(name = "明细")
    private String mingXi;

    /** 仓库 */
    @Excel(name = "仓库")
    private String binStore;

    /** 产品属性 */
    private String chpShuXing;

    /** 备注1 */
    @Excel(name = "备注1")
    private String mingXi1;

    /** 备注2 */
    @Excel(name = "备注2")
    private String mingXi2;

    /** 动线 */
    @Excel(name = "动线")
    private String mingXi3;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    private Long storeId;

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
    public void setKuWeiMingCheng(String kuWeiMingCheng) 
    {
        this.kuWeiMingCheng = kuWeiMingCheng;
    }

    public String getKuWeiMingCheng() 
    {
        return kuWeiMingCheng;
    }
    public void setKuWeiBianMa(String kuWeiBianMa) 
    {
        this.kuWeiBianMa = kuWeiBianMa;
    }

    public String getKuWeiBianMa() 
    {
        return kuWeiBianMa;
    }
    public void setKuWeiTiaoMa(String kuWeiTiaoMa) 
    {
        this.kuWeiTiaoMa = kuWeiTiaoMa;
    }

    public String getKuWeiTiaoMa() 
    {
        return kuWeiTiaoMa;
    }
    public void setKuWeiLeiXing(String kuWeiLeiXing) 
    {
        this.kuWeiLeiXing = kuWeiLeiXing;
    }

    public String getKuWeiLeiXing() 
    {
        return kuWeiLeiXing;
    }
    public void setKuWeiShuXing(String kuWeiShuXing) 
    {
        this.kuWeiShuXing = kuWeiShuXing;
    }

    public String getKuWeiShuXing() 
    {
        return kuWeiShuXing;
    }
    public void setShangJiaCiXu(String shangJiaCiXu) 
    {
        this.shangJiaCiXu = shangJiaCiXu;
    }

    public String getShangJiaCiXu() 
    {
        return shangJiaCiXu;
    }
    public void setQuHuoCiXu(String quHuoCiXu) 
    {
        this.quHuoCiXu = quHuoCiXu;
    }

    public String getQuHuoCiXu() 
    {
        return quHuoCiXu;
    }
    public void setSuoShuKeHu(String suoShuKeHu) 
    {
        this.suoShuKeHu = suoShuKeHu;
    }

    public String getSuoShuKeHu() 
    {
        return suoShuKeHu;
    }
    public void setTiJiDanWei(String tiJiDanWei) 
    {
        this.tiJiDanWei = tiJiDanWei;
    }

    public String getTiJiDanWei() 
    {
        return tiJiDanWei;
    }
    public void setZhongLiangDanWei(String zhongLiangDanWei) 
    {
        this.zhongLiangDanWei = zhongLiangDanWei;
    }

    public String getZhongLiangDanWei() 
    {
        return zhongLiangDanWei;
    }
    public void setMianJiDanWei(String mianJiDanWei) 
    {
        this.mianJiDanWei = mianJiDanWei;
    }

    public String getMianJiDanWei() 
    {
        return mianJiDanWei;
    }
    public void setZuiDaTiJi(String zuiDaTiJi) 
    {
        this.zuiDaTiJi = zuiDaTiJi;
    }

    public String getZuiDaTiJi() 
    {
        return zuiDaTiJi;
    }
    public void setZuiDaZhongLiang(String zuiDaZhongLiang) 
    {
        this.zuiDaZhongLiang = zuiDaZhongLiang;
    }

    public String getZuiDaZhongLiang() 
    {
        return zuiDaZhongLiang;
    }
    public void setZuiDaMianJi(String zuiDaMianJi) 
    {
        this.zuiDaMianJi = zuiDaMianJi;
    }

    public String getZuiDaMianJi() 
    {
        return zuiDaMianJi;
    }
    public void setZuiDaTuoPan(String zuiDaTuoPan) 
    {
        this.zuiDaTuoPan = zuiDaTuoPan;
    }

    public String getZuiDaTuoPan() 
    {
        return zuiDaTuoPan;
    }
    public void setChang(String chang) 
    {
        this.chang = chang;
    }

    public String getChang() 
    {
        return chang;
    }
    public void setKuan(String kuan) 
    {
        this.kuan = kuan;
    }

    public String getKuan() 
    {
        return kuan;
    }
    public void setGao(String gao) 
    {
        this.gao = gao;
    }

    public String getGao() 
    {
        return gao;
    }
    public void setTingYong(String tingYong) 
    {
        this.tingYong = tingYong;
    }

    public String getTingYong() 
    {
        return tingYong;
    }
    public void setMingXi(String mingXi) 
    {
        this.mingXi = mingXi;
    }

    public String getMingXi() 
    {
        return mingXi;
    }
    public void setBinStore(String binStore) 
    {
        this.binStore = binStore;
    }

    public String getBinStore() 
    {
        return binStore;
    }
    public void setChpShuXing(String chpShuXing) 
    {
        this.chpShuXing = chpShuXing;
    }

    public String getChpShuXing() 
    {
        return chpShuXing;
    }
    public void setMingXi1(String mingXi1) 
    {
        this.mingXi1 = mingXi1;
    }

    public String getMingXi1() 
    {
        return mingXi1;
    }
    public void setMingXi2(String mingXi2) 
    {
        this.mingXi2 = mingXi2;
    }

    public String getMingXi2() 
    {
        return mingXi2;
    }
    public void setMingXi3(String mingXi3) 
    {
        this.mingXi3 = mingXi3;
    }

    public String getMingXi3() 
    {
        return mingXi3;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
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
            .append("kuWeiMingCheng", getKuWeiMingCheng())
            .append("kuWeiBianMa", getKuWeiBianMa())
            .append("kuWeiTiaoMa", getKuWeiTiaoMa())
            .append("kuWeiLeiXing", getKuWeiLeiXing())
            .append("kuWeiShuXing", getKuWeiShuXing())
            .append("shangJiaCiXu", getShangJiaCiXu())
            .append("quHuoCiXu", getQuHuoCiXu())
            .append("suoShuKeHu", getSuoShuKeHu())
            .append("tiJiDanWei", getTiJiDanWei())
            .append("zhongLiangDanWei", getZhongLiangDanWei())
            .append("mianJiDanWei", getMianJiDanWei())
            .append("zuiDaTiJi", getZuiDaTiJi())
            .append("zuiDaZhongLiang", getZuiDaZhongLiang())
            .append("zuiDaMianJi", getZuiDaMianJi())
            .append("zuiDaTuoPan", getZuiDaTuoPan())
            .append("chang", getChang())
            .append("kuan", getKuan())
            .append("gao", getGao())
            .append("tingYong", getTingYong())
            .append("mingXi", getMingXi())
            .append("binStore", getBinStore())
            .append("chpShuXing", getChpShuXing())
            .append("mingXi1", getMingXi1())
            .append("mingXi2", getMingXi2())
            .append("mingXi3", getMingXi3())
            .append("storeId", getStoreId())
            .toString();
    }
}
