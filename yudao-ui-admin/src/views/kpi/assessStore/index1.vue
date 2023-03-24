<template>
  <div class="app-container">
    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <div style="text-align: center">
        <el-tooltip placement="bottom" effect="light">
          <div style="font-size: 13px;line-height: 30px; " slot="content">
            ①此考核满分为100分，80分及以上可发放全额绩效工资。每月各项目评分人评分后由人力资源部统一汇总，以此为依据核算工资。
            <br/>②连续3个月绩效考核分数低于60分，降职一级并降薪，连续3个月绩效考核分数低于50分，事务所有权单方解除劳动合同，并不支付任何形式的经济赔偿及违约金。
            <br/>③每月按照预算表业绩目标数，月末根据业绩完成率，发放相应绩效工资。
            <br/>④原则上绩效得分最高不超过200分，主任可根据情况调整。
            <br/>⑤工作出现重大失误，绩效工资减半。
          </div>
          <el-button>查看考核说明</el-button>
        </el-tooltip>
      </div>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['kpi:assess-store:create']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
                   :loading="exportLoading"
                   v-hasPermi="['kpi:assess-store:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table show-summary :summary-method="getSummaries" v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" type="index" min-width="8%"/>
      <el-table-column label="考核指标" min-width="30%" align="center" prop="title"/>
      <el-table-column label="考核标准" min-width="30%" align="center" prop="standard"/>
      <el-table-column label="考核分值" min-width="8%" align="center" prop="score"/>
      <el-table-column label="所属岗位" min-width="8%" align="center">
        <template v-slot="scope">
          {{ scope.row.postId == 0 ? '所有岗位' : getPostname(scope.row.postId) }}
        </template>
      </el-table-column>
      <el-table-column label="指标状态" min-width="8%" align="center" prop="status">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.COMMON_STATUS" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="全员指标" min-width="8%" align="center" prop="fixed">
        <template v-slot="scope">
          <span>{{ scope.row.fixed == 0 ? '是' : '否' }}</span>
        </template>
      </el-table-column>

