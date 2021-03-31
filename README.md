### 基于shiro+jwt的权限认证

[登录注册Demon地址：https://www.huhailong.vip/webproject/shirobyjwt](https://www.huhailong.vip/webproject/shirobyjwt)

#### token保活机制
每次请求时在封装的http请求中调用keepAlive保活接口，用来获取新的token，新token会重新从调用后开始计算过期时间
，只有页面没有请求活动后达到过期时间才会跳转到登录页面。


