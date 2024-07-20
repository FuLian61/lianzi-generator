package com.fulian.maker;

//import com.fulian.maker.cli.CommandExecutor;

import com.fulian.maker.generator.main.GenerateTemplate;
import com.fulian.maker.generator.main.MainGenerator;
import com.fulian.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        MainGenerator mainGenerator = new MainGenerator();\
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}