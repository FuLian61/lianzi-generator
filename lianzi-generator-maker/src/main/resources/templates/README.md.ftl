# ${name}

> ${description}
>
> 作者：${author}
>
> 基于 [FuLian61](https://github.com/FuLian61) 的 [莲子代码生成器项目](https://github.com/FuLian61/lianzi-generator) 制作，感谢您的使用！

可以通过命令行交互式输入的方式动态生成想要的项目代码

## 使用说明

执行项目根目录下的脚本文件：

```
generator <命令> <选项参数>
```

示例命令：

```
generator generate <#list modelConfig.models as modelInfo><#if modelInfo.groupKey??><#else>-${modelInfo.abbr} </#if></#list>
```

## 参数说明

<#list modelConfig.models as modelInfo>
<#if modelInfo.groupKey??>
<#else>
${modelInfo?index + 1}）${modelInfo.fieldName}

类型：${modelInfo.type}

描述：${modelInfo.description}

默认值：${modelInfo.defaultValue?c}

缩写：-${modelInfo.abbr}
</#if>
</#list>

## 支持我们

如果你觉得这个项目对你有帮助，不妨给我们的项目点个星星 ⭐ 来支持我们！你的每一个star都是我们前进的动力！
