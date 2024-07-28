package com.fulian.web;

import com.fulian.web.model.entity.Generator;
import com.fulian.web.service.GeneratorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GeneratorTest {

    @Resource
    private GeneratorService generatorService;

    @Test
    public void test(){
        Generator generator = generatorService.getById(1L);

        for (int i = 0; i < 1000; i++) {
            List<Generator> generatorList = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                generator.setId(null);
                generatorList.add(generator);
            }
            generatorService.saveBatch(generatorList);
        }
    }
}
