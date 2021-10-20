import request from "@/utils/request";
export default {
  getList(current, size, selectQuery) {
    return request({
      url: `/person/s/${current}/${size}`,
      method: "post",
      data: selectQuery
    })
  },
   //删除讲师
   deleteinfo(id) {
    return request({
        url: `/person/d/${id}`,
        method: 'delete'
    })
},
getpersonsInfo(id){
  return request({
    url: `/person/r/${id}`,
    method: 'get'
})
},
saveOrUpdate(persons){
  return request({
    url: `/person/u/`,
    method: 'post',
    data: persons
})
},
};
