package com.fulian.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fulian.web.model.entity.Generator;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 浮涟i
 * @description 针对表【generator(代码生成器)】的数据库操作Mapper
 * @createDate 2024-07-16 21:23:38
 * @Entity com.fulian.web.model.entity.Generator
 */
public interface GeneratorMapper extends BaseMapper<Generator> {

    @Select("select id,distPath from generator where isDelete = 1")
    List<Generator> listDeletedGenerator();
}




