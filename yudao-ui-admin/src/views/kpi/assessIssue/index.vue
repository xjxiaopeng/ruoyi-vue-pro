<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="考核名称" prop="assessTitle">
        <el-input v-model="queryParams.assessTitle" placeholder="请输入考核名称" clearable
                  @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发布状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择发布状态" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.KPI_ASSESS_ISSUE_STATUS)"
                     :key="dict.value" :label="dict.label" :value="dict.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['kpi:assess-issue:create']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
                   :loading="exportLoading"
                   v-hasPermi="['kpi:assess-issue:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" type="index" min-width="8%" align="center" prop="id"/>
      <el-table-column label="考核名称" align="center" min-width="18%" prop="assessTitle"/>


      <el-table-column label="考核员工" min-width="18%" align="center">
        <template v-slot="scope">
          <span v-for="userId in scope.row.userIds">
            {{ getUsername(userId) }}
          </span>
        </template>
      </el-table-column>

      <el-table-column label="考评人" min-width="8%" align="center" prop="reviewer"/>

      <el-table-column label="终评人" min-width="8%" align="center" prop="decider"/>

      <el-table-column label="考核开始时间" align="center" min-width="8%" prop="assessStartTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.assessStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="考核结束时间" align="center" min-width="8%" prop="assessEndTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.assessEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发布状态" min-width="8%" align="center">
        <template v-slot="scope">
          <el-switch v-model="scope.row.status" :active-value="0" :inactive-value="1"
                     @change="handleStatusChange(scope.row)"
          />
        </template>
      </el-table-column>

      <el-table-column label="创建时间" align="center" min-width="8%" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="10%" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['kpi:assess-issue:update']"
          >修改
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['kpi:assess-issue:delete']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="600px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="考核名称" prop="assessTitle">
          <el-input v-model="form.assessTitle" placeholder="请输入考核名称"/>
        </el-form-item>


        <el-form-item label="考核员工">
          <el-select v-model="form.userIds" multiple placeholder="请选择要考核的岗位" style="width:100%">
            <el-option
              v-for="item in users"
              :key="item.id"
              :label="item.nickname"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-row>
          <el-col :span="12">

            <el-form-item label="考评人" prop="reviewer">
              <el-select v-model="form.reviewer" placeholder="请输入考评人" clearable style="width: 100%">
                <el-option v-for="item in users" :key="parseInt(item.id)" :label="item.nickname" :value="item.nickname" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="终评人" prop="decider">
              <el-select v-model="form.decider" placeholder="请输入终评人" clearable style="width: 100%">
                <el-option v-for="item in users" :key="parseInt(item.id)" :label="item.nickname" :value="item.nickname" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">

            <el-form-item label="开始时间" prop="assessStartTime">
              <el-date-picker clearable v-model="form.assessStartTime"
                              type="date"
                              value-format="timestamp"
                              placeholder="选择考核开始时间"
                              style="width: 99%"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="结束时间" prop="assessStartTime">
              <el-date-picker clearable v-model="form.assessEndTime"
                              type="date"
                              value-format="timestamp"
                              placeholder="选择考核结束时间"
                              style="width: 99%"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <!--          <el-form-item label="发布状态" prop="status">
                    <el-radio-group v-model="form.status">
                      <el-radio v-for="dict in this.getDictDatas(DICT_TYPE.INFRA_BOOLEAN_STRING)"
                                :key="dict.value" :label="dict.value"
                      >{{ dict.label }}
                      </el-radio>
                    </el-radio-group>
                  </el-form-item>-->

        <!--        <el-form-item label="发布状态" prop="status">-->
        <!--          <el-radio-group v-model="form.status">-->

        <!--            <el-radio v-for="dict in statusDictDatas" :key="parseInt(dict.value)" :label="parseInt(dict.value)">-->
        <!--              {{ dict.label }}-->
        <!--            </el-radio>-->
        <!--          </el-radio-group>-->
        <!--        </el-form-item>-->
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
  createAssessIssue,
  updateAssessIssue,
  deleteAssessIssue,
  getAssessIssue,
  getAssessIssuePage,
  exportAssessIssueExcel, changeAssessIssueStatus
} from '@/api/kpi/assessIssue'
import { listSimpleDepts } from '@/api/system/dept'
import { listSimplePosts } from '@/api/system/post'
import Treeselect from '@riophae/vue-treeselect'
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import { beginOfDay, formatDate, getDate } from '@/utils/dateUtils'
import { DICT_TYPE, getDictDatas } from '@/utils/dict'
import { getNowDateTime, parseTime } from '../../../utils/ruoyi'
import { CommonStatusEnum } from '@/utils/constants'
import { changeUserStatus, listSimpleUsers } from '@/api/system/user'

