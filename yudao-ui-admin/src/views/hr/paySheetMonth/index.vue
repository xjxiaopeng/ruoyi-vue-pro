<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width=68px>
      <el-form-item label="所属日期" prop="wageName" >
        <el-date-picker
                        v-model="queryParams.wageName"
                        type="month"
                        format="yyyy年M月"
                        value-format="yyyy年M月"
                        placeholder="请选择工资所属日期"
                        @change="datePickerChange">

        </el-date-picker>
      </el-form-item>
      <el-form-item label="姓名" prop="nickname">
        <el-input v-model="queryParams.nickname"  placeholder="请输入姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="部门" prop="deptName">
        <el-select v-model="queryParams.deptName" clearable @change="deptValueChange()" placeholder="请输入部门" style="width:100%">
          <el-option
            v-for="item in deptOptions"
            :key="item.id"
            :label="item.name"
            :value="item.name"
          ></el-option>
        </el-select>
<!--        <el-input v-model="queryParams.deptName" placeholder="请输入部门" clearable @keyup.enter.native="handleQuery"/>-->
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAddMonth"
                   v-hasPermi="['hr:pay-sheet-month:create']">生成当月工资表
        </el-button>
      </el-col>
<!--      <el-col :span="1.5">-->
<!--        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"-->
<!--                   v-hasPermi="['hr:pay-sheet-month:create']">新增-->
<!--        </el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"-->
<!--                   :loading="exportLoading"-->
<!--                   v-hasPermi="['hr:pay-sheet-month:export']">导出-->
<!--        </el-button>-->
<!--      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :max-height="tableHeight"  :data="list" show-summary :summary-method="getSummaries">
      <el-table-column label="序号" type="index" fixed align="center" prop="id"/>
      <el-table-column label="所属日期" width="100" fixed align="center" prop="wageName"/>
      <el-table-column label="姓名" fixed align="center" prop="nickname"/>
      <el-table-column label="部门" align="center" prop="deptName"/>
      <el-table-column label="基本工资" align="center" prop="basePay"/>
      <el-table-column label="绩效工资" align="center" prop="meritPay"/>
      <el-table-column label="加班工资" align="center" prop="overtimePay"/>
      <el-table-column label="高温补贴" align="center" prop="hightemperatureSubsidy"/>
      <el-table-column label="补助" align="center" prop="allowance"/>
      <el-table-column label="餐补" align="center" prop="lunchSubsides"/>
      <el-table-column label="事假" align="center" prop="personalLeave"/>
      <el-table-column label="病假" align="center" prop="sickLeave"/>
      <el-table-column label="其他" align="center" prop="rests"/>
      <el-table-column label="公积金" align="center" prop="housingFund"/>
      <el-table-column label="养老保险" align="center" prop="oldageInsurance"/>
      <el-table-column label="医疗保险" align="center" prop="medicalInsurance"/>
      <el-table-column label="失业保险" align="center" prop="unemploymentInsurance"/>
      <el-table-column label="工伤保险" align="center" prop="njuryInsurance"/>
      <el-table-column label="操作" align="center" fixed="right" width="160" class-name="small-padding fixed-width">
        <template v-slot="scope" style="margin: 0;padding: 0;text-align: left">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['hr:pay-sheet-month:update']">修改
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['hr:pay-sheet-month:delete']">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="600px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item v-if="false" label="所属日期" prop="wageName">
          <el-input v-model="form.wageName" placeholder="请输入所属日期"/>
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名" prop="userId">
              <el-input v-model="form.nickname" placeholder="请输入姓名"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="部门" prop="deptId">
              <el-select v-model="form.deptName" placeholder="请选择要考核的岗位" style="width:100%">
                <el-option
                  v-for="item in deptOptions"
                  :key="item.id"
                  :label="item.name"
                  :value="item.deptName"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="基本工资" prop="basePay">
              <el-input v-model="form.basePay" placeholder="请输入基本工资"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="绩效工资" prop="meritPay">
              <el-input v-model="form.meritPay" placeholder="请输入绩效工资"/>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row>
          <el-col :span="12">
            <el-form-item label="加班工资" prop="overtimePay">
              <el-input v-model="form.overtimePay" placeholder="请输入加班工资"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="高温补贴" prop="hightemperatureSubsidy">
              <el-input v-model="form.hightemperatureSubsidy" placeholder="请输入高温补贴"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="补助" prop="allowance">
              <el-input v-model="form.allowance" placeholder="请输入补助"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="餐补" prop="lunchSubsides">
              <el-input v-model="form.lunchSubsides" placeholder="请输入餐补"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="事假" prop="personalLeave">
              <el-input v-model="form.personalLeave" placeholder="请输入事假"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="病假" prop="sickLeave">
              <el-input v-model="form.sickLeave" placeholder="请输入病假"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="其他" prop="rests">
              <el-input v-model="form.rests" placeholder="请输入其他"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="公积金" prop="housingFund">
              <el-input v-model="form.housingFund" placeholder="请输入住房公积金"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="养老保险" prop="oldageInsurance">
              <el-input v-model="form.oldageInsurance" placeholder="请输入养老保险"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="医疗保险" prop="medicalInsurance">
              <el-input v-model="form.medicalInsurance" placeholder="请输入医疗保险"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="失业保险" prop="unemploymentInsurance">
              <el-input v-model="form.unemploymentInsurance" placeholder="请输入失业保险"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工伤保险" prop="njuryInsurance">
              <el-input v-model="form.njuryInsurance" placeholder="请输入工伤保险"/>
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
import {
  createPaySheetMonth,
  deletePaySheetMonth,
  exportPaySheetMonthExcel,
  getPaySheetMonth,
  getPaySheetMonthPage,
  updatePaySheetMonth
} from "@/api/hr/paySheetMonth";
import {listSimpleDepts} from "@/api/system/dept";

