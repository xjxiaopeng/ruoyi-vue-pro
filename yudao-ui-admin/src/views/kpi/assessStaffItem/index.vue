<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="考核名称" prop="assessTitle">
        <el-input v-model="queryParams.assessTitle" placeholder="请输入考核名称" clearable
                  @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" type="index" align="center" prop="id"/>
      <el-table-column v-if="false" label="考核编号" align="center" prop="issueId"/>
      <el-table-column label="考核名称" align="center" prop="assessTitle"/>
      <el-table-column label="自评人" align="center" prop="staff"/>
      <el-table-column label="自评日期" align="center" prop="staffTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.staffTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="考评人" align="center" prop="reviewer"/>
      <el-table-column label="考评日期" align="center" prop="reviewerTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.reviewerTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="终评人" align="center" prop="decider"/>

      <el-table-column label="终评日期" align="center" prop="deciderTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.deciderTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button v-if="scope.row.status==4" size="mini" type="text"
                     icon="el-icon-document" @click="detailsView(scope.row)"
                     v-hasPermi="['kpi:assess-todolist:delete']"
          >考核结束查看明细
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <el-dialog :title="title" :visible.sync="open" width="96%" top="5vh" append-to-body>
      <el-table v-loading="loading" :data="assessStaffItemList" show-summary :summary-method="getSummaries"
                :max-height="tableHeight" style="width: 100%"
      >
        <el-table-column label="编号" min-width="50" type="index" align="center" fixed prop="id"/>
        <el-table-column label="考核名称" min-width="100" align="center" fixed prop="assessTitle"/>
        <el-table-column label="考核指标" min-width="400" align="center" prop="title"/>
        <el-table-column label="考核标准" min-width="400" align="center" prop="standard"/>
        <el-table-column label="考核分值" min-width="100" align="center" prop="score"/>
        <el-table-column label="自评人" min-width="80" align="center" prop="staff"/>
        <el-table-column label="自评分值" min-width="100" align="center" prop="staffScore"/>
        <el-table-column label="自评备注" min-width="120" align="center" prop="staffRemark"/>
        <el-table-column label="考评人" min-width="80" align="center" prop="reviewer"/>
        <el-table-column label="考评分值" min-width="100" align="center" prop="reviewerScore"/>
        <el-table-column label="考评备注" min-width="120" align="center" prop="reviewerRemark"/>
        <el-table-column label="终评人" min-width="80" align="center" prop="decider"/>
        <el-table-column label="终评分值" min-width="100" align="center" prop="deciderScore"/>
        <el-table-column label="终评备注" min-width="120" align="center" prop="deciderRemark"/>
      </el-table>
      <el-form label-width="100px">
        <el-form-item style="text-align: center;margin-left:-100px;margin-top:10px;">
          <el-button @click="cancel">返回</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>
  </div>
</template>

<script>
import {
  deleteAssessTodolist,
  exportAssessTodolistExcel,
  getAssessTodolist,
  getAssessTodolistPage,
  updateAssessTodolist
} from '@/api/kpi/assessTodolist'
import {mapGetters} from 'vuex'
import {getAssessStaffItemList, updateAssessStaffItem} from '@/api/kpi/assessStaffItem'
import store from '@/store'

