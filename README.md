# 莲子 - 定制化代码生成项目

>学习教程来源，程序员鱼皮的开源项目：https://github.com/liyupi/yuzi-generator 
> 
>该项目目前处于教程制作阶段，项目会持续开发完善，感谢大家的关注支持！

这次要带大家做的是一个非常有趣又使用的项目，基于 React + Spring Boot + Vert.x 响应式编程的 定制化代码生成项目 。

本次项目依然是从 0 到 1 带大家开发，会遵循企业项目开发的标准流程： 需求分析 => 技术选型 => 项目设计 => 项目初始化 => Demo 编写 => 前后端开发实现 => 测试验证 => 部署上线，带大家一步步完成整个项目。

注意！这次的项目会很特别，听起来是一个项目，但其实是循序渐进的 3 个项目！

完整项目分为 3 个阶段：

1）第一阶段，我会带大家制作属于自己的本代代码生成器，是一个 基于命令行的脚手架，能够根据用户的交互式输入快速生成特定代码。
网上绝大多数的代码生成器教程，也只是讲到这个阶段。

2）第二阶段，让我们上升一个层次，带大家开发制作代码生成器的工具。比如你有一段常用的项目代码，使用该工具，可以快速把项目代码制作为代码生成器，将是提高工作效率的大杀器！

3）第三阶段，让我们在上升一个层次，带大家开发在线代码生成器平台！你可以在平台上制作发布自己的代码生成器，还可以在线使用别人的代码生成器，甚至可以共享协作！

## 第一阶段
1. 学习静态文件生成的两种方式：
   - 使用现有的 `Hutool`工具库
   - 自己写代码进行递归复制
2. 借助`FreeMarker`模板引擎实现动态文件生成。
3. 动静结合，先使用静态文件生成从 `lianzi-generator-demo-projects`目录中拷贝`acm-template`模板文件至`lianzi-generator-basic`下，再通过`FreeMarker`模板文件动态替换复制后的静态文件。
4. `Picocli`命令行框架入门。
5. 命令模式 demo 实现。
6. 结合命令模式实现`Picocli`命令行代码生成器开发。

## 第二阶段
### 制作工具开发
使用**元信息**将项目中使用到硬编码的形式转换为可以灵活替换的配置，让制作工具读取**元信息**配置来生成数据模型文件、生成`Picocli`命令类、生成`Generator`，打`jar`包、封装脚本等。

### 制作工具优化
1. 可移植性优化
   1. 目的：让程序能够在不同机器上运行。
   2. 实现：将绝对路径改为相对路径，复制原始模板文件至输出路径`.source`目录下，作为输入路径。
2. 功能优化
   1. 增加项目介绍文件。
   2. 制作精简版代码生成器，只保留项目原始文件、`jar`文件、脚本文件。
3. 健壮性优化
   1. 目的：在用户不同的输入和使用方式下，保证正常运行，并且正确处理异常状况。 
   2. 实现：元信息校验和默认值填充。
   3. 圈复杂度优化：代码分支判断越多，圈复杂度越高。
      1. 抽取方法。
      2. 在抽取方法中使用**卫语句**，尽早返回。
      3. 使用工具类减少判断代码。
4. 可扩展性优化
   1. 目的：在不修改结构或代码的情况下，能够灵活地添加新功能，并适应新的需求和项目变化。
   2. 实现：
      1. 使用枚举值替代魔法值。
      2. 使用模板方法模式，根据不同流程生成不同代码或文件。

### 配置能力增强
1. 一个模型参数对应某个文件是否生成。
2. 一个模型参数对应多个文件是否生成。
3. 一个模型参数同时控制多处代码修改及文件是否生成。
4. 定义一组相关的模型参数，控制代码修改或文件生成。
5. 定义一组相关的模型参数，并能够通过其他的模型参数控制是否需要输入该组参数。

### 开发代码生成器制作工具
**目标**：让制作工具根据我们的想法，自动给项目文件“挖坑”，并生成相互对应的动态模板文件和元信息配置。
1. 基本流程的实现
2. 工作空间隔离
3. 分布制作能力
4. 单次制作多个模板文件
5. 文件过滤
6. 文件分组
7. 模型分组

### 制作 Spring Boot 项目模板生成器
1. 生成项目基本信息
2. 替换生成的代码包名
3. 控制是否生成帖子相关配置
4. 控制是否需要开启跨域
5. 自定义 Knife4jConfig 接口文档配置
6. 自定义 MySQL 配置信息
7. 控制是否开启 Redis
8. 控制是否开启 Elasticsearch

## 第三阶段
将本地项目线上化，开发一个在线代码生成器平台。
### 云平台开发
1. 需求分析
2. 线上化实现流程
3. 数据库表设计
4. 后端开发
5. 前端页面开发

### 生成器共享
1. 需求分析
2. 通用文件上传下载能力 
   - 使用腾讯云对象存储服务
3. 创建代码生成器功能
4. 代码生成器详情页

### 性能优化
1. 下载生成器接口优化
   - 流式处理
   - 本地缓存
2. 查询性能优化
   - 精简数据
   - SQL 优化
   - 压力测试
   - 多级缓存
   - 计算优化
   - 请求层性能优化

### 存储优化
1. 存储空间优化
   - 引入 xxl-job实现文件清理机制
2. 存储成本优化
3. 存储安全优化