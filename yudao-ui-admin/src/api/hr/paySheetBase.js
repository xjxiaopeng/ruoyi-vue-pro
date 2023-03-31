import request from '@/utils/request'

// 创建工资基础
export function createPaySheetBase(/*data*/) {
  return request({
    url: '/hr/pay-sheet-base/create',
    method: 'post',
   /* data: data*/
  })
}

// 更新工资基础
export function updatePaySheetBase(data) {
  return request({
    url: '/hr/pay-sheet-base/update',
    method: 'put',
    data: data
  })
}

// 删除工资基础
export function deletePaySheetBase(id) {
  return request({
    url: '/hr/pay-sheet-base/delete?id=' + id,
    method: 'delete'
  })
}

// 获得工资基础
export function getPaySheetBase(id) {
  return request({
    url: '/hr/pay-sheet-base/get?id=' + id,
    method: 'get'
  })
}

// 获得工资基础分页
export function getPaySheetBasePage(query) {
  return request({
    url: '/hr/pay-sheet-base/page',
    method: 'get',
    params: query
  })
}

// 导出工资基础 Excel
export function exportPaySheetBaseExcel(query) {
  return request({
    url: '/hr/pay-sheet-base/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
