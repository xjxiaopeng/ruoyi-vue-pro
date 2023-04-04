<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!--      <el-form-item label="用户ID" prop="userId">-->
      <!--        <el-input v-model="queryParams.userId" placeholder="请输入用户ID" clearable @keyup.enter.native="handleQuery"/>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="部门" prop="deptId">-->
      <!--        <el-input v-model="queryParams.deptId" placeholder="请选择部门" clearable @keyup.enter.native="handleQuery"/>-->
      <!--      </el-form-item>-->

      <el-form-item label="部门" prop="deptId">
        <el-select v-model="queryParams.deptId" clearable @change="selectDeptChang()" placeholder="请选择">
          <el-option
            v-for="item in deptOptions"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

<!--      <el-form-item label="姓名" prop="nickname">-->
<!--        <el-input v-model="queryParams.nickname" placeholder="请输入姓名" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>-->
<!--        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>-->
<!--      </el-form-item>-->
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">

      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['hr:pay-sheet-base:create']">新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAddAll"
                   v-hasPermi="['hr:pay-sheet-base:create']">批量生成新的基础工资表
        </el-button>
      </el-col>

      <!--      <el-col :span="1.5">-->
      <!--        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"-->
      <!--                   v-hasPermi="['hr:pay-sheet-base:export']">导出</el-button>-->
      <!--      </el-col>-->
      <!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list" :max-height="tableHeight" :summary-method="getSummaries" style="width: 100%">
      <el-table-column label="序号" type="index" align="center" fixed prop="id"/>
      <el-table-column label="姓名"  fixed align="center">
        <template v-slot="scope">
          <span>
            {{ scope.row.userId === 0 ? '' : getUsername(scope.row.userId) }}
          </span>
        </template>
      </el-table-column>
      <el-table-column label="部门" align="center" prop="deptId">
        <template v-slot="scope">
          {{ scope.row.deptId === 0 ? '' : getDeptName(scope.row.deptId) }}
        </template>
      </el-table-column>

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

      <el-table-column label="操作" align="center" fixed="right" width="180" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['hr:pay-sheet-base:update']">修改
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['hr:pay-sheet-base:delete']">删除
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
        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名" prop="userId">
              <el-select v-model="form.userId" placeholder="请选择姓名" style="width:100%">
                <el-option
                  v-for="item in users"
                  :key="item.id"
                  :label="item.nickname"
                  :value="item.id"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="部门" prop="deptId">
              <el-select v-model="form.deptId" placeholder="请选择要考核的岗位" style="width:100%">
                <el-option
                  v-for="item in deptOptions"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
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
  createPaySheetBase,
  deletePaySheetBase,
  exportPaySheetBaseExcel, generateSheetBase,
  getPaySheetBase,
  getPaySheetBasePage,
  updatePaySheetBase
} from "@/api/hr/paySheetBase";
import {listSimpleDepts} from '@/api/system/dept'
import {listSimpleUsers} from "@/api/system/user";
import {createPaySheetMonth} from "@/api/hr/paySheetMonth";

export default {
  name: "PaySheetBase",
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
      // 工资基础列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      //部门列表
      deptOptions: [],
      // 用户下拉列表
      users: [],
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        userId: null,
        deptId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [{required: true, message: "用户ID不能为空", trigger: "blur"}],
        deptId: [{required: true, message: "部门ID不能为空", trigger: "blur"}],
      }
    };
  },
  created() {
    // 获得用户列表
    listSimpleUsers().then(response => {
      this.users = response.data.filter(item => item.nickname !== 'admin');
    });
    this.getTreeselect()
    this.getList();
  },
  methods: {
    selectDeptChang() {
      this.getList()
    },
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getPaySheetBasePage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 查询部门下拉树结构 + 岗位下拉 */
    getTreeselect() {
      listSimpleDepts().then(response => {
        // 处理 deptOptions 参数
        this.deptOptions = [];
        this.deptOptions.push(...response.data);
        // console.log(this.deptOptions)
      });
      // listSimplePosts().then(response => {
      //   // 处理 postOptions 参数
      //   this.postOptions = []
      //   this.postOptions.push({id: 0, name: '所有岗位'})
      //   this.postOptions.push(...response.data)
      //   for (const post of this.postOptions) {
      //     if (post.name === '会计') {
      //       this.queryParams.postId=post.id
      //     }
      //   }
      //   this.getList()
      // })
    },
    /** 根据用户id获取用户名称*/
    getUsername(userId) {
      for (const user of this.users) {
        if (user.id === userId) {
          return user.nickname
          // console.log(user.nickname)
        }
      }
      return '未知(' + userId + ')'
    },
    /** 根据部门id获取部门名称*/
    getDeptName(deptId) {
      // console.log(this.deptOptions)
      for (const dept of this.deptOptions) {
        if (dept.id === deptId) {
          return dept.name
        }
      }
      return '未知(' + deptId + ')'

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
        userId: undefined,
        deptId: undefined,
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
      this.title = "添加";
    },

    /** 生成基础工资表按钮操作 */
    handleAddAll() {
      generateSheetBase().then(response => {
        this.$modal.msgSuccess("生成基础工资表成功");
        this.getList();
      });
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPaySheetBase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工资基础";
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
          updatePaySheetBase(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPaySheetBase(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除工资基础编号为"' + id + '"的数据项?').then(function () {
        return deletePaySheetBase(id);
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
      this.$modal.confirm('是否确认导出所有工资基础数据项?').then(() => {
        this.exportLoading = true;
        return exportPaySheetBaseExcel(params);
      }).then(response => {
        this.$download.excel(response, '工资基础.xls');
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>

<style>
.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  /*color: #99a9bf;*/
}

.demo-table-expand .el-form-item {
  margin-left: 38vh;
  margin-right: 0;
  margin-bottom: 0;
  width: 20%;
}
</style>
