import request from '@/utils/request'

// 查询客户信息列表
export function listCus(query) {
  return request({
    url: '/basicData/cus/list',
    method: 'get',
    params: query
  })
}

// 查询客户信息详细
export function getCus(id) {
  return request({
    url: '/basicData/cus/' + id,
    method: 'get'
  })
}

// 新增客户信息
export function addCus(data) {
  return request({
    url: '/basicData/cus',
    method: 'post',
    data: data
  })
}

// 修改客户信息
export function updateCus(data) {
  return request({
    url: '/basicData/cus',
    method: 'put',
    data: data
  })
}

// 删除客户信息
export function delCus(id) {
  return request({
    url: '/basicData/cus/' + id,
    method: 'delete'
  })
}
