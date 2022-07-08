<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="创建人名称" prop="createName">
        <el-input
          v-model="queryParams.createName"
          placeholder="请输入创建人名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建日期" prop="createDate">
        <el-date-picker clearable
          v-model="queryParams.createDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="更新人名称" prop="updateName">
        <el-input
          v-model="queryParams.updateName"
          placeholder="请输入更新人名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="更新日期" prop="updateDate">
        <el-date-picker clearable
          v-model="queryParams.updateDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择更新日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="所属部门" prop="sysOrgCode">
        <el-input
          v-model="queryParams.sysOrgCode"
          placeholder="请输入所属部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属公司" prop="sysCompanyCode">
        <el-input
          v-model="queryParams.sysCompanyCode"
          placeholder="请输入所属公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中文全称" prop="zhongWenQch">
        <el-input
          v-model="queryParams.zhongWenQch"
          placeholder="请输入中文全称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="助记码" prop="zhuJiMa">
        <el-input
          v-model="queryParams.zhuJiMa"
          placeholder="请输入助记码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户简称" prop="keHuJianCheng">
        <el-input
          v-model="queryParams.keHuJianCheng"
          placeholder="请输入客户简称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户编码" prop="keHuBianMa">
        <el-input
          v-model="queryParams.keHuBianMa"
          placeholder="请输入客户编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户英文名称" prop="keHuYingWen">
        <el-input
          v-model="queryParams.keHuYingWen"
          placeholder="请输入客户英文名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="曾用企业代码" prop="zengYongQi">
        <el-input
          v-model="queryParams.zengYongQi"
          placeholder="请输入曾用企业代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="曾用企业名称" prop="zengYongQiYe">
        <el-input
          v-model="queryParams.zengYongQiYe"
          placeholder="请输入曾用企业名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户状态" prop="keHuZhuangTai">
        <el-input
          v-model="queryParams.keHuZhuangTai"
          placeholder="请输入客户状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业属性" prop="xingYeFenLei">
        <el-input
          v-model="queryParams.xingYeFenLei"
          placeholder="请输入企业属性"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户等级" prop="keHuDengJi">
        <el-input
          v-model="queryParams.keHuDengJi"
          placeholder="请输入客户等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属行业" prop="suoShuXingYe">
        <el-input
          v-model="queryParams.suoShuXingYe"
          placeholder="请输入所属行业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="首签日期" prop="shouQianRiQi">
        <el-date-picker clearable
          v-model="queryParams.shouQianRiQi"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择首签日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="终止合作时间" prop="zhongZhiHeShiJian">
        <el-date-picker clearable
          v-model="queryParams.zhongZhiHeShiJian"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择终止合作时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="申请时间" prop="shenQingShiJian">
        <el-date-picker clearable
          v-model="queryParams.shenQingShiJian"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择申请时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="客户属性" prop="keHuShuXing">
        <el-input
          v-model="queryParams.keHuShuXing"
          placeholder="请输入客户属性"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="归属组织代码" prop="guiShuZuZh">
        <el-input
          v-model="queryParams.guiShuZuZh"
          placeholder="请输入归属组织代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="归属省份代码" prop="guiShuSheng">
        <el-input
          v-model="queryParams.guiShuSheng"
          placeholder="请输入归属省份代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="归属市代码" prop="guiShuShiDai">
        <el-input
          v-model="queryParams.guiShuShiDai"
          placeholder="请输入归属市代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="归属县区代码" prop="guiShu">
        <el-input
          v-model="queryParams.guiShu"
          placeholder="请输入归属县区代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="diZhi">
        <el-input
          v-model="queryParams.diZhi"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮政编码" prop="youZhengBianMa">
        <el-input
          v-model="queryParams.youZhengBianMa"
          placeholder="请输入邮政编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主联系人" prop="zhuLianXiRen">
        <el-input
          v-model="queryParams.zhuLianXiRen"
          placeholder="请输入主联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="dianHua">
        <el-input
          v-model="queryParams.dianHua"
          placeholder="请输入电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机" prop="shouJi">
        <el-input
          v-model="queryParams.shouJi"
          placeholder="请输入手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="传真" prop="chuanZhen">
        <el-input
          v-model="queryParams.chuanZhen"
          placeholder="请输入传真"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Email地址" prop="emaildiZhi">
        <el-input
          v-model="queryParams.emaildiZhi"
          placeholder="请输入Email地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="网页地址" prop="wangYeDiZhi">
        <el-input
          v-model="queryParams.wangYeDiZhi"
          placeholder="请输入网页地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="法人代表" prop="faRenDaiBiao">
        <el-input
          v-model="queryParams.faRenDaiBiao"
          placeholder="请输入法人代表"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="法人身份证号" prop="faRenShenFen">
        <el-input
          v-model="queryParams.faRenShenFen"
          placeholder="请输入法人身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="注册资金万元" prop="zhuCeZiJin">
        <el-input
          v-model="queryParams.zhuCeZiJin"
          placeholder="请输入注册资金万元"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币别" prop="biBie">
        <el-input
          v-model="queryParams.biBie"
          placeholder="请输入币别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="营业执照号" prop="yingYeZhiZhao">
        <el-input
          v-model="queryParams.yingYeZhiZhao"
          placeholder="请输入营业执照号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="税务登记证号" prop="shuiWuDeng">
        <el-input
          v-model="queryParams.shuiWuDeng"
          placeholder="请输入税务登记证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="组织机构代码证" prop="zuZhiJiGou">
        <el-input
          v-model="queryParams.zuZhiJiGou"
          placeholder="请输入组织机构代码证"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="道路运输经营许可证" prop="daoLuYunShu">
        <el-input
          v-model="queryParams.daoLuYunShu"
          placeholder="请输入道路运输经营许可证"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主营业务" prop="zhuYingYeWu">
        <el-input
          v-model="queryParams.zhuYingYeWu"
          placeholder="请输入主营业务"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合作意向" prop="heYiXiang">
        <el-input
          v-model="queryParams.heYiXiang"
          placeholder="请输入合作意向"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="批准机关" prop="piZhunJiGuan">
        <el-input
          v-model="queryParams.piZhunJiGuan"
          placeholder="请输入批准机关"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="批准文号" prop="piZhunWenHao">
        <el-input
          v-model="queryParams.piZhunWenHao"
          placeholder="请输入批准文号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="注册日期" prop="zhuCeRiQi">
        <el-date-picker clearable
          v-model="queryParams.zhuCeRiQi"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择注册日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注" prop="beiZhu">
        <el-input
          v-model="queryParams.beiZhu"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人1" prop="zhuLianXiRen1">
        <el-input
          v-model="queryParams.zhuLianXiRen1"
          placeholder="请输入联系人1"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话1" prop="dianHua1">
        <el-input
          v-model="queryParams.dianHua1"
          placeholder="请输入电话1"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['basicData:cus:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['basicData:cus:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['basicData:cus:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['basicData:cus:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cusList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="创建人名称" align="center" prop="createName" />
      <el-table-column label="创建日期" align="center" prop="createDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新人名称" align="center" prop="updateName" />
      <el-table-column label="更新日期" align="center" prop="updateDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="所属部门" align="center" prop="sysOrgCode" />
      <el-table-column label="所属公司" align="center" prop="sysCompanyCode" />
      <el-table-column label="中文全称" align="center" prop="zhongWenQch" />
      <el-table-column label="助记码" align="center" prop="zhuJiMa" />
      <el-table-column label="客户简称" align="center" prop="keHuJianCheng" />
      <el-table-column label="客户编码" align="center" prop="keHuBianMa" />
      <el-table-column label="客户英文名称" align="center" prop="keHuYingWen" />
      <el-table-column label="曾用企业代码" align="center" prop="zengYongQi" />
      <el-table-column label="曾用企业名称" align="center" prop="zengYongQiYe" />
      <el-table-column label="客户状态" align="center" prop="keHuZhuangTai" />
      <el-table-column label="企业属性" align="center" prop="xingYeFenLei" />
      <el-table-column label="客户等级" align="center" prop="keHuDengJi" />
      <el-table-column label="所属行业" align="center" prop="suoShuXingYe" />
      <el-table-column label="首签日期" align="center" prop="shouQianRiQi" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.shouQianRiQi, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="终止合作时间" align="center" prop="zhongZhiHeShiJian" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.zhongZhiHeShiJian, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="申请时间" align="center" prop="shenQingShiJian" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.shenQingShiJian, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="客户属性" align="center" prop="keHuShuXing" />
      <el-table-column label="归属组织代码" align="center" prop="guiShuZuZh" />
      <el-table-column label="归属省份代码" align="center" prop="guiShuSheng" />
      <el-table-column label="归属市代码" align="center" prop="guiShuShiDai" />
      <el-table-column label="归属县区代码" align="center" prop="guiShu" />
      <el-table-column label="地址" align="center" prop="diZhi" />
      <el-table-column label="邮政编码" align="center" prop="youZhengBianMa" />
      <el-table-column label="主联系人" align="center" prop="zhuLianXiRen" />
      <el-table-column label="电话" align="center" prop="dianHua" />
      <el-table-column label="手机" align="center" prop="shouJi" />
      <el-table-column label="传真" align="center" prop="chuanZhen" />
      <el-table-column label="Email地址" align="center" prop="emaildiZhi" />
      <el-table-column label="网页地址" align="center" prop="wangYeDiZhi" />
      <el-table-column label="法人代表" align="center" prop="faRenDaiBiao" />
      <el-table-column label="法人身份证号" align="center" prop="faRenShenFen" />
      <el-table-column label="注册资金万元" align="center" prop="zhuCeZiJin" />
      <el-table-column label="币别" align="center" prop="biBie" />
      <el-table-column label="营业执照号" align="center" prop="yingYeZhiZhao" />
      <el-table-column label="税务登记证号" align="center" prop="shuiWuDeng" />
      <el-table-column label="组织机构代码证" align="center" prop="zuZhiJiGou" />
      <el-table-column label="道路运输经营许可证" align="center" prop="daoLuYunShu" />
      <el-table-column label="主营业务" align="center" prop="zhuYingYeWu" />
      <el-table-column label="合作意向" align="center" prop="heYiXiang" />
      <el-table-column label="批准机关" align="center" prop="piZhunJiGuan" />
      <el-table-column label="批准文号" align="center" prop="piZhunWenHao" />
      <el-table-column label="注册日期" align="center" prop="zhuCeRiQi" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.zhuCeRiQi, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="beiZhu" />
      <el-table-column label="联系人1" align="center" prop="zhuLianXiRen1" />
      <el-table-column label="电话1" align="center" prop="dianHua1" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['basicData:cus:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['basicData:cus:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改客户信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="创建人名称" prop="createName">
          <el-input v-model="form.createName" placeholder="请输入创建人名称" />
        </el-form-item>
        <el-form-item label="创建日期" prop="createDate">
          <el-date-picker clearable
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="更新人名称" prop="updateName">
          <el-input v-model="form.updateName" placeholder="请输入更新人名称" />
        </el-form-item>
        <el-form-item label="更新日期" prop="updateDate">
          <el-date-picker clearable
            v-model="form.updateDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择更新日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="所属部门" prop="sysOrgCode">
          <el-input v-model="form.sysOrgCode" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="所属公司" prop="sysCompanyCode">
          <el-input v-model="form.sysCompanyCode" placeholder="请输入所属公司" />
        </el-form-item>
        <el-form-item label="中文全称" prop="zhongWenQch">
          <el-input v-model="form.zhongWenQch" placeholder="请输入中文全称" />
        </el-form-item>
        <el-form-item label="助记码" prop="zhuJiMa">
          <el-input v-model="form.zhuJiMa" placeholder="请输入助记码" />
        </el-form-item>
        <el-form-item label="客户简称" prop="keHuJianCheng">
          <el-input v-model="form.keHuJianCheng" placeholder="请输入客户简称" />
        </el-form-item>
        <el-form-item label="客户编码" prop="keHuBianMa">
          <el-input v-model="form.keHuBianMa" placeholder="请输入客户编码" />
        </el-form-item>
        <el-form-item label="客户英文名称" prop="keHuYingWen">
          <el-input v-model="form.keHuYingWen" placeholder="请输入客户英文名称" />
        </el-form-item>
        <el-form-item label="曾用企业代码" prop="zengYongQi">
          <el-input v-model="form.zengYongQi" placeholder="请输入曾用企业代码" />
        </el-form-item>
        <el-form-item label="曾用企业名称" prop="zengYongQiYe">
          <el-input v-model="form.zengYongQiYe" placeholder="请输入曾用企业名称" />
        </el-form-item>
        <el-form-item label="客户状态" prop="keHuZhuangTai">
          <el-input v-model="form.keHuZhuangTai" placeholder="请输入客户状态" />
        </el-form-item>
        <el-form-item label="企业属性" prop="xingYeFenLei">
          <el-input v-model="form.xingYeFenLei" placeholder="请输入企业属性" />
        </el-form-item>
        <el-form-item label="客户等级" prop="keHuDengJi">
          <el-input v-model="form.keHuDengJi" placeholder="请输入客户等级" />
        </el-form-item>
        <el-form-item label="所属行业" prop="suoShuXingYe">
          <el-input v-model="form.suoShuXingYe" placeholder="请输入所属行业" />
        </el-form-item>
        <el-form-item label="首签日期" prop="shouQianRiQi">
          <el-date-picker clearable
            v-model="form.shouQianRiQi"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择首签日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="终止合作时间" prop="zhongZhiHeShiJian">
          <el-date-picker clearable
            v-model="form.zhongZhiHeShiJian"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择终止合作时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请时间" prop="shenQingShiJian">
          <el-date-picker clearable
            v-model="form.shenQingShiJian"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="客户属性" prop="keHuShuXing">
          <el-input v-model="form.keHuShuXing" placeholder="请输入客户属性" />
        </el-form-item>
        <el-form-item label="归属组织代码" prop="guiShuZuZh">
          <el-input v-model="form.guiShuZuZh" placeholder="请输入归属组织代码" />
        </el-form-item>
        <el-form-item label="归属省份代码" prop="guiShuSheng">
          <el-input v-model="form.guiShuSheng" placeholder="请输入归属省份代码" />
        </el-form-item>
        <el-form-item label="归属市代码" prop="guiShuShiDai">
          <el-input v-model="form.guiShuShiDai" placeholder="请输入归属市代码" />
        </el-form-item>
        <el-form-item label="归属县区代码" prop="guiShu">
          <el-input v-model="form.guiShu" placeholder="请输入归属县区代码" />
        </el-form-item>
        <el-form-item label="地址" prop="diZhi">
          <el-input v-model="form.diZhi" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="邮政编码" prop="youZhengBianMa">
          <el-input v-model="form.youZhengBianMa" placeholder="请输入邮政编码" />
        </el-form-item>
        <el-form-item label="主联系人" prop="zhuLianXiRen">
          <el-input v-model="form.zhuLianXiRen" placeholder="请输入主联系人" />
        </el-form-item>
        <el-form-item label="电话" prop="dianHua">
          <el-input v-model="form.dianHua" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="手机" prop="shouJi">
          <el-input v-model="form.shouJi" placeholder="请输入手机" />
        </el-form-item>
        <el-form-item label="传真" prop="chuanZhen">
          <el-input v-model="form.chuanZhen" placeholder="请输入传真" />
        </el-form-item>
        <el-form-item label="Email地址" prop="emaildiZhi">
          <el-input v-model="form.emaildiZhi" placeholder="请输入Email地址" />
        </el-form-item>
        <el-form-item label="网页地址" prop="wangYeDiZhi">
          <el-input v-model="form.wangYeDiZhi" placeholder="请输入网页地址" />
        </el-form-item>
        <el-form-item label="法人代表" prop="faRenDaiBiao">
          <el-input v-model="form.faRenDaiBiao" placeholder="请输入法人代表" />
        </el-form-item>
        <el-form-item label="法人身份证号" prop="faRenShenFen">
          <el-input v-model="form.faRenShenFen" placeholder="请输入法人身份证号" />
        </el-form-item>
        <el-form-item label="注册资金万元" prop="zhuCeZiJin">
          <el-input v-model="form.zhuCeZiJin" placeholder="请输入注册资金万元" />
        </el-form-item>
        <el-form-item label="币别" prop="biBie">
          <el-input v-model="form.biBie" placeholder="请输入币别" />
        </el-form-item>
        <el-form-item label="营业执照号" prop="yingYeZhiZhao">
          <el-input v-model="form.yingYeZhiZhao" placeholder="请输入营业执照号" />
        </el-form-item>
        <el-form-item label="税务登记证号" prop="shuiWuDeng">
          <el-input v-model="form.shuiWuDeng" placeholder="请输入税务登记证号" />
        </el-form-item>
        <el-form-item label="组织机构代码证" prop="zuZhiJiGou">
          <el-input v-model="form.zuZhiJiGou" placeholder="请输入组织机构代码证" />
        </el-form-item>
        <el-form-item label="道路运输经营许可证" prop="daoLuYunShu">
          <el-input v-model="form.daoLuYunShu" placeholder="请输入道路运输经营许可证" />
        </el-form-item>
        <el-form-item label="主营业务" prop="zhuYingYeWu">
          <el-input v-model="form.zhuYingYeWu" placeholder="请输入主营业务" />
        </el-form-item>
        <el-form-item label="合作意向" prop="heYiXiang">
          <el-input v-model="form.heYiXiang" placeholder="请输入合作意向" />
        </el-form-item>
        <el-form-item label="批准机关" prop="piZhunJiGuan">
          <el-input v-model="form.piZhunJiGuan" placeholder="请输入批准机关" />
        </el-form-item>
        <el-form-item label="批准文号" prop="piZhunWenHao">
          <el-input v-model="form.piZhunWenHao" placeholder="请输入批准文号" />
        </el-form-item>
        <el-form-item label="注册日期" prop="zhuCeRiQi">
          <el-date-picker clearable
            v-model="form.zhuCeRiQi"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择注册日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="beiZhu">
          <el-input v-model="form.beiZhu" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="联系人1" prop="zhuLianXiRen1">
          <el-input v-model="form.zhuLianXiRen1" placeholder="请输入联系人1" />
        </el-form-item>
        <el-form-item label="电话1" prop="dianHua1">
          <el-input v-model="form.dianHua1" placeholder="请输入电话1" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCus, getCus, delCus, addCus, updateCus } from "@/api/basicData/cus";

export default {
  name: "Cus",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 客户信息表格数据
      cusList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        createName: null,
        createDate: null,
        updateName: null,
        updateDate: null,
        sysOrgCode: null,
        sysCompanyCode: null,
        zhongWenQch: null,
        zhuJiMa: null,
        keHuJianCheng: null,
        keHuBianMa: null,
        keHuYingWen: null,
        zengYongQi: null,
        zengYongQiYe: null,
        keHuZhuangTai: null,
        xingYeFenLei: null,
        keHuDengJi: null,
        suoShuXingYe: null,
        shouQianRiQi: null,
        zhongZhiHeShiJian: null,
        shenQingShiJian: null,
        keHuShuXing: null,
        guiShuZuZh: null,
        guiShuSheng: null,
        guiShuShiDai: null,
        guiShu: null,
        diZhi: null,
        youZhengBianMa: null,
        zhuLianXiRen: null,
        dianHua: null,
        shouJi: null,
        chuanZhen: null,
        emaildiZhi: null,
        wangYeDiZhi: null,
        faRenDaiBiao: null,
        faRenShenFen: null,
        zhuCeZiJin: null,
        biBie: null,
        yingYeZhiZhao: null,
        shuiWuDeng: null,
        zuZhiJiGou: null,
        daoLuYunShu: null,
        zhuYingYeWu: null,
        heYiXiang: null,
        piZhunJiGuan: null,
        piZhunWenHao: null,
        zhuCeRiQi: null,
        beiZhu: null,
        zhuLianXiRen1: null,
        dianHua1: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询客户信息列表 */
    getList() {
      this.loading = true;
      listCus(this.queryParams).then(response => {
        this.cusList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        createName: null,
        createBy: null,
        createDate: null,
        updateName: null,
        updateBy: null,
        updateDate: null,
        sysOrgCode: null,
        sysCompanyCode: null,
        zhongWenQch: null,
        zhuJiMa: null,
        keHuJianCheng: null,
        keHuBianMa: null,
        keHuYingWen: null,
        zengYongQi: null,
        zengYongQiYe: null,
        keHuZhuangTai: null,
        xingYeFenLei: null,
        keHuDengJi: null,
        suoShuXingYe: null,
        shouQianRiQi: null,
        zhongZhiHeShiJian: null,
        shenQingShiJian: null,
        keHuShuXing: null,
        guiShuZuZh: null,
        guiShuSheng: null,
        guiShuShiDai: null,
        guiShu: null,
        diZhi: null,
        youZhengBianMa: null,
        zhuLianXiRen: null,
        dianHua: null,
        shouJi: null,
        chuanZhen: null,
        emaildiZhi: null,
        wangYeDiZhi: null,
        faRenDaiBiao: null,
        faRenShenFen: null,
        zhuCeZiJin: null,
        biBie: null,
        yingYeZhiZhao: null,
        shuiWuDeng: null,
        zuZhiJiGou: null,
        daoLuYunShu: null,
        zhuYingYeWu: null,
        heYiXiang: null,
        piZhunJiGuan: null,
        piZhunWenHao: null,
        zhuCeRiQi: null,
        beiZhu: null,
        zhuLianXiRen1: null,
        dianHua1: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加客户信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCus(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改客户信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCus(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCus(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除客户信息编号为"' + ids + '"的数据项？').then(function() {
        return delCus(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('basicData/cus/export', {
        ...this.queryParams
      }, `cus_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
