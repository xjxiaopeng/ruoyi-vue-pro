import request from '@/utils/request'

// 创建考核发布
export function createAssessIssue(data) {
  return request({
    url: '/kpi/assess-issue/create',
    method: 'post',
    data: data
  })
}

// 更新考核发布
export function updateAssessIssue(data) {
  return request({
    url: '/kpi/assess-issue/update',
    method: 'put',
    data: data
  })
}

// 删除考核发布
export function deleteAssessIssue(id, title) {

  return request({
    url: '/kpi/assess-issue/delete?id=' + id + '&title=' + title,
    method: 'delete',
  })
}

// 获得考核发布
export function getAssessIssue(id) {
  return request({
    url: '/kpi/assess-issue/get?id=' + id,
    method: 'get'
  })
}

// 获得考核发布分页
export function getAssessIssuePage(query) {
  return request({
    url: '/kpi/assess-issue/page',
    method: 'get',
    params: query
  })
}

// 导出考核发布 Excel
export function exportAssessIssueExcel(query) {
  return request({
    url: '/kpi/assess-issue/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}

// 考核发布状态修改
export function changeAssessIssueStatus(id, status, assessTitle) {
  const data = {
    id,
    status,
    assessTitle
  }
  return request({
    url: '/kpi/assess-issue/update-status',
    method: 'put',
    data: data
  })
}