export default {
  name: "PaySheetMonth",
  components: {},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 表格的高度
      tableHeight: document.documentElement.scrollHeight - 230 + 'px',
      // 总条数
      total: 0,
      // 月工资列表
      list: [],
      //部门列表
      deptOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        wageName: null,
        nickname: null,
        deptName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        wageName: [{required: true, message: "工资表名称不能为空", trigger: "blur"}],
        nickname: [{required: true, message: "姓名不能为空", trigger: "blur"}],
        deptName: [{required: true, message: "部门不能为空", trigger: "blur"}],
      }
    };
  },
  created() {
    const today = new Date()
    const year=today.getFullYear()
    const month = today.getMonth()+1
    this.queryParams.wageName=year+"年"+month+"月"
    /** 查询部门下拉树结构*/
    listSimpleDepts().then(response => {
      this.deptOptions = [];
      this.deptOptions.push(...response.data);
    });
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getPaySheetMonthPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /**搜索栏的日期变化后的事件*/
    datePickerChange() {
      this.getList();
    },
    /**搜索栏的部门变化后的事件*/
    deptValueChange(){
      // console.log(this.queryParams.deptName)
      this.getList();
      // console.log("他妈的怎么没有变化")
      // this.handleQuery()
    },
    /**底部合计*/
    getSummaries(param) {
      const {columns, data} = param
      const sums = []
      columns.forEach((column, index) => {
        if (index === 1) {
          sums[index] = '总计'
          return
        }
        if (index === 0 || index === 2 ) {
          sums[index] = ''
          return
        }

        const values = data.map(item => Number(item[column.property]))
        if (!values.every(value => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr)
            if (!isNaN(value)) {
              return prev + curr
            } else {
              return prev
            }
          }, 0)
          sums[index] += ''
        } else {
          sums[index] = ''
        }
      })
      return sums
    },

    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        wageName: undefined,
        nickname: undefined,
        deptName: undefined,
        basePay: undefined,
        meritPay: undefined,
        overtimePay: undefined,
        hightemperatureSubsidy: undefined,
        allowance: undefined,
        lunchSubsides: undefined,
        personalLeave: undefined,
        sickLeave: undefined,
        rests: undefined,
        housingFund: undefined,
        oldageInsurance: undefined,
        medicalInsurance: undefined,
        unemploymentInsurance: undefined,
        njuryInsurance: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加月工资";
    },

    /** 生成月工资表按钮操作 */
    handleAddMonth(){
      createPaySheetMonth().then(response => {
        this.$modal.msgSuccess("生成月工资表成功");
        this.getList();
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPaySheetMonth(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改月工资";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          updatePaySheetMonth(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPaySheetMonth(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除月工资编号为"' + id + '"的数据项?').then(function () {
        return deletePaySheetMonth(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有月工资数据项?').then(() => {
        this.exportLoading = true;
        return exportPaySheetMonthExcel(params);
      }).then(response => {
        this.$download.excel(response, '月工资.xls');
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>
