package com.fulian.generator;

import com.fulian.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    /**
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        System.out.println(parentFile.getName());
        // 输入路径
        String inputPath = new File(parentFile,"lianzi-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        // 生成动态文件
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicoutputPath = projectPath + File.separator + "acm-template/src/com/fulian/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath,dynamicoutputPath,model);
    }

    public static void main(String[] args) throws TemplateException, IOException {

        // 数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("fulian");
        mainTemplateConfig.setOutputText("求和结果");
        mainTemplateConfig.setLoop(false);
        doGenerate(mainTemplateConfig);
    }
}