export default {
  name: 'AssessIssue',
  computed: {
    DICT_TYPE() {
      return DICT_TYPE
    }
  },
  components: { Treeselect },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      num4: 2,
      num5: 5,
      // 用户下拉列表
      users: [],
      // 考核发布列表
      list: [],
      // 部门树选项
      deptOptions: undefined,
      // 岗位选项
      postOptions: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // deptName: undefined,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        assessTitle: null,
        status: null,
        createTime: []
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        assessTitle: [{ required: true, message: '考核名称不能为空', trigger: 'blur' }],
        // deptId: [{ required: true, message: '考核部门不能为空', trigger: 'blur' }],
        postIds: [{ required: true, message: '岗位编号数组不能为空', trigger: 'blur' }],
        assessStartTime: [{ required: true, message: '考核开始时间不能为空', trigger: 'blur' }],
        assessEndTime: [{ required: true, message: '考核结束时间不能为空', trigger: 'blur' }]
        // status: [{ required: true, message: '发布状态（0未发布 1发布）不能为空', trigger: 'blur' }]
      },
      // 数据字典
      statusDictDatas: getDictDatas(DICT_TYPE.COMMON_STATUS)
    }
  },
  watch: {
    // 根据名称筛选部门树
    deptName(val) {
      this.$refs.tree.filter(val)
    }
  },
  created() {

    this.getList()
    // 获得用户列表
    listSimpleUsers().then(response => {
      this.users = response.data.filter(item=>item.nickname!=='肖鹏');
      console.log(response.data)
      console.log(this.users)
    });
    this.getTreeselect()
  },
  methods: {
    parseTime,

    /** 查询部门下拉树结构 + 岗位下拉 */
    getTreeselect() {
      listSimpleDepts().then(response => {
        // 处理 deptOptions 参数
        this.deptOptions = []
        this.deptOptions.push(...this.handleTree(response.data, 'id'))
      })
      listSimplePosts().then(response => {
        // 处理 postOptions 参数
        this.postOptions = []
        this.postOptions.push(...response.data)
      })
    },
    handleChange(val){
      console.log("输出值为：",val)
    },
    // 考核发布状态修改并生成数据
    handleStatusChange(row) {
      let text = row.status === CommonStatusEnum.ENABLE ? '发布' : '停止'
      this.$modal.confirm('确认要' + text + row.assessTitle + '吗?').then(function() {
        // row.status=0
        return changeAssessIssueStatus(row.id, row.status)
      }).then(() => {
        this.$modal.msgSuccess(row.assessTitle + '已' + text)
      }).catch(function() {
        row.status = row.status === CommonStatusEnum.ENABLE ? CommonStatusEnum.DISABLE
          : CommonStatusEnum.ENABLE
      })
    },
    getUsername(userId) {
      for (const user of this.users) {
        if (user.id === userId) {
          return user.nickname
          // console.log(user.nickname)
        }
      }
      return '未知(' + userId + ')'
    },

    /** 查询列表 */
    getList() {
      this.loading = true
      // 执行查询
      getAssessIssuePage(this.queryParams).then(response => {
        this.list = response.data.list
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
        assessTitle: undefined,
        // deptId: undefined,
        postIds: undefined,
        assessStartTime: undefined,
        assessEndTime: undefined

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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.getTreeselect()
      this.open = true
      this.title = '添加考核发布'
      this.form.assessTitle = formatDate(new Date(), 'yyyy年MM月').toString() + '考核'
      this.form.assessStartTime = new Date(new Date().toLocaleDateString()).getTime()
      this.form.assessEndTime = new Date(new Date().toLocaleDateString()).getTime() + (3600 * 1000 * 24 * 7)
      // this.form.assessEndTime = beginOfDay(new Date(new Date().getTime() + 3600 * 1000 * 24 * 7))
      // console.log('起始日期为：' + this.form.assessStartTime)
      // console.log('结束日期为：' + this.form.assessEndTime)
      this.form.status = 1
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      this.getTreeselect()
      const id = row.id
      getAssessIssue(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改考核发布'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (!valid) {
          return
        }
        // 修改的提交
        if (this.form.id != null) {

          updateAssessIssue(this.form).then(response => {
            this.$modal.msgSuccess('修改成功')
            this.open = false
            this.getList()
          })
          return
        }
        // 添加的提交

        createAssessIssue(this.form).then(response => {
          this.$modal.msgSuccess('新增成功')
          this.open = false
          this.getList()
        })
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id
      this.$modal.confirm('是否确认删除考核发布编号为"' + id + '"的数据项?').then(function() {
        return deleteAssessIssue(id)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = { ...this.queryParams }
      params.pageNo = undefined
      params.pageSize = undefined
      this.$modal.confirm('是否确认导出所有考核发布数据项?').then(() => {
        this.exportLoading = true
        return exportAssessIssueExcel(params)
      }).then(response => {
        this.$download.excel(response, '考核发布.xls')
        this.exportLoading = false
      }).catch(() => {
      })
    },
    // 格式化部门的下拉框
    normalizer(node) {
      return {
        id: node.id,
        label: node.name,
        children: node.children
      }
    }
  }
}
</script>
