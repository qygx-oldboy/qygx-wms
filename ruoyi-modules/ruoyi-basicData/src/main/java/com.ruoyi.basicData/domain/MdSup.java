package com.ruoyi.basicData.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商对象 md_sup
 * 
 * @author ruoyi
 * @date 2022-07-11
 */
public class MdSup extends BaseEntity
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

    /** 中文全称 */
    @Excel(name = "中文全称")
    private String zhongWenQch;

    /** 助记码 */
    private String zhuJiMa;

    /** 供应商简称 */
    private String gysJianCheng;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String gysBianMa;

    /** 供应商英文名称 */
    private String gysYingWen;

    /** 曾用企业代码 */
    private String zengYongQi;

    /** 曾用企业名称 */
    private String zengYongQiYe;

    /** 停用 */
    private String gysZhuangTai;

    /** 企业属性 */
    private String xingYeFenLei;

    /** 供应商等级 */
    private String gysDengJi;

    /** 所属行业 */
    private String suoShuXingYe;

    /** 首签日期 */
    private Date shouQianRiQi;

    /** 终止合作时间 */
    private Date zhongZhiHeShiJian;

    /** 申请时间 */
    private Date shenQingShiJian;

    /** 供应商属性 */
    private String gysShuXing;

    /** 归属组织代码 */
    private String guiShuZuZh;

    /** 归属省份代码 */
    private String guiShuSheng;

    /** 归属市代码 */
    private String guiShuShiDai;

    /** 归属县区代码 */
    private String guiShu;

    /** 地址 */
    @Excel(name = "地址")
    private String diZhi;

    /** 邮政编码 */
    private String youZhengBianMa;

    /** 主联系人 */
    @Excel(name = "主联系人")
    private String zhuLianXiRen;

    /** 电话 */
    @Excel(name = "电话")
    private String dianHua;

    /** 手机 */
    @Excel(name = "手机")
    private String shouJi;

    /** 传真 */
    private String chuanZhen;

    /** Email地址 */
    @Excel(name = "Email地址")
    private String emaildiZhi;

    /** 网页地址 */
    private String wangYeDiZhi;

    /** 法人代表 */
    private String faRenDaiBiao;

    /** 法人身份证号 */
    private String faRenShenFen;

    /** 注册资金万元 */
    private String zhuCeZiJin;

    /** 币别 */
    private String biBie;

    /** 营业执照号 */
    private String yingYeZhiZhao;

    /** 税务登记证号 */
    private String shuiWuDeng;

    /** 组织机构代码证 */
    private String zuZhiJiGou;

    /** 道路运输经营许可证 */
    private String daoLuYunShu;

    /** 主营业务 */
    private String zhuYingYeWu;

    /** 合作意向 */
    private String heYiXiang;

    /** 批准机关 */
    private String piZhunJiGuan;

    /** 批准文号 */
    private String piZhunWenHao;

    /** 注册日期 */
    private Date zhuCeRiQi;

    /** 备注 */
    @Excel(name = "备注")
    private String beiZhu;

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
    public void setZhongWenQch(String zhongWenQch) 
    {
        this.zhongWenQch = zhongWenQch;
    }

    public String getZhongWenQch() 
    {
        return zhongWenQch;
    }
    public void setZhuJiMa(String zhuJiMa) 
    {
        this.zhuJiMa = zhuJiMa;
    }

    public String getZhuJiMa() 
    {
        return zhuJiMa;
    }
    public void setGysJianCheng(String gysJianCheng) 
    {
        this.gysJianCheng = gysJianCheng;
    }

    public String getGysJianCheng() 
    {
        return gysJianCheng;
    }
    public void setGysBianMa(String gysBianMa) 
    {
        this.gysBianMa = gysBianMa;
    }

    public String getGysBianMa() 
    {
        return gysBianMa;
    }
    public void setGysYingWen(String gysYingWen) 
    {
        this.gysYingWen = gysYingWen;
    }

    public String getGysYingWen() 
    {
        return gysYingWen;
    }
    public void setZengYongQi(String zengYongQi) 
    {
        this.zengYongQi = zengYongQi;
    }

    public String getZengYongQi() 
    {
        return zengYongQi;
    }
    public void setZengYongQiYe(String zengYongQiYe) 
    {
        this.zengYongQiYe = zengYongQiYe;
    }

    public String getZengYongQiYe() 
    {
        return zengYongQiYe;
    }
    public void setGysZhuangTai(String gysZhuangTai) 
    {
        this.gysZhuangTai = gysZhuangTai;
    }

    public String getGysZhuangTai() 
    {
        return gysZhuangTai;
    }
    public void setXingYeFenLei(String xingYeFenLei) 
    {
        this.xingYeFenLei = xingYeFenLei;
    }

    public String getXingYeFenLei() 
    {
        return xingYeFenLei;
    }
    public void setGysDengJi(String gysDengJi) 
    {
        this.gysDengJi = gysDengJi;
    }

    public String getGysDengJi() 
    {
        return gysDengJi;
    }
    public void setSuoShuXingYe(String suoShuXingYe) 
    {
        this.suoShuXingYe = suoShuXingYe;
    }

    public String getSuoShuXingYe() 
    {
        return suoShuXingYe;
    }
    public void setShouQianRiQi(Date shouQianRiQi) 
    {
        this.shouQianRiQi = shouQianRiQi;
    }

    public Date getShouQianRiQi() 
    {
        return shouQianRiQi;
    }
    public void setZhongZhiHeShiJian(Date zhongZhiHeShiJian) 
    {
        this.zhongZhiHeShiJian = zhongZhiHeShiJian;
    }

    public Date getZhongZhiHeShiJian() 
    {
        return zhongZhiHeShiJian;
    }
    public void setShenQingShiJian(Date shenQingShiJian) 
    {
        this.shenQingShiJian = shenQingShiJian;
    }

    public Date getShenQingShiJian() 
    {
        return shenQingShiJian;
    }
    public void setGysShuXing(String gysShuXing) 
    {
        this.gysShuXing = gysShuXing;
    }

    public String getGysShuXing() 
    {
        return gysShuXing;
    }
    public void setGuiShuZuZh(String guiShuZuZh) 
    {
        this.guiShuZuZh = guiShuZuZh;
    }

    public String getGuiShuZuZh() 
    {
        return guiShuZuZh;
    }
    public void setGuiShuSheng(String guiShuSheng) 
    {
        this.guiShuSheng = guiShuSheng;
    }

    public String getGuiShuSheng() 
    {
        return guiShuSheng;
    }
    public void setGuiShuShiDai(String guiShuShiDai) 
    {
        this.guiShuShiDai = guiShuShiDai;
    }

    public String getGuiShuShiDai() 
    {
        return guiShuShiDai;
    }
    public void setGuiShu(String guiShu) 
    {
        this.guiShu = guiShu;
    }

    public String getGuiShu() 
    {
        return guiShu;
    }
    public void setDiZhi(String diZhi) 
    {
        this.diZhi = diZhi;
    }

    public String getDiZhi() 
    {
        return diZhi;
    }
    public void setYouZhengBianMa(String youZhengBianMa) 
    {
        this.youZhengBianMa = youZhengBianMa;
    }

    public String getYouZhengBianMa() 
    {
        return youZhengBianMa;
    }
    public void setZhuLianXiRen(String zhuLianXiRen) 
    {
        this.zhuLianXiRen = zhuLianXiRen;
    }

    public String getZhuLianXiRen() 
    {
        return zhuLianXiRen;
    }
    public void setDianHua(String dianHua) 
    {
        this.dianHua = dianHua;
    }

    public String getDianHua() 
    {
        return dianHua;
    }
    public void setShouJi(String shouJi) 
    {
        this.shouJi = shouJi;
    }

    public String getShouJi() 
    {
        return shouJi;
    }
    public void setChuanZhen(String chuanZhen) 
    {
        this.chuanZhen = chuanZhen;
    }

    public String getChuanZhen() 
    {
        return chuanZhen;
    }
    public void setEmaildiZhi(String emaildiZhi) 
    {
        this.emaildiZhi = emaildiZhi;
    }

    public String getEmaildiZhi() 
    {
        return emaildiZhi;
    }
    public void setWangYeDiZhi(String wangYeDiZhi) 
    {
        this.wangYeDiZhi = wangYeDiZhi;
    }

    public String getWangYeDiZhi() 
    {
        return wangYeDiZhi;
    }
    public void setFaRenDaiBiao(String faRenDaiBiao) 
    {
        this.faRenDaiBiao = faRenDaiBiao;
    }

    public String getFaRenDaiBiao() 
    {
        return faRenDaiBiao;
    }
    public void setFaRenShenFen(String faRenShenFen) 
    {
        this.faRenShenFen = faRenShenFen;
    }

    public String getFaRenShenFen() 
    {
        return faRenShenFen;
    }
    public void setZhuCeZiJin(String zhuCeZiJin) 
    {
        this.zhuCeZiJin = zhuCeZiJin;
    }

    public String getZhuCeZiJin() 
    {
        return zhuCeZiJin;
    }
    public void setBiBie(String biBie) 
    {
        this.biBie = biBie;
    }

    public String getBiBie() 
    {
        return biBie;
    }
    public void setYingYeZhiZhao(String yingYeZhiZhao) 
    {
        this.yingYeZhiZhao = yingYeZhiZhao;
    }

    public String getYingYeZhiZhao() 
    {
        return yingYeZhiZhao;
    }
    public void setShuiWuDeng(String shuiWuDeng) 
    {
        this.shuiWuDeng = shuiWuDeng;
    }

    public String getShuiWuDeng() 
    {
        return shuiWuDeng;
    }
    public void setZuZhiJiGou(String zuZhiJiGou) 
    {
        this.zuZhiJiGou = zuZhiJiGou;
    }

    public String getZuZhiJiGou() 
    {
        return zuZhiJiGou;
    }
    public void setDaoLuYunShu(String daoLuYunShu) 
    {
        this.daoLuYunShu = daoLuYunShu;
    }

    public String getDaoLuYunShu() 
    {
        return daoLuYunShu;
    }
    public void setZhuYingYeWu(String zhuYingYeWu) 
    {
        this.zhuYingYeWu = zhuYingYeWu;
    }

    public String getZhuYingYeWu() 
    {
        return zhuYingYeWu;
    }
    public void setHeYiXiang(String heYiXiang) 
    {
        this.heYiXiang = heYiXiang;
    }

    public String getHeYiXiang() 
    {
        return heYiXiang;
    }
    public void setPiZhunJiGuan(String piZhunJiGuan) 
    {
        this.piZhunJiGuan = piZhunJiGuan;
    }

    public String getPiZhunJiGuan() 
    {
        return piZhunJiGuan;
    }
    public void setPiZhunWenHao(String piZhunWenHao) 
    {
        this.piZhunWenHao = piZhunWenHao;
    }

    public String getPiZhunWenHao() 
    {
        return piZhunWenHao;
    }
    public void setZhuCeRiQi(Date zhuCeRiQi) 
    {
        this.zhuCeRiQi = zhuCeRiQi;
    }

    public Date getZhuCeRiQi() 
    {
        return zhuCeRiQi;
    }
    public void setBeiZhu(String beiZhu) 
    {
        this.beiZhu = beiZhu;
    }

    public String getBeiZhu() 
    {
        return beiZhu;
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
            .append("zhongWenQch", getZhongWenQch())
            .append("zhuJiMa", getZhuJiMa())
            .append("gysJianCheng", getGysJianCheng())
            .append("gysBianMa", getGysBianMa())
            .append("gysYingWen", getGysYingWen())
            .append("zengYongQi", getZengYongQi())
            .append("zengYongQiYe", getZengYongQiYe())
            .append("gysZhuangTai", getGysZhuangTai())
            .append("xingYeFenLei", getXingYeFenLei())
            .append("gysDengJi", getGysDengJi())
            .append("suoShuXingYe", getSuoShuXingYe())
            .append("shouQianRiQi", getShouQianRiQi())
            .append("zhongZhiHeShiJian", getZhongZhiHeShiJian())
            .append("shenQingShiJian", getShenQingShiJian())
            .append("gysShuXing", getGysShuXing())
            .append("guiShuZuZh", getGuiShuZuZh())
            .append("guiShuSheng", getGuiShuSheng())
            .append("guiShuShiDai", getGuiShuShiDai())
            .append("guiShu", getGuiShu())
            .append("diZhi", getDiZhi())
            .append("youZhengBianMa", getYouZhengBianMa())
            .append("zhuLianXiRen", getZhuLianXiRen())
            .append("dianHua", getDianHua())
            .append("shouJi", getShouJi())
            .append("chuanZhen", getChuanZhen())
            .append("emaildiZhi", getEmaildiZhi())
            .append("wangYeDiZhi", getWangYeDiZhi())
            .append("faRenDaiBiao", getFaRenDaiBiao())
            .append("faRenShenFen", getFaRenShenFen())
            .append("zhuCeZiJin", getZhuCeZiJin())
            .append("biBie", getBiBie())
            .append("yingYeZhiZhao", getYingYeZhiZhao())
            .append("shuiWuDeng", getShuiWuDeng())
            .append("zuZhiJiGou", getZuZhiJiGou())
            .append("daoLuYunShu", getDaoLuYunShu())
            .append("zhuYingYeWu", getZhuYingYeWu())
            .append("heYiXiang", getHeYiXiang())
            .append("piZhunJiGuan", getPiZhunJiGuan())
            .append("piZhunWenHao", getPiZhunWenHao())
            .append("zhuCeRiQi", getZhuCeRiQi())
            .append("beiZhu", getBeiZhu())
            .toString();
    }
}