<!--      <el-table-column label="操作" min-width="10%" align="center" class-name="small-padding fixed-width">-->
<!--        <template v-slot="scope">-->
<!--          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"-->
<!--                     v-hasPermi="['kpi:assess-store:update']">修改-->
<!--          </el-button>-->
<!--          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"-->
<!--                     v-hasPermi="['kpi:assess-store:delete']">删除-->
<!--          </el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="考核指标" prop="title">
          <el-input v-model="form.title" type="textarea" autosize placeholder="请输入考核指标"/>
        </el-form-item>
        <el-form-item label="考核标准" prop="standard">
          <el-input v-model="form.standard" type="textarea" autosize placeholder="请输入考核标准"/>
        </el-form-item>
        <el-form-item label="考核分值" prop="score">
          <el-input v-model="form.score" placeholder="请输入考核分值"/>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注"/>
        </el-form-item>

        <el-form-item label="岗位">
          <el-select v-model="form.postId" placeholder="请选择" @change="selectChang(form.postId)">
            <el-option
              v-for="item in postOptions"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="指标状态" prop="status">
          <el-radio-group v-model="form.status">

            <el-radio v-for="dict in statusDictDatas" :key="parseInt(dict.value)" :label="parseInt(dict.value)">
              {{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="全员指标" prop="fixed">
          <el-radio-group v-model="form.fixed" @change="radioChange">
            <el-radio :key="0" :label="0">是</el-radio>
            <el-radio :key="1" :label="1">否</el-radio>
          </el-radio-group>
        </el-form-item>
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
  createAssessStore,
  deleteAssessStore,
  exportAssessStoreExcel,
  getAssessStore,
  getAssessStorePage,
  updateAssessStore
} from '@/api/kpi/assessStore'
import {DICT_TYPE, getDictDatas} from '@/utils/dict'
import {listSimplePosts} from '@/api/system/post'
import {listUserByUsername} from "@/api/system/user";

export default {
  name: 'AssessStore',
  computed: {
    DICT_TYPE() {
      return DICT_TYPE
    }
  },
  components: {},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      oldPostId: undefined,
      // 总条数
      total: 0,
      // 考核指标库列表
      list: [],
      listUser: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 岗位选项
      postOptions: [],
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 20,
        title: null,
        standard: null,
        status: null,
        fixed: undefined,
        postId: undefined,
        createTime: []
      },

      postQueryParams: {

        username: undefined

      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [{required: true, message: '考核指标不能为空', trigger: 'blur'}],
        standard: [{required: true, message: '考核标准不能为空', trigger: 'blur'}],
        score: [{required: true, message: '考核分值不能为空', trigger: 'blur'}],
        status: [{required: true, message: '指标状态不能为空', trigger: 'change'}],
        fixed: [{required: true, message: '全员指标', trigger: 'blur'}]
      },
      // 数据字典
      statusDictDatas: getDictDatas(DICT_TYPE.COMMON_STATUS)
    }
  },
  created() {
    this.getPostNames()
    // this.getList()
    this.getTreeselect()

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
        if (index === 4 || index === 5 || index === 6 ) {
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
    selectChang(postId) {
      if (postId == 0) {
        this.form.fixed = 0
      } else {
        this.form.fixed = 1
      }
    },
    /* 全员指标按钮发生变化时 */
    radioChange(value) {

      if (value == 0) {
        // this.oldPostId=this.form.postId
        this.form.postId = 0
      } else {
        this.form.postId = this.oldPostId
      }

    },
    /** 查询部门下拉树结构 + 岗位下拉 */
    getTreeselect() {
      /*   listSimpleDepts().then(response => {
          // 处理 deptOptions 参数
          this.deptOptions = [];
          this.deptOptions.push(...this.handleTree(response.data, "id"));
        }); */
      listSimplePosts().then(response => {
        // 处理 postOptions 参数
        this.postOptions = []
        this.postOptions.push({id: 0, name: '所有岗位'})
        this.postOptions.push(...response.data)
      })
    },
    getPostname(postId) {
      for (const post of this.postOptions) {
        if (post.id === postId) {
          return post.name
        }
      }
      return '未知(' + postId + ')'
    },
    getPostNames() {
      let params = {...this.postQueryParams}
      params.username = this.$store.getters.nickname
      // console.log(params.username)
      listUserByUsername(params).then(response => {
        this.listUser = response.data
        console.log("this.listUserpost", this.listUser)
        this.getList()
      })
    },
    /** 查询列表 */
    getList() {
      this.loading = true
      // 执行查询
      // console.log(this.listUser[0].postIds[0])
      this.queryParams.fixed = 0
      this.queryParams.postId = this.listUser[0].postIds[0]
      getAssessStorePage(this.queryParams).then(response => {
        // this.list = response.data.list
        // console.log("this.listUser",this.listUser)
        // console.log("this.list",this.list)
        // this.list = response.data.list.filter(item=>item.postId.includes(this.listUser.postIds))
        this.list = response.data.list
        this.total = response.data.total
        this.loading = false
        console.log("this.list", this.list)
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
        title: undefined,
        standard: undefined,
        score: undefined,
        remark: undefined,
        postId: undefined,
        status: 0,
        fixed: 1
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
      // 获得下拉数据
      this.getTreeselect()
      this.open = true
      this.title = '添加考核指标库'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      this.oldPostId = row.postId
      this.getTreeselect()
      const id = row.id
      getAssessStore(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改考核指标库'
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
          updateAssessStore(this.form).then(response => {
            this.$modal.msgSuccess('修改成功')
            this.open = false
            this.getList()
          })
          return
        }
        // 添加的提交
        createAssessStore(this.form).then(response => {
          this.$modal.msgSuccess('新增成功')
          this.open = false
          this.getList()
        })
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id
      this.$modal.confirm('是否确认删除考核指标库编号为"' + id + '"的数据项?').then(function () {
        return deleteAssessStore(id)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams}
      params.pageNo = undefined
      params.pageSize = undefined
      this.$modal.confirm('是否确认导出所有考核指标库数据项?').then(() => {
        this.exportLoading = true
        return exportAssessStoreExcel(params)
      }).then(response => {
        this.$download.excel(response, '考核指标库.xls')
        this.exportLoading = false
      }).catch(() => {
      })
    }

  },

}
</script>
