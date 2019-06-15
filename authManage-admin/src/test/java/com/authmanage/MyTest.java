package com.authmanage;


import com.authmanage.generator.service.IGenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    IGenService genService;

    @Test
    public void test1() throws FileNotFoundException {
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(new File("D:\\文件\\新建文本文档.txt")));
        genService.generatorCode("sys_user",zip);
    }

}
