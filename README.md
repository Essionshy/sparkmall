**项目说明** 

- 命名规范
-  1、实体类              xxxEntity
-  2、数据访问层Dao       xxxDao
-  3、Service层接口       xxxService  ,实现类 xxxServiceImpl
-  4、页面展示对象        xxxVo
-  5、前台向后台传递参数  xxxParam
-  6、服务间调用传输对象  xxxDTO ,保存在 commons 模块下
  

- 系统各模块后台管理部分统一返回R对象
- 系统中远程调用，数据传递统一返回CommonResult<T>对象
- MQ 消息对象在 commons 包中统一定义，保证发送消息与消费消息的类型完全一致

<br>
 

**项目结构** 
```
sparkmall 
├─db  项目SQL语句
│
├─commons 公共模块
│  ├─aspect 系统日志
│  ├─exception 异常处理
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息
│ 
│ 
│  
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源

```
<br> 



<br>


<br> 


**技术选型：** 
- 核心框架：Spring Boot 2.1
- 安全框架：Apache Shiro 1.4
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.0
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x 
<br> 


 **后端部署**
- 通过git下载源码
- idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
- 创建各微服务独立的数据 ，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据
- 修改application-dev.yml，更新MySQL账号和密码- 


<br> 

 **前端部署**
 - 本项目是前后端分离的，还需要部署前端，才能运行起来
 - 前端下载地址：https://gitee.com/renrenio/renren-fast-vue
 - 前端部署文档：https://gitee.com/renrenio/renren-fast-vue/wikis/Home
 - 前端部署完毕，就可以访问项目了，账号：admin，密码：admin
 
 <br>