package com.authmanage;


import com.authmanage.generator.service.IGenService;
import com.authmanage.system.domain.SysUser;
import com.authmanage.system.service.IUserService;
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

    @Autowired
    IUserService userService;

    @Test
    public void test1() throws FileNotFoundException {
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(new File("D:\\1生成文件\\1新建文本文档.zip")));
        genService.generatorCode("sys_dept",zip);
    }

    @Test
    public void test2() throws FileNotFoundException {
        SysUser user = userService.selectUserById(1L);
    }

}
