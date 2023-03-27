import request from '@/utils/request'

// 创建考核指标库
export function createAssessStore(data) {
  return request({
    url: '/kpi/assess-store/create',
    method: 'post',
    data: data
  })
}

// 更新考核指标库
export function updateAssessStore(data) {
  return request({
    url: '/kpi/assess-store/update',
    method: 'put',
    data: data
  })
}

// 删除考核指标库
export function deleteAssessStore(id) {
  return request({
    url: '/kpi/assess-store/delete?id=' + id,
    method: 'delete'
  })
}

// 获得考核指标库
export function getAssessStore(id) {
  return request({
    url: '/kpi/assess-store/get?id=' + id,
    method: 'get'
  })
}

// 获得考核指标库分页
export function getAssessStorePage(query) {
  return request({
    url: '/kpi/assess-store/page',
    method: 'get',
    params: query
  })
}

export function getAssessStoreListS(query) {
  return request({
    url: '/kpi/assess-store/storelist',
    method: 'get',
    params: query
  })
}

// 导出考核指标库 Excel
export function exportAssessStoreExcel(query) {
  return request({
    url: '/kpi/assess-store/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
