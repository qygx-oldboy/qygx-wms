<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="中文全称" prop="zhongWenQch">
        <el-input
          v-model="queryParams.zhongWenQch"
          placeholder="请输入中文全称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编码" prop="gysBianMa">
        <el-input
          v-model="queryParams.gysBianMa"
          placeholder="请输入供应商编码"
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
          v-hasPermi="['basicData:sup:add']"
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
          v-hasPermi="['basicData:sup:edit']"
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
          v-hasPermi="['basicData:sup:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['basicData:sup:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="supList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="中文全称" align="center" prop="zhongWenQch" />
      <el-table-column label="供应商编码" align="center" prop="gysBianMa" />
      <el-table-column label="地址" align="center" prop="diZhi" />
      <el-table-column label="主联系人" align="center" prop="zhuLianXiRen" />
      <el-table-column label="电话" align="center" prop="dianHua" />
      <el-table-column label="手机" align="center" prop="shouJi" />
      <el-table-column label="Email地址" align="center" prop="emaildiZhi" />
      <el-table-column label="备注" align="center" prop="beiZhu" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['basicData:sup:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['basicData:sup:remove']"
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

    <!-- 添加或修改供应商对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
         <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="中文全称" prop="zhongWenQch">
              <el-input
                v-model="form.zhongWenQch"
                placeholder="请输入中文全称"
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="编码" prop="gysBianMa">
              <el-input
                v-model="form.gysBianMa"
                placeholder="请输入供应商编码"
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="地址" prop="diZhi">
              <el-input
                v-model="form.diZhi"
                placeholder="请输入地址"
                maxlength="30"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="主联系人" prop="zhuLianXiRen">
              <el-input
                v-model="form.zhuLianXiRen"
                placeholder="请输入主联系人"
                maxlength="30"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电话" prop="dianHua">
              <el-input
                v-model="form.dianHua"
                placeholder="请输入电话"
                maxlength="11"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="手机" prop="shouJi">
              <el-input
                v-model="form.shouJi"
                placeholder="请输入手机"
                maxlength="11"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="email地址" prop="emaildiZhi">
              <el-input
                v-model="form.emaildiZhi"
                placeholder="请输入email地址"
                maxlength="30"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="备注" prop="beiZhu">
              <el-input
                v-model="form.beiZhu"
                type="textarea"
                placeholder="请输入备注"
              ></el-input>
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
import { listSup, getSup, delSup, addSup, updateSup } from "@/api/basicData/sup";

export default {
  name: "Sup",
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
      // 供应商表格数据
      supList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        zhongWenQch: null,
        gysBianMa: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
         zhongWenQch: [
          {
            required: true,
            message: "请输入中文全称",
            trigger: "blur",
          }
        ],
        gysBianMa: [
          {
            required: true,
            message: "请输入供应商编码",
            trigger: "blur",
          },
        ],
        diZhi: [
          {
            required: true,
            message: "请输入地址",
            trigger: "blur",
          },
        ],
        zhuLianXiRen: [
          {
            required: true,
            message: "请输入负责人",
            trigger: "blur",
          },
        ],
        dianHua: [],
        shouJi: [
          {
            required: true,
            message: "请输入手机",
            trigger: "blur",
          },
        ],
        emaildiZhi: [],
        beiZhu: []
      
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供应商列表 */
    getList() {
      this.loading = true;
      listSup(this.queryParams).then(response => {
        this.supList = response.rows;
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
        gysJianCheng: null,
        gysBianMa: null,
        gysYingWen: null,
        zengYongQi: null,
        zengYongQiYe: null,
        gysZhuangTai: null,
        xingYeFenLei: null,
        gysDengJi: null,
        suoShuXingYe: null,
        shouQianRiQi: null,
        zhongZhiHeShiJian: null,
        shenQingShiJian: null,
        gysShuXing: null,
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
        beiZhu: null
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
      this.title = "添加供应商";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSup(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改供应商";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSup(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSup(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除供应商编号为"' + ids + '"的数据项？').then(function() {
        return delSup(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('basicData/sup/export', {
        ...this.queryParams
      }, `sup_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
