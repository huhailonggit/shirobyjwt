### 基于shiro+jwt的权限认证
#### 登录流程

~~~mermaid
graph LR
A[登录] --> B(认证)
B --> C(账户是否激活)
C --> |true| D[常规校验] --> G[相关提示]
C --> |false| E[邮箱验证] --> F[重新登录]
G --> H[登录成功获取到token]
F --> H[登录成功获取到token]
~~~

