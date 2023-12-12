import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}

export default {
  getUserList(searchList) {
    return request({
      url: '/user/list',
      method: 'get',
      params: {
        pageNo: searchList.pageNo,
        pageSize: searchList.pageSize,
        username: searchList.username,
        phone: searchList.phone,
      }
    })
  },
  
  addUser(user) {
    return request({
      url: '/user',
      method: 'post',
      data: user
    })
  },
  getUserId(id) {
    return request({
      url: `/user/${id}`,
      method: 'get',
    })
  },
  saveUser(user){
    if(user.id == null &&user.id==undefined){
      return this.addUser(user);
    }
    return this.updateUser(user);
  },
  updateUser(user) {
    return request({
      url: '/user',
      method: 'put',
      data: user
    })
  },
  deleteUserById(id) {
    return request({
      url: `/user/${id}`,
      method: 'delete',
    })
  },

}