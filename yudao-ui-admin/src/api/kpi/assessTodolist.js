import request from '@/utils/request'

// 创建考核待办
export function createAssessTodolist(data) {
  return request({
    url: '/kpi/assess-todolist/create',
    method: 'post',
    data: data
  })
}

// 更新考核待办
export function updateAssessTodolist(data) {
  return request({
    url: '/kpi/assess-todolist/update',
    method: 'put',
    data: data
  })
}

// 删除考核待办
export function deleteAssessTodolist(id) {
  return request({
    url: '/kpi/assess-todolist/delete?id=' + id,
    method: 'delete'
  })
}

// 获得考核待办
export function getAssessTodolist(id) {
  return request({
    url: '/kpi/assess-todolist/get?id=' + id,
    method: 'get'
  })
}

// 获得考核待办分页
export function getAssessTodolistPage(query) {
  return request({
    url: '/kpi/assess-todolist/page',
    method: 'get',
    params: query
  })
}

// 导出考核待办 Excel
export function exportAssessTodolistExcel(query) {
  return request({
    url: '/kpi/assess-todolist/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
