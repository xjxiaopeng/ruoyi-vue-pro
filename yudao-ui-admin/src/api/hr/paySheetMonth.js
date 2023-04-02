import request from '@/utils/request'

// 创建月工资
export function createPaySheetMonth(/*data*/) {
  return request({
    url: '/hr/pay-sheet-month/create',
    method: 'post',
    /*data: data*/
  })
}

// 更新月工资
export function updatePaySheetMonth(data) {
  return request({
    url: '/hr/pay-sheet-month/update',
    method: 'put',
    data: data
  })
}

// 删除月工资
export function deletePaySheetMonth(id) {
  return request({
    url: '/hr/pay-sheet-month/delete?id=' + id,
    method: 'delete'
  })
}

// 获得月工资
export function getPaySheetMonth(id) {
  return request({
    url: '/hr/pay-sheet-month/get?id=' + id,
    method: 'get'
  })
}

// 获得月工资分页
export function getPaySheetMonthPage(query) {
  return request({
    url: '/hr/pay-sheet-month/page',
    method: 'get',
    params: query
  })
}

// 导出月工资 Excel
export function exportPaySheetMonthExcel(query) {
  return request({
    url: '/hr/pay-sheet-month/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
