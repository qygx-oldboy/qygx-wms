import request from '@/utils/request'

// 查询供应商列表
export function listSup(query) {
  return request({
    url: '/basicData/sup/list',
    method: 'get',
    params: query
  })
}

// 查询供应商详细
export function getSup(id) {
  return request({
    url: '/basicData/sup/' + id,
    method: 'get'
  })
}

// 新增供应商
export function addSup(data) {
  return request({
    url: '/basicData/sup',
    method: 'post',
    data: data
  })
}

// 修改供应商
export function updateSup(data) {
  return request({
    url: '/basicData/sup',
    method: 'put',
    data: data
  })
}

// 删除供应商
export function delSup(id) {
  return request({
    url: '/basicData/sup/' + id,
    method: 'delete'
  })
}
