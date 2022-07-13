<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
      <el-form-item label="客户编码" prop="cusCode">
        <el-input
          v-model="queryParams.cusCode"
          placeholder="请输入客户编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预计到货时间" prop="imData">
        <el-date-picker clearable
          v-model="queryParams.imData"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预计到货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="客户订单号" prop="imCusCode">
        <el-input
          v-model="queryParams.imCusCode"
          placeholder="请输入客户订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机" prop="imCarDri">
        <el-input
          v-model="queryParams.imCarDri"
          placeholder="请输入司机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机电话" prop="imCarMobile">
        <el-input
          v-model="queryParams.imCarMobile"
          placeholder="请输入司机电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车号" prop="imCarNo">
        <el-input
          v-model="queryParams.imCarNo"
          placeholder="请输入车号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单类型" prop="orderTypeCode">
        <el-input
          v-model="queryParams.orderTypeCode"
          placeholder="请输入订单类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="月台" prop="platformCode">
        <el-input
          v-model="queryParams.platformCode"
          placeholder="请输入月台"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="imBeizhu">
        <el-input
          v-model="queryParams.imBeizhu"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单据状态" prop="imSta">
        <el-input
          v-model="queryParams.imSta"
          placeholder="请输入单据状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="进货通知单号" prop="noticeId">
        <el-input
          v-model="queryParams.noticeId"
          placeholder="请输入进货通知单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="附件" prop="fuJian">
        <el-input
          v-model="queryParams.fuJian"
          placeholder="请输入附件"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商编码" prop="supCode">
        <el-input
          v-model="queryParams.supCode"
          placeholder="请输入供应商编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商名称" prop="supName">
        <el-input
          v-model="queryParams.supName"
          placeholder="请输入供应商名称"
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
          v-hasPermi="['entry:imNoticeH:add']"
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
          v-hasPermi="['entry:imNoticeH:edit']"
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
          v-hasPermi="['entry:imNoticeH:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['entry:imNoticeH:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="imNoticeHList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="所属部门" align="center" prop="sysOrgCode" />
      <el-table-column label="所属公司" align="center" prop="sysCompanyCode" />
      <el-table-column label="客户编码" align="center" prop="cusCode" />
      <el-table-column label="预计到货时间" align="center" prop="imData" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.imData, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="客户订单号" align="center" prop="imCusCode" />
      <el-table-column label="司机" align="center" prop="imCarDri" />
      <el-table-column label="司机电话" align="center" prop="imCarMobile" />
      <el-table-column label="车号" align="center" prop="imCarNo" />
      <el-table-column label="订单类型" align="center" prop="orderTypeCode" />
      <el-table-column label="月台" align="center" prop="platformCode" />
      <el-table-column label="备注" align="center" prop="imBeizhu" />
      <el-table-column label="单据状态" align="center" prop="imSta" />
      <el-table-column label="进货通知单号" align="center" prop="noticeId" />
      <el-table-column label="附件" align="center" prop="fuJian" />
      <el-table-column label="供应商编码" align="center" prop="supCode" />
      <el-table-column label="供应商名称" align="center" prop="supName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['entry:imNoticeH:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['entry:imNoticeH:remove']"
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

    <!-- 添加或修改预约通知抬头对话框 -->
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
        <el-form-item label="所属部门" prop="sysOrgCode">
          <el-input v-model="form.sysOrgCode" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="所属公司" prop="sysCompanyCode">
          <el-input v-model="form.sysCompanyCode" placeholder="请输入所属公司" />
        </el-form-item>
        <el-form-item label="客户编码" prop="cusCode">
          <el-input v-model="form.cusCode" placeholder="请输入客户编码" />
        </el-form-item>
        <el-form-item label="预计到货时间" prop="imData">
          <el-date-picker clearable
            v-model="form.imData"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计到货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="客户订单号" prop="imCusCode">
          <el-input v-model="form.imCusCode" placeholder="请输入客户订单号" />
        </el-form-item>
        <el-form-item label="司机" prop="imCarDri">
          <el-input v-model="form.imCarDri" placeholder="请输入司机" />
        </el-form-item>
        <el-form-item label="司机电话" prop="imCarMobile">
          <el-input v-model="form.imCarMobile" placeholder="请输入司机电话" />
        </el-form-item>
        <el-form-item label="车号" prop="imCarNo">
          <el-input v-model="form.imCarNo" placeholder="请输入车号" />
        </el-form-item>
        <el-form-item label="订单类型" prop="orderTypeCode">
          <el-input v-model="form.orderTypeCode" placeholder="请输入订单类型" />
        </el-form-item>
        <el-form-item label="月台" prop="platformCode">
          <el-input v-model="form.platformCode" placeholder="请输入月台" />
        </el-form-item>
        <el-form-item label="备注" prop="imBeizhu">
          <el-input v-model="form.imBeizhu" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="单据状态" prop="imSta">
          <el-input v-model="form.imSta" placeholder="请输入单据状态" />
        </el-form-item>
        <el-form-item label="进货通知单号" prop="noticeId">
          <el-input v-model="form.noticeId" placeholder="请输入进货通知单号" />
        </el-form-item>
        <el-form-item label="附件" prop="fuJian">
          <el-input v-model="form.fuJian" placeholder="请输入附件" />
        </el-form-item>
        <el-form-item label="供应商编码" prop="supCode">
          <el-input v-model="form.supCode" placeholder="请输入供应商编码" />
        </el-form-item>
        <el-form-item label="供应商名称" prop="supName">
          <el-input v-model="form.supName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-divider content-position="center">预约进货行项目信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddWmImNoticeI">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteWmImNoticeI">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="wmImNoticeIList" :row-class-name="rowWmImNoticeIIndex" @selection-change="handleWmImNoticeISelectionChange" ref="wmImNoticeI">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="创建人名称" prop="createName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.createName" placeholder="请输入创建人名称" />
            </template>
          </el-table-column>
          <el-table-column label="创建日期" prop="createDate" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.createDate" type="date" value-format="yyyy-MM-dd" placeholder="请选择创建日期" />
            </template>
          </el-table-column>
          <el-table-column label="更新人名称" prop="updateName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.updateName" placeholder="请输入更新人名称" />
            </template>
          </el-table-column>
          <el-table-column label="更新日期" prop="updateDate" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.updateDate" type="date" value-format="yyyy-MM-dd" placeholder="请选择更新日期" />
            </template>
          </el-table-column>
          <el-table-column label="所属部门" prop="sysOrgCode" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.sysOrgCode" placeholder="请输入所属部门" />
            </template>
          </el-table-column>
          <el-table-column label="所属公司" prop="sysCompanyCode" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.sysCompanyCode" placeholder="请输入所属公司" />
            </template>
          </el-table-column>
          <el-table-column label="到货通知单号" prop="imNoticeId" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.imNoticeId" placeholder="请输入到货通知单号" />
            </template>
          </el-table-column>
          <el-table-column label="到货通知项目" prop="imNoticeItem" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.imNoticeItem" placeholder="请输入到货通知项目" />
            </template>
          </el-table-column>
          <el-table-column label="商品编码" prop="goodsCode" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsCode" placeholder="请输入商品编码" />
            </template>
          </el-table-column>
          <el-table-column label="数量" prop="goodsCount" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsCount" placeholder="请输入数量" />
            </template>
          </el-table-column>
          <el-table-column label="生产日期" prop="goodsPrdData" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.goodsPrdData" type="date" value-format="yyyy-MM-dd" placeholder="请选择生产日期" />
            </template>
          </el-table-column>
          <el-table-column label="批次" prop="goodsBatch" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsBatch" placeholder="请输入批次" />
            </template>
          </el-table-column>
          <el-table-column label="库位整理" prop="binPre" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.binPre" placeholder="请输入库位整理" />
            </template>
          </el-table-column>
          <el-table-column label="体积" prop="goodsFvol" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsFvol" placeholder="请输入体积" />
            </template>
          </el-table-column>
          <el-table-column label="重量" prop="goodsWeight" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsWeight" placeholder="请输入重量" />
            </template>
          </el-table-column>
          <el-table-column label="计划库位" prop="binPlan" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.binPlan" placeholder="请输入计划库位" />
            </template>
          </el-table-column>
          <el-table-column label="单位" prop="goodsUnit" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsUnit" placeholder="请输入单位" />
            </template>
          </el-table-column>
          <el-table-column label="未清数量" prop="goodsWqmCount" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsWqmCount" placeholder="请输入未清数量" />
            </template>
          </el-table-column>
          <el-table-column label="批量收货数量" prop="goodsQmCount" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsQmCount" placeholder="请输入批量收货数量" />
            </template>
          </el-table-column>
          <el-table-column label="行项目状态" prop="noticeiSta" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.noticeiSta" placeholder="请输入行项目状态" />
            </template>
          </el-table-column>
          <el-table-column label="基本单位" prop="baseUnit" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.baseUnit" placeholder="请输入基本单位" />
            </template>
          </el-table-column>
          <el-table-column label="基本单位数量" prop="baseGoodscount" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.baseGoodscount" placeholder="请输入基本单位数量" />
            </template>
          </el-table-column>
          <el-table-column label="基本单位收货数量" prop="baseQmcount" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.baseQmcount" placeholder="请输入基本单位收货数量" />
            </template>
          </el-table-column>
          <el-table-column label="商品名称" prop="goodsName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.goodsName" placeholder="请输入商品名称" />
            </template>
          </el-table-column>
          <el-table-column label="第三方客户ID" prop="otherId" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.otherId" placeholder="请输入第三方客户ID" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listImNoticeH, getImNoticeH, delImNoticeH, addImNoticeH, updateImNoticeH } from "@/api/entry/imNoticeH";

