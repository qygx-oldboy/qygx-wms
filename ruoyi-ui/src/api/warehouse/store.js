import request from '@/utils/request'

// 查询仓库定义列表
export function listStore(query) {
  return request({
    url: '/warehouse/store/list',
    method: 'get',
    params: query
  })
}

// 查询仓库定义详细
export function getStore(id) {
  return request({
    url: '/warehouse/store/' + id,
    method: 'get'
  })
}

// 新增仓库定义
export function addStore(data) {
  return request({
    url: '/warehouse/store',
    method: 'post',
    data: data
  })
}

// 修改仓库定义
export function updateStore(data) {
  return request({
    url: '/warehouse/store',
    method: 'put',
    data: data
  })
}

// 删除仓库定义
export function delStore(id) {
  return request({
    url: '/warehouse/store/' + id,
    method: 'delete'
  })
}