export default {
  name: 'AssessTodolist',
  components: {},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 表格的高度
      tableHeight: document.documentElement.scrollHeight - 230 + 'px',
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 考核待办列表
      list: [],
      // 考核评分列表
      assessStaffItemList: [],
      //考核评分状态
      status: 0,
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 50,
        assessTitle: null
      },
      // 评分值班表查询参数
      queryListParams: {
        issueId: null,
        todolistId: null,
        assessTitle: null,
        staff: null,
        staffCompleteStatus: null,
        reviewer: null,
        reviewerCompleteStatus: null,
        decider: null,
        deciderCompleteStatus: null,
        status: null
      },
      // 表单参数
      form: {
        assessTitle: undefined,
        decider: undefined,
        deciderStatus: undefined,
        deciderTime: undefined,
        id: undefined,
        reviewer: undefined,
        reviewerStatus: undefined,
        reviewerTime: undefined,
        staff: undefined,
        staffStatus: undefined,
        staffTime: undefined,
        status: undefined
      },
      // 表单校验
      rules: {
        issueId: [{required: true, message: '考核发布ID不能为空', trigger: 'blur'}],
        assessTitle: [{required: true, message: '考核名称不能为空', trigger: 'blur'}],
        staffTime: [{required: true, message: '自评日期不能为空', trigger: 'blur'}],
        staffStatus: [{required: true, message: '自评状态（1未完成 0已完成）不能为空', trigger: 'blur'}],
        reviewerTime: [{required: true, message: '考评日期不能为空', trigger: 'blur'}],
        reviewerStatus: [{required: true, message: '考评状态（1未完成 0已完成）不能为空', trigger: 'blur'}],
        deciderTime: [{required: true, message: '终评日期不能为空', trigger: 'blur'}],
        deciderStatus: [{required: true, message: '终评状态（1未完成 0已完成）不能为空', trigger: 'blur'}],
        assessStartTime: [{required: true, message: '考核开始时间不能为空', trigger: 'blur'}],
        assessEndTime: [{required: true, message: '考核结束时间不能为空', trigger: 'blur'}],
        status: [{required: true, message: '待办状态（1未完成 0已完成）不能为空', trigger: 'blur'}]
      }
    }
  },
  created() {
    this.getList()
  },
  computed: {
    ...mapGetters([
      'avatar',
      'nickname'
    ])
  },
  methods: {
    getSummaries(param) {
      const {columns, data} = param
      const sums = []
      columns.forEach((column, index) => {
        if (index === 1) {
          sums[index] = '总计'
          return
        }
        if (index === 0 || index === 2 || index === 3 || index === 5 || index === 7 || index === 8 || index === 10 || index === 11 || index === 13) {
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
          sums[index] += ' 分'
        } else {
          sums[index] = ''
        }
      })
      return sums
    },
    /** 查询列表 猎取待办*/
    getList() {
      this.list = []
      this.loading = true
      // 执行查询
      this.queryParams.status=4
      console.log(this.queryParams)
      getAssessTodolistPage(this.queryParams).then(response => {
        const roles = store.getters.roles
        console.log(roles)
        if (roles.includes("super_admin") || roles.includes("director")) {
          this.list = response.data.list
        } else {
          this.list = response.data.list.filter(item => item.staff === this.$store.getters.nickname)
        }
        this.total = response.data.total
        this.loading = false
      })
    },

    /** 取消按钮 */
    cancel() {
      this.open = false
      this.reset()
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        issueId: undefined,
        assessTitle: undefined,
        staff: undefined,
        staffTime: undefined,
        staffStatus: undefined,
        reviewer: undefined,
        reviewerTime: undefined,
        reviewerStatus: undefined,
        decider: undefined,
        deciderTime: undefined,
        deciderStatus: undefined,
        assessStartTime: undefined,
        assessEndTime: undefined,
        status: undefined
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    /** 自评按钮操作 */
    handleStaff(row) {
      this.loading = true
      this.queryListParams.assessTitle = row.assessTitle
      if (row.staffStatus == 1) {
        this.queryListParams.staff = row.staff
      }

      const id = row.id
      //获取待办数据
      getAssessTodolist(id).then(response => {
        this.form = response.data
      })
      // 查询考核评分表
      getAssessStaffItemList(this.queryListParams).then(response => {
        this.assessStaffItemList = response.data
        this.total = response.data.total
        this.loading = false
        this.open = true
        if (row.staffStatus == 1) {
          this.title = row.assessTitle + '自评（自评人：' + row.staff + '-------岗位：' + this.assessStaffItemList[0].post + '）'
        }
        this.status = row.status
      })
    },

    /** 考评按钮操作 */
    handleReviewer(row) {

      this.loading = true
      this.queryListParams.assessTitle = row.assessTitle

      if (row.reviewerStatus == 1) {
        this.queryListParams.reviewer = row.reviewer
      }

      const id = row.id
      //获取待办数据
      getAssessTodolist(id).then(response => {
        this.form = response.data
      })
      // 查询考核评分表
      getAssessStaffItemList(this.queryListParams).then(response => {
        this.assessStaffItemList = response.data
        this.total = response.data.total
        this.loading = false
        this.open = true

        if (row.status == 2) {
          this.title = row.assessTitle + '评审（被评审人：' + row.staff + '-------岗位：' + this.assessStaffItemList[0].post + '）'
        }
        this.status = row.status
      })
    },

    /** 终评按钮操作 */
    handleDecider(row) {
      this.loading = true
      this.queryListParams.assessTitle = row.assessTitle

      if (row.deciderStatus == 1) {
        this.queryListParams.decider = row.decider
      }
      const id = row.id
      //获取待办数据
      getAssessTodolist(id).then(response => {
        this.form = response.data
      })
      // 查询考核评分表
      getAssessStaffItemList(this.queryListParams).then(response => {
        this.assessStaffItemList = response.data
        this.total = response.data.total
        this.loading = false
        this.open = true

        if (row.status == 3) {
          this.title = row.assessTitle + '终评（被终评人：' + row.staff + '-------岗位：' + this.assessStaffItemList[0].post + '）'
        }
        this.status = row.status
      })
    },

    /** 考核结束查看明细 */
    detailsView(row) {
      this.loading = true
      this.queryListParams.todolistId = row.id
      // 查询考核评分表
      getAssessStaffItemList(this.queryListParams).then(response => {
        this.assessStaffItemList = response.data
        this.total = response.data.total
        this.loading = false
        this.open = true
        this.title = row.assessTitle + '明细'
        this.status = 4
      })
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加考核待办'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id
      getAssessTodolist(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改考核待办'
      })
    },
    /** 考核评分提交按钮 */
    async submitForm() {
      let tempStatus = 0
      for (let assessStaffItem of this.assessStaffItemList) {
        tempStatus = assessStaffItem.status
        // 修改考核评分表的评分状态
        if (tempStatus == 1) {
          assessStaffItem.staffTime = new Date(new Date().toLocaleString()).getTime()
          assessStaffItem.status = 2
          //如果自评人和审核人是一个人，将考核评分表状态设置为终评
          if (assessStaffItem.staff === assessStaffItem.reviewer) {
            assessStaffItem.status = 3
          }
        }
        if (tempStatus == 2) {
          assessStaffItem.reviewerTime = new Date(new Date().toLocaleString()).getTime()
          assessStaffItem.status = 3
        }
        if (tempStatus == 3) {
          assessStaffItem.deciderTime = new Date(new Date().toLocaleString()).getTime()
          assessStaffItem.status = 4
        }
        await updateAssessStaffItem(assessStaffItem)
      }
      // 评分完成后修改待办的状态
      if (tempStatus == 1) {
        this.form.status = 2
        this.form.staffStatus = 0
        //如果自评人和审核人是一个人，将考核待办表状态设置为终评
        if (this.form.staff === this.form.reviewer) {
          this.form.status = 3
          this.form.reviewerStatus = 0
        }
        this.form.staffTime = new Date(new Date().toLocaleString()).getTime()
        // this.form.staffTime= new Date()
        await updateAssessTodolist(this.form)
        this.$modal.msgSuccess('考核自评完成')
        this.open = false
        this.getList()
      }
      if (tempStatus == 2) {
        this.form.status = 3
        this.form.reviewerStatus = 0
        this.form.reviewerTime = new Date(new Date().toLocaleString()).getTime()
        await updateAssessTodolist(this.form)
        this.$modal.msgSuccess('考核评审完成')
        this.open = false
        this.getList()
      }
      if (tempStatus == 3) {
        this.form.status = 4
        this.form.deciderStatus = 0
        this.form.deciderTime = new Date(new Date().toLocaleString()).getTime()
        await updateAssessTodolist(this.form)
        this.$modal.msgSuccess('考核终评完成')
        this.open = false
        this.getList()
      }
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id
      this.$modal.confirm('是否确认删除考核待办编号为"' + id + '"的数据项?').then(function () {
        return deleteAssessTodolist(id)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    }
    ,
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams}
      params.pageNo = undefined
      params.pageSize = undefined
      this.$modal.confirm('是否确认导出所有考核待办数据项?').then(() => {
        this.exportLoading = true
        return exportAssessTodolistExcel(params)
      }).then(response => {
        this.$download.excel(response, '考核待办.xls')
        this.exportLoading = false
      }).catch(() => {
      })
    }
  }
}
</script>
