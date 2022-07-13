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
      <!-- <el-form-item label="库位名称" prop="kuWeiMingCheng">
        <el-input
          v-model="queryParams.kuWeiMingCheng"
          placeholder="请输入库位名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->

      <el-form-item label="仓库" prop="storeId">
        <el-select
          v-model="queryParams.binStore"
          placeholder="请选择仓库"
          clearable
         @keyup.enter.native="handleQuery"
        >
          <el-option
            v-for="(item, index) in binStoreOptions"
            :key="index"
            :label="item.storeName"
            :value="item.storeName"
            :disabled="item.disabled"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="库位编码" prop="kuWeiBianMa">
        <el-input
          v-model="queryParams.kuWeiBianMa"
          placeholder="请输入库位编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库位类型" prop="kuWeiLeiXing">
        <el-select
          v-model="queryParams.kuWeiLeiXing"
          placeholder="请选择库位类型"
          clearable
        >
          <el-option
            v-for="dict in dict.type.model_location_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="停用" prop="tingYong">
        <el-select
          v-model="queryParams.tingYong"
          placeholder="请选择停用"
          clearable
        >
          <el-option
            v-for="dict in dict.type.sys_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['warehouse:bin:add']"
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
          v-hasPermi="['warehouse:bin:edit']"
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
          v-hasPermi="['warehouse:bin:remove']"
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
          v-hasPermi="['warehouse:bin:export']"
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
      :data="binList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="仓库" align="center" prop="binStore" />
      <el-table-column label="库位编码" align="center" prop="kuWeiBianMa" />
      <el-table-column label="库位条码" align="center" prop="kuWeiTiaoMa" />
      <el-table-column label="库位类型" align="center" prop="kuWeiLeiXing">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_location_type"
            :value="scope.row.kuWeiLeiXing"
          />
        </template>
      </el-table-column>
      <el-table-column label="库位属性" align="center" prop="kuWeiShuXing">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_location_attribute"
            :value="scope.row.kuWeiShuXing"
          />
        </template>
      </el-table-column>
      <el-table-column label="上架次序" align="center" prop="shangJiaCiXu" />
      <el-table-column label="取货次序" align="center" prop="quHuoCiXu" />
      <el-table-column label="所属客户" align="center" prop="suoShuKeHu" />
      <!-- <el-table-column label="体积单位" align="center" prop="tiJiDanWei" /> -->
      <!-- <el-table-column
        label="重量单位"
        align="center"
        prop="zhongLiangDanWei"
      /> -->
      <!-- <el-table-column label="面积单位" align="center" prop="mianJiDanWei" /> -->

      <el-table-column label="最大重量" align="center" prop="zuiDaZhongLiang" />
      <!-- <el-table-column label="最大面积" align="center" prop="zuiDaMianJi" /> -->
      <el-table-column label="最大托盘" align="center" prop="zuiDaTuoPan" />

      <el-table-column label="特征" align="center">
        <el-table-column label="最大体积" align="center" prop="zuiDaTiJi" />
        <el-table-column label="长度" align="center" prop="chang" />
        <el-table-column label="宽度" align="center" prop="kuan" />
        <el-table-column label="高度" align="center" prop="gao" />
      </el-table-column>
      <el-table-column label="停用" align="center" prop="tingYong">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.sys_yes_no"
            :value="scope.row.tingYong"
          />
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="mingXi" />
      <el-table-column label="备注1" align="center" prop="mingXi1" />
      <el-table-column label="备注2" align="center" prop="mingXi2" />
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
            v-hasPermi="['warehouse:bin:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['warehouse:bin:remove']"
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

    <!-- 添加或修改储位定义对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        size="medium"
        label-width="100px"
      >
        <el-row>
          <el-col :span="12">
            <el-form-item label="仓库" prop="storeId">
              <el-select
                v-model="form.storeId"
                placeholder="请选择仓库"
                clearable
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="(item, index) in binStoreOptions"
                  :key="index"
                  :label="item.storeName"
                  :value="item.id"
                  :disabled="item.disabled"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="所属客户" prop="suoShuKeHu">
              <el-select
                v-model="form.suoShuKeHu"
                placeholder="请选择所属客户"
                clearable
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="item in suoShuKeHuOptions"
                  :key="item.id"
                  :label="item.zhongWenQch"
                  :value="item.zhongWenQch"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="库位编码" prop="kuWeiBianMa">
              <el-input
                v-model="form.kuWeiBianMa"
                placeholder="请输入库位编码"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库位条码" prop="kuWeiTiaoMa">
              <el-input
                v-model="form.kuWeiTiaoMa"
                placeholder="请输入库位条码"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="库位类型" prop="kuWeiLeiXing">
              <el-select
                v-model="form.kuWeiLeiXing"
                placeholder="请选择库位类型"
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="dict in dict.type.model_location_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库位属性" prop="kuWeiShuXing">
              <el-select
                v-model="form.kuWeiShuXing"
                placeholder="请选择库位属性"
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="dict in dict.type.model_location_attribute"
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
            <el-form-item label="上架次序" prop="shangJiaCiXu">
              <el-input
                v-model="form.shangJiaCiXu"
                placeholder="请输入上架次序"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="取货次序" prop="quHuoCiXu">
              <el-input
                v-model="form.quHuoCiXu"
                placeholder="请输入取货次序"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="最大重量" prop="zuiDaZhongLiang">
              <el-input
                v-model="form.zuiDaZhongLiang"
                placeholder="请输入最大重量"
                clearable
                :style="{ width: '100%' }"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="最大托盘" prop="zuiDaTuoPan">
              <el-input
                v-model="form.zuiDaTuoPan"
                placeholder="请输入最大托盘"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="长" prop="chang">
              <el-input
                v-model="form.chang"
                placeholder="请输入长"
                clearable
                :style="{ width: '100%' }"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="宽" prop="kuan">
              <el-input
                v-model="form.kuan"
                placeholder="请输入宽"
                clearable
                :style="{ width: '100%' }"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="高" prop="gao">
              <el-input
                v-model="form.gao"
                placeholder="请输入高"
                clearable
                :style="{ width: '100%' }"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="最大体积" prop="zuiDaTiJi">
              <el-input
                v-model="form.zuiDaTiJi"
                placeholder="请输入最大体积"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="停用">
              <el-radio-group v-model="form.tingYong">
                <el-radio
                  v-for="dict in dict.type.sys_yes_no"
                  :key="dict.value"
                  :label="dict.value"
                  >{{ dict.label }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="mingXi">
              <el-input
                v-model="form.mingXi"
                placeholder="请输入备注"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="备注1" prop="mingXi1">
              <el-input
                v-model="form.mingXi1"
                placeholder="请输入备注1"
                clearable
                :style="{ width: '100%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注2" prop="mingXi2">
              <el-input
                v-model="form.mingXi2"
                placeholder="请输入备注2"
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
  </div>
</template>

<script>
import { listCus } from "@/api/basicData/cus";
import { listStore } from "@/api/warehouse/store";

import {
  listBin,
  getBin,
  delBin,
  addBin,
  updateBin,
} from "@/api/warehouse/bin";

export default {
  name: "Bin",
  dicts: ["model_location_attribute", "sys_yes_no", "model_location_type"],
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
      //库区选项
      binStoreOptions: [],
      // 所属客户选项
      suoShuKeHuOptions: [],
      // 总条数
      total: 0,
      // 储位定义表格数据
      binList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        binStore: null,
        kuWeiBianMa: null,
        kuWeiLeiXing: null,
        tingYong: null,
        binStore: null,
      },
      // 表单参数
      form: {
        binStore: undefined,
        suoShuKeHu: undefined,
        kuWeiBianMa: undefined,
        kuWeiTiaoMa: undefined,
        kuWeiLeiXing: undefined,
        kuWeiShuXing: undefined,
        shangJiaCiXu: undefined,
        quHuoCiXu: undefined,
        zuiDaZhongLiang: undefined,
        zuiDaTuoPan: undefined,
        chang: undefined,
        kuan: undefined,
        gao: undefined,
        zuiDaTiJi: undefined,
        tingYong: undefined,
        mingXi: undefined,
        mingXi1: undefined,
        mingXi2: undefined,
      },
      // 表单校验
      rules: {
        binStore: [
          {
            required: true,
            message: "请选择仓库",
            trigger: "change",
          },
        ],
        suoShuKeHu: [],
        kuWeiBianMa: [
          {
            required: true,
            message: "请输入库位编码",
            trigger: "blur",
          },
        ],
        kuWeiTiaoMa: [
          {
            required: true,
            message: "请输入库位条码",
            trigger: "blur",
          },
        ],
        kuWeiLeiXing: [
          {
            required: true,
            message: "请选择库位类型",
            trigger: "change",
          },
        ],
        kuWeiShuXing: [
          {
            required: true,
            message: "请选择库位属性",
            trigger: "change",
          },
        ],
        shangJiaCiXu: [
          {
            required: true,
            message: "请输入上架次序",
            trigger: "blur",
          },
        ],
        quHuoCiXu: [
          {
            required: true,
            message: "请输入取货次序",
            trigger: "blur",
          },
        ],
        zuiDaZhongLiang: [],
        zuiDaTuoPan: [],
        chang: [],
        kuan: [],
        gao: [],
        zuiDaTiJi: [],
        tingYong: [],
        mingXi: [],
        mingXi1: [],
        mingXi2: [],
      },
    };
  },
  created() {
    listStore().then((response) => {
        console.info(response);
        this.binStoreOptions = response.rows;
      });
    this.getList();
  },
  methods: {
    /** 查询储位定义列表 */
    getList() {
      this.loading = true;
      listBin(this.queryParams).then((response) => {
        this.binList = response.rows;
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
        kuWeiMingCheng: null,
        kuWeiBianMa: null,
        kuWeiTiaoMa: null,
        kuWeiLeiXing: null,
        kuWeiShuXing: null,
        shangJiaCiXu: null,
        quHuoCiXu: null,
        suoShuKeHu: null,
        tiJiDanWei: null,
        zhongLiangDanWei: null,
        mianJiDanWei: null,
        zuiDaTiJi: null,
        zuiDaZhongLiang: null,
        zuiDaMianJi: null,
        zuiDaTuoPan: null,
        chang: null,
        kuan: null,
        gao: null,
        tingYong: "0",
        mingXi: null,
        binStore: null,
        chpShuXing: null,
        mingXi1: null,
        mingXi2: null,
        mingXi3: null,
        storeId: null,
      };
      this.resetForm("form");
    },

    /** 查询所属货主下拉树结构 */
    getTreeselect() {
      listCus().then((response) => {
        console.info(response);
        this.suoShuKeHuOptions = response.rows;
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
      this.title = "添加储位定义";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getBin(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改储位定义";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateBin(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBin(this.form).then((response) => {
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
        .confirm('是否确认删除储位定义编号为"' + ids + '"的数据项？')
        .then(function () {
          return delBin(ids);
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
        "warehouse/bin/export",
        {
          ...this.queryParams,
        },
        `bin_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
