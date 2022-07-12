package com.ruoyi.basicData.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品信息对象 md_goods
 *
 * @author ruoyi
 * @date 2022-07-12
 */
public class MdGoods extends BaseEntity
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

    /** 所属客户 */
    @Excel(name = "所属客户")
    private String suoShuKeHu;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String shpMingCheng;

    /** 商品简称 */
    private String shpJianCheng;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String shpBianMa;

    /** 商品型号 */
    @Excel(name = "商品型号")
    private String shpXingHao;

    /** 商品规格 */
    @Excel(name = "商品规格")
    private String shpGuiGe;

    /** 商品颜色 */
    @Excel(name = "商品颜色")
    private String shpYanSe;

    /** 产品属性 */
    @Excel(name = "产品属性")
    private String chpShuXing;

    /** 存放温层 */
    private String cfWenCeng;

    /** 拆零控制 */
    private String chlKongZhi;

    /** 码盘单层数量 */
    private String mpDanCeng;

    /** 码盘层高 */
    private String mpCengGao;

    /** 计费商品类 */
    private String jfShpLei;

    /** 商品品牌 */
    @Excel(name = "商品品牌")
    private String shpPinPai;

    /** 商品条码 */
    @Excel(name = "商品条码")
    private String shpTiaoMa;

    /** 品牌图片 */
    private String ppTuPian;

    /** 保质期 */
    @Excel(name = "保质期")
    private String bzhiQi;

    /** 单位 */
    @Excel(name = "单位")
    private String shlDanWei;

    /** 拆零单位 */
    private String jshDanWei;

    /** 体积 */
    @Excel(name = "体积")
    private String tiJiCm;

    /** 净重 */
    @Excel(name = "净重")
    private String zhlKg;

    /** 拆零数量 */
    private String chlShl;

    /** 件数与体积比 */
    private String jtiJiBi;

    /** 件数与毛重比 */
    private String jmZhongBi;

    /** 件数与净重比 */
    private String jjZhongBi;

    /** 尺寸单位 */
    private String chcDanWei;

    /** 长单品 */
    private String chDanPin;

    /** 宽单品 */
    private String kuDanPin;

    /** 高单品 */
    private String gaoDanPin;

    /** 长整箱 */
    @Excel(name = "长整箱")
    private String chZhXiang;

    /** 宽整箱 */
    @Excel(name = "宽整箱")
    private String kuZhXiang;

    /** 高整箱 */
    @Excel(name = "高整箱")
    private String gaoZhXiang;

    /** 商品描述 */
    private String shpMiaoShu;

    /** 停用 */
    private String zhuangTai;

    /** 毛重 */
    @Excel(name = "毛重")
    private String zhlKgm;

    /** 商品客户编码 */
    @Excel(name = "商品客户编码")
    private String shpBianMakh;

    /** 基准温度 */
    private String jizhunWendu;

    /** 产品大类 */
    @Excel(name = "产品大类")
    private String chpDaLei;

    /** 货主ID */
    @Excel(name = "货主ID")
    private Long supId;

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
    public void setSuoShuKeHu(String suoShuKeHu)
    {
        this.suoShuKeHu = suoShuKeHu;
    }

    public String getSuoShuKeHu()
    {
        return suoShuKeHu;
    }
    public void setShpMingCheng(String shpMingCheng)
    {
        this.shpMingCheng = shpMingCheng;
    }

    public String getShpMingCheng()
    {
        return shpMingCheng;
    }
    public void setShpJianCheng(String shpJianCheng)
    {
        this.shpJianCheng = shpJianCheng;
    }

    public String getShpJianCheng()
    {
        return shpJianCheng;
    }
    public void setShpBianMa(String shpBianMa)
    {
        this.shpBianMa = shpBianMa;
    }

    public String getShpBianMa()
    {
        return shpBianMa;
    }
    public void setShpXingHao(String shpXingHao)
    {
        this.shpXingHao = shpXingHao;
    }

    public String getShpXingHao()
    {
        return shpXingHao;
    }
    public void setShpGuiGe(String shpGuiGe)
    {
        this.shpGuiGe = shpGuiGe;
    }

    public String getShpGuiGe()
    {
        return shpGuiGe;
    }
    public void setShpYanSe(String shpYanSe)
    {
        this.shpYanSe = shpYanSe;
    }

    public String getShpYanSe()
    {
        return shpYanSe;
    }
    public void setChpShuXing(String chpShuXing)
    {
        this.chpShuXing = chpShuXing;
    }

    public String getChpShuXing()
    {
        return chpShuXing;
    }
    public void setCfWenCeng(String cfWenCeng)
    {
        this.cfWenCeng = cfWenCeng;
    }

    public String getCfWenCeng()
    {
        return cfWenCeng;
    }
    public void setChlKongZhi(String chlKongZhi)
    {
        this.chlKongZhi = chlKongZhi;
    }

    public String getChlKongZhi()
    {
        return chlKongZhi;
    }
    public void setMpDanCeng(String mpDanCeng)
    {
        this.mpDanCeng = mpDanCeng;
    }

    public String getMpDanCeng()
    {
        return mpDanCeng;
    }
    public void setMpCengGao(String mpCengGao)
    {
        this.mpCengGao = mpCengGao;
    }

    public String getMpCengGao()
    {
        return mpCengGao;
    }
    public void setJfShpLei(String jfShpLei)
    {
        this.jfShpLei = jfShpLei;
    }

    public String getJfShpLei()
    {
        return jfShpLei;
    }
    public void setShpPinPai(String shpPinPai)
    {
        this.shpPinPai = shpPinPai;
    }

    public String getShpPinPai()
    {
        return shpPinPai;
    }
    public void setShpTiaoMa(String shpTiaoMa)
    {
        this.shpTiaoMa = shpTiaoMa;
    }

    public String getShpTiaoMa()
    {
        return shpTiaoMa;
    }
    public void setPpTuPian(String ppTuPian)
    {
        this.ppTuPian = ppTuPian;
    }

    public String getPpTuPian()
    {
        return ppTuPian;
    }
    public void setBzhiQi(String bzhiQi)
    {
        this.bzhiQi = bzhiQi;
    }

    public String getBzhiQi()
    {
        return bzhiQi;
    }
    public void setShlDanWei(String shlDanWei)
    {
        this.shlDanWei = shlDanWei;
    }

    public String getShlDanWei()
    {
        return shlDanWei;
    }
    public void setJshDanWei(String jshDanWei)
    {
        this.jshDanWei = jshDanWei;
    }

    public String getJshDanWei()
    {
        return jshDanWei;
    }
    public void setTiJiCm(String tiJiCm)
    {
        this.tiJiCm = tiJiCm;
    }

    public String getTiJiCm()
    {
        return tiJiCm;
    }
    public void setZhlKg(String zhlKg)
    {
        this.zhlKg = zhlKg;
    }

    public String getZhlKg()
    {
        return zhlKg;
    }
    public void setChlShl(String chlShl)
    {
        this.chlShl = chlShl;
    }

    public String getChlShl()
    {
        return chlShl;
    }
    public void setJtiJiBi(String jtiJiBi)
    {
        this.jtiJiBi = jtiJiBi;
    }

    public String getJtiJiBi()
    {
        return jtiJiBi;
    }
    public void setJmZhongBi(String jmZhongBi)
    {
        this.jmZhongBi = jmZhongBi;
    }

    public String getJmZhongBi()
    {
        return jmZhongBi;
    }
    public void setJjZhongBi(String jjZhongBi)
    {
        this.jjZhongBi = jjZhongBi;
    }

    public String getJjZhongBi()
    {
        return jjZhongBi;
    }
    public void setChcDanWei(String chcDanWei)
    {
        this.chcDanWei = chcDanWei;
    }

    public String getChcDanWei()
    {
        return chcDanWei;
    }
    public void setChDanPin(String chDanPin)
    {
        this.chDanPin = chDanPin;
    }

    public String getChDanPin()
    {
        return chDanPin;
    }
    public void setKuDanPin(String kuDanPin)
    {
        this.kuDanPin = kuDanPin;
    }

    public String getKuDanPin()
    {
        return kuDanPin;
    }
    public void setGaoDanPin(String gaoDanPin)
    {
        this.gaoDanPin = gaoDanPin;
    }

    public String getGaoDanPin()
    {
        return gaoDanPin;
    }
    public void setChZhXiang(String chZhXiang)
    {
        this.chZhXiang = chZhXiang;
    }

    public String getChZhXiang()
    {
        return chZhXiang;
    }
    public void setKuZhXiang(String kuZhXiang)
    {
        this.kuZhXiang = kuZhXiang;
    }

    public String getKuZhXiang()
    {
        return kuZhXiang;
    }
    public void setGaoZhXiang(String gaoZhXiang)
    {
        this.gaoZhXiang = gaoZhXiang;
    }

    public String getGaoZhXiang()
    {
        return gaoZhXiang;
    }
    public void setShpMiaoShu(String shpMiaoShu)
    {
        this.shpMiaoShu = shpMiaoShu;
    }

    public String getShpMiaoShu()
    {
        return shpMiaoShu;
    }
    public void setZhuangTai(String zhuangTai)
    {
        this.zhuangTai = zhuangTai;
    }

    public String getZhuangTai()
    {
        return zhuangTai;
    }
    public void setZhlKgm(String zhlKgm)
    {
        this.zhlKgm = zhlKgm;
    }

    public String getZhlKgm()
    {
        return zhlKgm;
    }
    public void setShpBianMakh(String shpBianMakh)
    {
        this.shpBianMakh = shpBianMakh;
    }

    public String getShpBianMakh()
    {
        return shpBianMakh;
    }
    public void setJizhunWendu(String jizhunWendu)
    {
        this.jizhunWendu = jizhunWendu;
    }

    public String getJizhunWendu()
    {
        return jizhunWendu;
    }
    public void setChpDaLei(String chpDaLei)
    {
        this.chpDaLei = chpDaLei;
    }

    public String getChpDaLei()
    {
        return chpDaLei;
    }
    public void setSupId(Long supId)
    {
        this.supId = supId;
    }

    public Long getSupId()
    {
        return supId;
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
                .append("suoShuKeHu", getSuoShuKeHu())
                .append("shpMingCheng", getShpMingCheng())
                .append("shpJianCheng", getShpJianCheng())
                .append("shpBianMa", getShpBianMa())
                .append("shpXingHao", getShpXingHao())
                .append("shpGuiGe", getShpGuiGe())
                .append("shpYanSe", getShpYanSe())
                .append("chpShuXing", getChpShuXing())
                .append("cfWenCeng", getCfWenCeng())
                .append("chlKongZhi", getChlKongZhi())
                .append("mpDanCeng", getMpDanCeng())
                .append("mpCengGao", getMpCengGao())
                .append("jfShpLei", getJfShpLei())
                .append("shpPinPai", getShpPinPai())
                .append("shpTiaoMa", getShpTiaoMa())
                .append("ppTuPian", getPpTuPian())
                .append("bzhiQi", getBzhiQi())
                .append("shlDanWei", getShlDanWei())
                .append("jshDanWei", getJshDanWei())
                .append("tiJiCm", getTiJiCm())
                .append("zhlKg", getZhlKg())
                .append("chlShl", getChlShl())
                .append("jtiJiBi", getJtiJiBi())
                .append("jmZhongBi", getJmZhongBi())
                .append("jjZhongBi", getJjZhongBi())
                .append("chcDanWei", getChcDanWei())
                .append("chDanPin", getChDanPin())
                .append("kuDanPin", getKuDanPin())
                .append("gaoDanPin", getGaoDanPin())
                .append("chZhXiang", getChZhXiang())
                .append("kuZhXiang", getKuZhXiang())
                .append("gaoZhXiang", getGaoZhXiang())
                .append("shpMiaoShu", getShpMiaoShu())
                .append("zhuangTai", getZhuangTai())
                .append("zhlKgm", getZhlKgm())
                .append("shpBianMakh", getShpBianMakh())
                .append("jizhunWendu", getJizhunWendu())
                .append("chpDaLei", getChpDaLei())
                .append("supId", getSupId())
                .toString();
    }
}
