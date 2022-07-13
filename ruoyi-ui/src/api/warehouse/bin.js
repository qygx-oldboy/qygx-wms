import request from '@/utils/request'

// 查询储位定义列表
export function listBin(query) {
  return request({
    url: '/warehouse/bin/list',
    method: 'get',
    params: query
  })
}

// 查询储位定义详细
export function getBin(id) {
  return request({
    url: '/warehouse/bin/' + id,
    method: 'get'
  })
}

// 新增储位定义
export function addBin(data) {
  return request({
    url: '/warehouse/bin',
    method: 'post',
    data: data
  })
}

// 修改储位定义
export function updateBin(data) {
  return request({
    url: '/warehouse/bin',
    method: 'put',
    data: data
  })
}

// 删除储位定义
export function delBin(id) {
  return request({
    url: '/warehouse/bin/' + id,
    method: 'delete'
  })
}
