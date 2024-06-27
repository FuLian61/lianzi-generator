package com.fulian.generator;

import com.fulian.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        // 1. 静态文件生成
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "lianzi-generator-demo-projects" + File.separator + "acm-template";
        // 输出路径
        String outputPath = projectPath;
        // 复制
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        // 动态文件生成
        String dynamicInputPath = projectPath + File.separator + "lianzi-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicoutputPath = projectPath + File.separator + "acm-template/src/com/fulian/acm/MainTemplate.java";

        // 数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("fulian");
        mainTemplateConfig.setOutputText("求和结果");
        mainTemplateConfig.setLoop(false);

        DynamicGenerator.doGenerate(dynamicInputPath,dynamicoutputPath,mainTemplateConfig);
    }
}
