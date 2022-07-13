import request from '@/utils/request'

// 查询预约通知抬头列表
export function listImNoticeH(query) {
  return request({
    url: '/entry/imNoticeH/list',
    method: 'get',
    params: query
  })
}

// 查询预约通知抬头详细
export function getImNoticeH(id) {
  return request({
    url: '/entry/imNoticeH/' + id,
    method: 'get'
  })
}

// 新增预约通知抬头
export function addImNoticeH(data) {
  return request({
    url: '/entry/imNoticeH',
    method: 'post',
    data: data
  })
}

// 修改预约通知抬头
export function updateImNoticeH(data) {
  return request({
    url: '/entry/imNoticeH',
    method: 'put',
    data: data
  })
}

// 删除预约通知抬头
export function delImNoticeH(id) {
  return request({
    url: '/entry/imNoticeH/' + id,
    method: 'delete'
  })
}
