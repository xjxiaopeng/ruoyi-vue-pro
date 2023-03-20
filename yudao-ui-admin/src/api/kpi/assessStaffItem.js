import request from '@/utils/request'

// 创建考核评分
export function createAssessStaffItem(data) {
  return request({
    url: '/kpi/assess-staff-item/create',
    method: 'post',
    data: data
  })
}

// 更新考核评分
export function updateAssessStaffItem(data) {
  return request({
    url: '/kpi/assess-staff-item/update',
    method: 'put',
    data: data
  })
}

// 删除考核评分
export function deleteAssessStaffItem(id) {
  return request({
    url: '/kpi/assess-staff-item/delete?id=' + id,
    method: 'delete'
  })
}

// 获得考核评分
export function getAssessStaffItem(id) {
  return request({
    url: '/kpi/assess-staff-item/get?id=' + id,
    method: 'get'
  })
}

// 获得考核评分分页
export function getAssessStaffItemPage(query) {
  return request({
    url: '/kpi/assess-staff-item/page',
    method: 'get',
    params: query
  })
}

export function getAssessStaffItemList(query) {
  return request({
    url: '/kpi/assess-staff-item/list',
    method: 'get',
    params: query
  })
}

// 导出考核评分 Excel
export function exportAssessStaffItemExcel(query) {
  return request({
    url: '/kpi/assess-staff-item/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
