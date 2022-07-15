<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="100px"
    >
      <el-form-item label="进货通知单号" prop="noticeId">
        <el-input
          v-model="queryParams.noticeId"
          placeholder="请输入进货通知单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="预计到货时间" prop="imData">
        <el-date-picker
          clearable
          v-model="queryParams.imData"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预计到货时间"
        >
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
      <el-form-item label="订单类型" prop="orderTypeCode">
        <el-input
          v-model="queryParams.orderTypeCode"
          placeholder="请输入订单类型"
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
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
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
          >新增</el-button
        >
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
          >修改</el-button
        >
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
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['entry:imNoticeH:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="imNoticeHList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="所属部门" align="center" prop="sysOrgCode" />
      <el-table-column label="所属公司" align="center" prop="sysCompanyCode" />
      <el-table-column label="客户编码" align="center" prop="cusCode" />
      <el-table-column
        label="预计到货时间"
        align="center"
        prop="imData"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.imData, "{y}-{m}-{d}") }}</span>
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
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['entry:imNoticeH:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['entry:imNoticeH:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改预约通知抬头对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      :fullscreen="true"
      width="800px"
      append-to-body
    >
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="货主" prop="field101">
              <el-select
                v-model="form.field101"
                placeholder="请选择货主"
                clearable
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="(item, index) in field101Options"
                  :key="index"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="日期选择" prop="field111">
              <el-date-picker
                v-model="form.field111"
                format="yyyy-MM-dd"
                value-format="yyyy-MM-dd"
                :style="{ width: '100%' }"
                placeholder="请选择日期选择"
                clearable
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="供应商" prop="field112">
              <el-input
                v-model="form.field112"
                placeholder="请输入供应商"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="仓库" prop="field116">
              <el-select
                v-model="form.field116"
                placeholder="请选择仓库"
                clearable
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="(item, index) in field116Options"
                  :key="index"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="订单类型" prop="field115">
              <el-select
                v-model="form.field115"
                placeholder="请选择订单类型"
                clearable
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="(item, index) in field115Options"
                  :key="index"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-divider content-position="center">预约进货行项目信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="mini"
              @click="handleAddWmImNoticeI"
              >添加</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              @click="handleDeleteWmImNoticeI"
              >删除</el-button
            >
          </el-col>
        </el-row>
        <el-table
          :data="wmImNoticeIList"
          :row-class-name="rowWmImNoticeIIndex"
          @selection-change="handleWmImNoticeISelectionChange"
          ref="wmImNoticeI"
        >
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column
            label="序号"
            align="center"
            prop="index"
            width="50"
          />

          <el-table-column label="商品编码" prop="goodsCode">
            <template slot-scope="scope">
              <el-input
                v-model="scope.row.goodsCode"
                placeholder="请输入商品编码"
                style="width: 640px"
                @focus="handleAddGoods"
              />
            </template>
          </el-table-column>
          <el-table-column label="数量" prop="goodsCount" width="240">
            <template slot-scope="scope">
              <el-input
                v-model="scope.row.goodsCount"
                placeholder="请输入数量"
              />
            </template>
          </el-table-column>

          <el-table-column label="计划占用库位数" prop="binPlan" width="240">
            <template slot-scope="scope">
              <el-input
                v-model="scope.row.binPlan"
                placeholder="请输入计划库位"
              />
            </template>
          </el-table-column>

          <el-table-column label="行项目状态" prop="noticeiSta" width="240">
            <template slot-scope="scope">
              <el-input
                v-model="scope.row.noticeiSta"
                placeholder="请输入行项目状态"
              />
            </template>
          </el-table-column>
          <!--           
          <el-table-column label="商品名称" prop="goodsName" width="150">
            <template slot-scope="scope">
              <el-input
                v-model="scope.row.goodsName"
                placeholder="请输入商品名称"
              />
            </template>
          </el-table-column> -->
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!--添加商品弹出框 -->
    <el-dialog
      :title="dialogGoodTitle"
      :visible.sync="dialogGoodVisible"
      width="800px"
      append-to-body
    >
    <selectGoods></selectGoods>
      
    </el-dialog>
  </div>
</template>

<script>
import {
  listImNoticeH,
  getImNoticeH,
  delImNoticeH,
  addImNoticeH,
  updateImNoticeH,
} from "@/api/entry/imNoticeH";
import selectGoods from "./selectGoods.vue";

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
            // 商品弹出层标题
            dialogGoodTitle: "",
            // 是否显示添加商品弹出层
            dialogGoodVisible: false,
            // 查询参数
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                imData: null,
                imCusCode: null,
                orderTypeCode: null,
                imSta: null,
                noticeId: null,
                supCode: null,
                supName: null,
            },
            // 表单参数
            form: {
                field101: undefined,
                field111: null,
                field112: undefined,
                field116: undefined,
                field115: undefined,
                field120: null,
                field119: undefined,
            },
            // 表单校验
            rules: {},
            field101Options: [
                {
                    label: "选项一",
                    value: 1,
                },
                {
                    label: "选项二",
                    value: 2,
                },
            ],
            field116Options: [
                {
                    label: "选项一",
                    value: 1,
                },
                {
                    label: "选项二",
                    value: 2,
                },
            ],
            field115Options: [
                {
                    label: "选项一",
                    value: 1,
                },
                {
                    label: "选项二",
                    value: 2,
                },
            ],
        };
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询预约通知抬头列表 */
        getList() {
            this.loading = true;
            listImNoticeH(this.queryParams).then((response) => {
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
                supName: null,
            };
            this.wmImNoticeIList = [
                { goodsCode: "", goodsCount: "", binPlan: "", noticeiSta: "" },
            ];
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
            this.ids = selection.map((item) => item.id);
            this.single = selection.length !== 1;
            this.multiple = !selection.length;
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
            const id = row.id || this.ids;
            getImNoticeH(id).then((response) => {
                this.form = response.data;
                this.wmImNoticeIList = response.data.wmImNoticeIList;
                this.open = true;
                this.title = "修改预约通知抬头";
            });
        },
        /** 提交按钮 */
        submitForm() {
            this.$refs["form"].validate((valid) => {
                if (valid) {
                    this.form.wmImNoticeIList = this.wmImNoticeIList;
                    if (this.form.id != null) {
                        updateImNoticeH(this.form).then((response) => {
                            this.$modal.msgSuccess("修改成功");
                            this.open = false;
                            this.getList();
                        });
                    }
                    else {
                        addImNoticeH(this.form).then((response) => {
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
            this.$modal
                .confirm("是否确认删除预约通知抬头编号为\"" + ids + "\"的数据项？")
                .then(function () {
                return delImNoticeH(ids);
            })
                .then(() => {
                this.getList();
                this.$modal.msgSuccess("删除成功");
            })
                .catch(() => { });
        },
        /** 预约进货行项目序号 */
        rowWmImNoticeIIndex({ row, rowIndex }) {
            row.index = rowIndex + 1;
        },
        /** 预约进货行项目添加按钮操作 */
        handleAddWmImNoticeI() {
            let obj = {};
            obj.goodsCode = "";
            obj.goodsCount = "";
            obj.binPlan = "";
            obj.noticeiSta = "";
            //obj.goodsName = "";
            this.wmImNoticeIList.push(obj);
        },
        /** 预约进货行项目删除按钮操作 */
        handleDeleteWmImNoticeI() {
            if (this.checkedWmImNoticeI.length == 0) {
                this.$modal.msgError("请先选择要删除的预约进货行项目数据");
            }
            else {
                const wmImNoticeIList = this.wmImNoticeIList;
                const checkedWmImNoticeI = this.checkedWmImNoticeI;
                this.wmImNoticeIList = wmImNoticeIList.filter(function (item) {
                    return checkedWmImNoticeI.indexOf(item.index) == -1;
                });
            }
        },
        /** 复选框选中数据 */
        handleWmImNoticeISelectionChange(selection) {
            this.checkedWmImNoticeI = selection.map((item) => item.index);
        },
        /** 导出按钮操作 */
        handleExport() {
            this.download("entry/imNoticeH/export", {
                ...this.queryParams,
            }, `imNoticeH_${new Date().getTime()}.xlsx`);
        },
        /** 新增按钮操作 */
        handleAddGoods() {
            this.dialogGoodVisible = true;
            this.dialogGoodTitle = "商品视图";
        }
    },
    components: { selectGoods}
};
</script>
