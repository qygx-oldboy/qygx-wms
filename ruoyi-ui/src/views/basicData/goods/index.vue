<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="商品名称" prop="shpMingCheng">
        <el-input
          v-model="queryParams.shpMingCheng"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品编码" prop="shpBianMa">
        <el-input
          v-model="queryParams.shpBianMa"
          placeholder="请输入商品编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品属性" prop="chpShuXing">
        <el-select
          v-model="queryParams.chpShuXing"
          placeholder="请选择产品属性"
          clearable
        >
          <el-option
            v-for="dict in dict.type.model_product_attribute"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="商品条码" prop="shpTiaoMa">
        <el-input
          v-model="queryParams.shpTiaoMa"
          placeholder="请输入商品条码"
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
          v-hasPermi="['basicData:goods:add']"
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
          v-hasPermi="['basicData:goods:edit']"
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
          v-hasPermi="['basicData:goods:remove']"
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
          v-hasPermi="['basicData:goods:export']"
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
      :data="goodsList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
        width="200"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['basicData:goods:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['basicData:goods:remove']"
            >删除</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handlePrintOne(scope.row)"
            v-hasPermi="['basicData:goods:query']"
            >打印</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="所属客户" align="center" prop="suoShuKeHu" />
      <el-table-column label="商品名称" align="center" prop="shpMingCheng" />
      <el-table-column label="商品编码" align="center" prop="shpBianMa" />
      <el-table-column label="商品客户编码" align="center" prop="shpBianMakh" />
      <!-- <el-table-column label="商品型号" align="center" prop="shpXingHao" /> -->
      <el-table-column label="商品规格" align="center" prop="shpGuiGe" />
      <!-- <el-table-column label="商品颜色" align="center" prop="shpYanSe" /> -->
      <el-table-column label="产品属性" align="center" prop="chpShuXing">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_product_attribute"
            :value="scope.row.chpShuXing"
          />
        </template>
      </el-table-column>
      <el-table-column label="商品品牌" align="center" prop="shpPinPai" />
      <el-table-column label="商品条码" align="center" prop="shpTiaoMa" />
      <el-table-column label="产品大类" align="center" prop="chpDaLei">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_product_categories"
            :value="scope.row.chpDaLei"
          />
        </template>
      </el-table-column>
      <el-table-column label="保质期" align="center" prop="bzhiQi" />

      <el-table-column label="单位" align="center" prop="shlDanWei">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_meterage_unit"
            :value="scope.row.shlDanWei"
          />
        </template>
      </el-table-column>

      <el-table-column label="特征" align="center">
        <el-table-column label="体积" align="center" prop="tiJiCm" />
        <el-table-column label="净重" align="center" prop="zhlKg" />
        <el-table-column label="长整箱" align="center" prop="chZhXiang" />
        <el-table-column label="宽整箱" align="center" prop="kuZhXiang" />
        <el-table-column label="高整箱" align="center" prop="gaoZhXiang" />
        <el-table-column label="毛重" align="center" prop="zhlKgm" />
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商品信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-form-item label="所属货主" prop="supId">
            <el-select
              v-model="form.supId"
              placeholder="请选择所属货主"
              :style="{ width: '100%' }"
            >
              <el-option
                v-for="item in supOptions"
                :key="item.id"
                :label="item.zhongWenQch"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="产品大类" prop="chpDaLei">
              <el-select
                v-model="form.chpDaLei"
                placeholder="请选择产品大类"
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="dict in dict.type.model_product_categories"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="产品属性" prop="chpShuXing">
              <el-select
                v-model="form.chpShuXing"
                placeholder="请选择产品属性"
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="dict in dict.type.model_product_attribute"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="商品编码" prop="shpBianMa">
              <el-input
                v-model="form.shpBianMa"
                placeholder="请输入商品编码"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item
              label-width="107px"
              label="客户商品编码"
              prop="shpBianMakh"
            >
              <el-input
                v-model="form.shpBianMakh"
                placeholder="请输入客户商品编码"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="商品条码" prop="shpTiaoMa">
              <el-input
                v-model="form.shpTiaoMa"
                placeholder="请输入商品条码"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="商品品牌" prop="shpPinPai">
              <el-input
                v-model="form.shpPinPai"
                placeholder="请输入商品品牌"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="商品规格" prop="shpGuiGe">
              <el-input
                v-model="form.shpGuiGe"
                placeholder="请输入商品规格"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-form-item label="商品名称" prop="shpMingCheng">
            <el-input
              v-model="form.shpMingCheng"
              placeholder="请输入商品名称"
              clearable
              :style="{ width: '100%' }"
            >
            </el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="单位" prop="shlDanWei">
              <el-select v-model="form.shlDanWei" placeholder="请选择单位">
                <el-option
                  v-for="dict in dict.type.model_meterage_unit"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="重量" prop="zhlKgm">
              <el-input
                v-model="form.zhlKgm"
                placeholder="请输入重量"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="长" prop="chZhXiang">
              <el-input
                v-model="form.chZhXiang"
                placeholder="请输入长"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="宽" prop="kuZhXiang">
              <el-input
                v-model="form.kuZhXiang"
                placeholder="请输入宽"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="高" prop="gaoZhXiang">
              <el-input
                v-model="form.gaoZhXiang"
                placeholder="请输入高"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="保质期" prop="bzhiQi">
              <el-input
                v-model="form.bzhiQi"
                placeholder="请输入保质期"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    
    <el-dialog
      :title="dialogImgTitle"
      :visible.sync="dialogImgVisible"
      width="800px"
      append-to-body
    >
    <el-image  style='height: 480px;width:480px' :src="imgsrc"></el-image>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="confirmPrint">打印</el-button>
        <el-button @click="printCancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listGoods,
  getGoods,
  delGoods,
  addGoods,
  updateGoods,
  getBarCode
} from "@/api/basicData/goods";
import { listCus } from "@/api/basicData/cus";
export default {
  name: "Goods",
  dicts: [
    "model_product_categories",
    "model_product_attribute",
    "sys_yes_no",
    "model_meterage_unit",
  ],
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
      // 货主树选项
      supOptions: [],
      // 总条数
      total: 0,
      // 商品信息表格数据
      goodsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 条形码标题
      dialogImgTitle: "",
      // 是否显示条形码弹出层
      dialogImgVisible: false,
      //条形码地址
      imgsrc: '',
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shpMingCheng: null,
        shpBianMa: null,
        shpGuiGe: null,
        chpShuXing: null,
        shpTiaoMa: null,
      },
      // 表单参数
      form: {
        supId: null,
        chpDaLei: undefined,
        chpShuXing: undefined,
        shpBianMa: undefined,
        shpBianMakh: undefined,
        shpTiaoMa: undefined,
        shpPinPai: undefined,
        shpGuiGe: undefined,
        shpMingCheng: undefined,
        shlDanWei: undefined,
        zhlKgm: undefined,
        chZhXiang: undefined,
        kuZhXiang: undefined,
        gaoZhXiang: undefined,
        bzhiQi: undefined,
      },
      // 表单校验
      rules: {
        chpDaLei: [
          {
            required: true,
            message: "请输入产品大类",
            trigger: "blur",
          },
        ],
        chpShuXing: [
          {
            required: true,
            message: "请输入产品属性",
            trigger: "blur",
          },
        ],
        shpBianMa: [
          {
            required: true,
            message: "请输入商品编码",
            trigger: "blur",
          },
        ],
        shpBianMakh: [],
        shpTiaoMa: [],
        shpPinPai: [],
        shpGuiGe: [],
        shpMingCheng: [
          {
            required: true,
            message: "请输入商品名称",
            trigger: "blur",
          },
        ],
        shlDanWei: [
          {
            required: true,
            message: "请选择单位",
            trigger: "change",
          },
        ],
        zhlKgm: [],
        chZhXiang: [],
        kuZhXiang: [],
        gaoZhXiang: [],
        bzhiQi: [],
        supId: [
          { required: true, message: "货主ID不能为空", trigger: "change" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品信息列表 */
    getList() {
      this.loading = true;
      listGoods(this.queryParams).then((response) => {
        console.info(response);
        this.goodsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
      // 打印取消按钮
    printCancel() {
      this.dialogImgVisible = false;
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
        suoShuKeHu: null,
        shpMingCheng: null,
        shpJianCheng: null,
        shpBianMa: null,
        shpXingHao: null,
        shpGuiGe: null,
        shpYanSe: null,
        chpShuXing: null,
        cfWenCeng: null,
        chlKongZhi: "0",
        mpDanCeng: null,
        mpCengGao: null,
        jfShpLei: null,
        shpPinPai: null,
        shpTiaoMa: null,
        ppTuPian: null,
        bzhiQi: null,
        shlDanWei: null,
        jshDanWei: null,
        tiJiCm: null,
        zhlKg: null,
        chlShl: null,
        jtiJiBi: null,
        jmZhongBi: null,
        jjZhongBi: null,
        chcDanWei: null,
        chDanPin: null,
        kuDanPin: null,
        gaoDanPin: null,
        chZhXiang: null,
        kuZhXiang: null,
        gaoZhXiang: null,
        shpMiaoShu: null,
        zhuangTai: "0",
        zhlKgm: null,
        shpBianMakh: null,
        jizhunWendu: null,
        chpDaLei: null,
        supId: null,
      };
      this.resetForm("form");
    },
    /** 查询所属货主下拉树结构 */
    getTreeselect() {
      listCus().then((response) => {
        this.supOptions = response.rows;
      });
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
      this.getTreeselect();
      this.open = true;
      this.title = "添加商品信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getGoods(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateGoods(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGoods(this.form).then((response) => {
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
        .confirm('是否确认删除商品信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delGoods(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "basicData/goods/export",
        {
          ...this.queryParams,
        },
        `goods_${new Date().getTime()}.xlsx`
      );
    },

    arrayBufferToBase64 (buffer) {
      var binary = ''
      var bytes = new Uint8Array(buffer)
      var len = bytes.byteLength
      for (var i = 0; i < len; i++) {
        binary += String.fromCharCode(bytes[i])
      }
      return window.btoa(binary)
    },

    /** 打印按钮操作 */
    handlePrintOne(row) {
      this.reset();
      const shpBianMa = row.shpBianMa;
      getBarCode(shpBianMa).then((response) => {
        //注意看一下response返回的数据格式
        let url = window.URL.createObjectURL(response);
        this.imgsrc=url;
        this.dialogImgVisible = true;
        this.dialogImgTitle = "商品标签";
      });
    },

    /**确认打印 */
    confirmPrint(){

    }



  },
};
</script>

