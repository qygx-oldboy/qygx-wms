<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryGoodForm"
      size="mini"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="商品名称" prop="shpMingCheng">
        <el-input
          v-model="queryParams.shpMingCheng"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleGoodQuery"
        />
      </el-form-item>
      <el-form-item label="商品条码" prop="shpTiaoMa">
        <el-input
          v-model="queryParams.shpTiaoMa"
          placeholder="请输入商品条码"
          clearable
          @keyup.enter.native="handleGoodQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleGoodQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetGoodQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>


    
    <el-table
      v-loading="loading"
      :data="goodsList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="货主" align="center" prop="suoShuKeHu" />
       <el-table-column label="商品编码" align="center" prop="shpBianMa" />
      <el-table-column label="商品名" align="center" prop="shpMingCheng" />
       <el-table-column label="单位" align="center" prop="shlDanWei">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_meterage_unit"
            :value="scope.row.shlDanWei"
          />
        </template>
      </el-table-column>
    
      <!-- <el-table-column label="商品型号" align="center" prop="shpXingHao" /> -->
      <el-table-column label="商品规格" align="center" prop="shpGuiGe" />
      <!-- <el-table-column label="商品颜色" align="center" prop="shpYanSe" /> -->
      <!-- <el-table-column label="产品属性" align="center" prop="chpShuXing">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_product_attribute"
            :value="scope.row.chpShuXing"
          />
        </template>
      </el-table-column> -->
       <el-table-column label="商品条码" align="center" prop="shpTiaoMa" />
      <el-table-column label="商品品牌" align="center" prop="shpPinPai" />
     
      <!-- <el-table-column label="产品大类" align="center" prop="chpDaLei">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.model_product_categories"
            :value="scope.row.chpDaLei"
          />
        </template>
      </el-table-column>
      <el-table-column label="保质期" align="center" prop="bzhiQi" />

    

      <el-table-column label="特征" align="center">
        <el-table-column label="体积" align="center" prop="tiJiCm" />
        <el-table-column label="净重" align="center" prop="zhlKg" />
        <el-table-column label="长整箱" align="center" prop="chZhXiang" />
        <el-table-column label="宽整箱" align="center" prop="kuZhXiang" />
        <el-table-column label="高整箱" align="center" prop="gaoZhXiang" />
        <el-table-column label="毛重" align="center" prop="zhlKgm" />
      </el-table-column> -->
    </el-table>
    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    
     <div slot="footer" class="dialog-footer">
      
        <el-button type="primary" @click="submit" text-align:center>添 加</el-button>
        <!-- <el-button @click="cancel">取 消</el-button> -->
      </div>
  </div>

</template>


<script>

import {
  listGoods
} from "@/api/basicData/goods";
import { listCus } from "@/api/basicData/cus";
export default {
  name: "selectGoods",
   dicts: [
    "model_meterage_unit"
  ],
  data() {
    return {
       // 遮罩层
      loading: false,
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
      // 查询参数
       queryParams: {
        pageNum: 1,
        pageSize: 10,
        shpMingCheng: null,
        shpTiaoMa: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
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
        this.goodsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
  
 // 多选框选中数据
    handleSelectionChange(selection) {
      //在这个地方处理
      console.info(selection);
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    
    /** 搜索按钮操作 */
    handleGoodQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetGoodQuery() {
      this.resetForm("queryGoodForm");
      this.handleGoodQuery();
    },
    //添加按钮
    submit(){
      //把当前对话框关掉

      //把商品编码穿到父页面，并在输入框内格式化显示
      //const _selectData = this.$refs.handleSelectionChange.selection;
      console.info(this.ids);
    },
      // 取消按钮
    cancel() {
      //this.open = false;
      //this.reset();
    }

  },
  
};
</script>