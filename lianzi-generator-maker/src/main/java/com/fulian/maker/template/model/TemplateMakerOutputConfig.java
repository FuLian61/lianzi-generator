package com.fulian.maker.template.model;

import lombok.Data;

/**
 * 文件输出配置
 */
@Data
public class TemplateMakerOutputConfig {

    // 从未分组文件中移出组内的同名文件
    private boolean removeGroupFilesFromRoot = true;
}
