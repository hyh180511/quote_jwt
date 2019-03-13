# quote方案标准化前后端分离demo项目
------------------------------------------------
### 项目介绍
　　随着一期项目的完成上线，在使用过程中出现更多的特殊的功能需求，后期的项目的需求更改控制的缺失，项目的功能越来越多，项目越来越臃肿，前后端的耦合越来越紧密，项目原来的功能越来越难于实施。<br>
　　居于此，项目的重构，前后端的分离，业务的重新拆分的工作显得迫在眉睫，分布式项目的流行，cas有状态的登录转无状态登录的探索等，所以出现了二期的功能改造。

### 技术选型
**后端技术**

| 技术     | 说明    | 官网    |
|  ----   |   ----   |    ----   |
| Spring Boot | 容器+MVC框架 | https://spring.io/projects/spring-boot |
| Spring Security | 认证和授权框架 | https://spring.io/projects/spring-security |
| MyBatis | ORM框架 | http://www.mybatis.org/mybatis-3/zh/index.html |
| Swagger-UI | 文档生产工具 | https://github.com/swagger-api/swagger-ui |
| Docker | 应用容器引擎 | https://www.docker.com/ |
| Druid | 数据库连接池 | https://github.com/alibaba/druid |
| JWT | JWT登录支持 | https://github.com/jwtk/jjwt |
| Lombok | 简化对象封装工具 | https://github.com/rzwitserloot/lombok |
| Log4j2 | 应用日志框架 | http://logging.apache.org |



**前端技术**

| 技术     | 说明    | 官网    |
|  ----   |   ----   |    ----   |
| Vue  | 前端框架 | https://vuejs.org/ |
| Vuex | 全局状态管理框架 | https://vuex.vuejs.org/ |
| v-charts | 基于Echarts的图表框架 | 	https://v-charts.js.org/ |

### 项目模块介绍
* 用户管理+jwt实现sso登录登录
* 方案审核管理
* 方案创建（能耗现状、空调设备配置、照明配置、问题分析、解决方案、设计依据、项目实施等模块）
* 方案打印

### 参考书籍
* Spring实战（第4版）
* Spring Boot实战
* MyBatis从入门到精通
* 深入浅出MySQL
* 循序渐进Linux（第2版）
* springsercurity参考文档
* 第一本Docker书

### 项目存在问题
* 没有使用redis管理jwt的令牌
* 图片直接转base64存储，缺少一个文件系统，可以考虑fastDFS或HDFS。第三期建议使用fastDFS,
HDFS是给超大的数据集设计的， FASTDFS是专为小文件设计的，FASTDFS有JAVA 的API。

### 项目总结
方案标准化二期项目历时两个月完成开发，二期工作的重点是实现前后端的分离、业务的重新拆分、数据的兼容性设计、cas转jwt实现无状态的sso探索。前后端两人按照预期完成开发功能及上线。
