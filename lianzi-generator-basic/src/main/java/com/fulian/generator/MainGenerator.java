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
        String inputRootPath = "D:\\code\\lianzi-generator\\lianzi-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "D:\\code\\lianzi-generator";

        String inputPath;
        String outputPath;

        inputPath = new File(inputRootPath,"src/com/fulian/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath,"src/com/fulian/acm/MainTemplate.java").getAbsolutePath();
        // 生成动态文件
        DynamicGenerator.doGenerate(inputPath,outputPath,model);

        inputPath = new File(inputRootPath,".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath,".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);

        inputPath = new File(inputRootPath,".README.md").getAbsolutePath();
        outputPath = new File(outputRootPath,".README.md").getAbsolutePath();
        // 生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);
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