export default {
  name: "ImNoticeH",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedWmImNoticeI: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 预约通知抬头表格数据
      imNoticeHList: [],
      // 预约进货行项目表格数据
      wmImNoticeIList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sysOrgCode: null,
        sysCompanyCode: null,
        cusCode: null,
        imData: null,
        imCusCode: null,
        imCarDri: null,
        imCarMobile: null,
        imCarNo: null,
        orderTypeCode: null,
        platformCode: null,
        imBeizhu: null,
        imSta: null,
        noticeId: null,
        fuJian: null,
        supCode: null,
        supName: null
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
    /** 查询预约通知抬头列表 */
    getList() {
      this.loading = true;
      listImNoticeH(this.queryParams).then(response => {
        this.imNoticeHList = response.rows;
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
        cusCode: null,
        imData: null,
        imCusCode: null,
        imCarDri: null,
        imCarMobile: null,
        imCarNo: null,
        orderTypeCode: null,
        platformCode: null,
        imBeizhu: null,
        imSta: null,
        noticeId: null,
        fuJian: null,
        supCode: null,
        supName: null
      };
      this.wmImNoticeIList = [];
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
      this.title = "添加预约通知抬头";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getImNoticeH(id).then(response => {
        this.form = response.data;
        this.wmImNoticeIList = response.data.wmImNoticeIList;
        this.open = true;
        this.title = "修改预约通知抬头";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.wmImNoticeIList = this.wmImNoticeIList;
          if (this.form.id != null) {
            updateImNoticeH(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addImNoticeH(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除预约通知抬头编号为"' + ids + '"的数据项？').then(function() {
        return delImNoticeH(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 预约进货行项目序号 */
    rowWmImNoticeIIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 预约进货行项目添加按钮操作 */
    handleAddWmImNoticeI() {
      let obj = {};
      obj.createName = "";
      obj.createDate = "";
      obj.updateName = "";
      obj.updateDate = "";
      obj.sysOrgCode = "";
      obj.sysCompanyCode = "";
      obj.imNoticeId = "";
      obj.imNoticeItem = "";
      obj.goodsCode = "";
      obj.goodsCount = "";
      obj.goodsPrdData = "";
      obj.goodsBatch = "";
      obj.binPre = "";
      obj.goodsFvol = "";
      obj.goodsWeight = "";
      obj.binPlan = "";
      obj.goodsUnit = "";
      obj.goodsWqmCount = "";
      obj.goodsQmCount = "";
      obj.noticeiSta = "";
      obj.baseUnit = "";
      obj.baseGoodscount = "";
      obj.baseQmcount = "";
      obj.goodsName = "";
      obj.otherId = "";
      this.wmImNoticeIList.push(obj);
    },
    /** 预约进货行项目删除按钮操作 */
    handleDeleteWmImNoticeI() {
      if (this.checkedWmImNoticeI.length == 0) {
        this.$modal.msgError("请先选择要删除的预约进货行项目数据");
      } else {
        const wmImNoticeIList = this.wmImNoticeIList;
        const checkedWmImNoticeI = this.checkedWmImNoticeI;
        this.wmImNoticeIList = wmImNoticeIList.filter(function(item) {
          return checkedWmImNoticeI.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleWmImNoticeISelectionChange(selection) {
      this.checkedWmImNoticeI = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('entry/imNoticeH/export', {
        ...this.queryParams
      }, `imNoticeH_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
