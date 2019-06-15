package com.authmanage.generator.service.impl;

import com.authmanage.common.constants.Constants;
import com.authmanage.common.utils.StringUtils;
import com.authmanage.generator.config.GenConfig;
import com.authmanage.generator.domain.ColumnInfo;
import com.authmanage.generator.domain.TableInfo;
import com.authmanage.generator.mapper.GenMapper;
import com.authmanage.generator.service.IGenService;
import com.authmanage.generator.util.GenUtils;
import com.authmanage.generator.util.VelocityInitializer;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Log4j2
@Service
public class GenServiceImpl implements IGenService {

    @Autowired
    GenMapper genMapper;

    public void generatorCode(String tableName, ZipOutputStream zip) {
        // 查询表信息
        TableInfo table = genMapper.selectTableByName(tableName);
        // 查询列信息
        List<ColumnInfo> columns = genMapper.selectTableColumnsByName(tableName);
        // 表名转换成Java属性名
        String className = GenUtils.tableToJava(table.getTableName());
        table.setClassName(className);
        table.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        table.setColumns(GenUtils.transColums(columns));
        // 设置主键
        table.setPrimaryKey(table.getColumnsLast());

        VelocityInitializer.initVelocity();

        String packageName = GenConfig.getPackageName();
        String moduleName = GenUtils.getModuleName(packageName);
        VelocityContext context = GenUtils.getVelocityContext(table);
        // 获取模板列表
        List<String> templates = GenUtils.getTemplates();
        try {
            for (String template : templates) {
                // 渲染模板
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, Constants.UTF8);
                tpl.merge(context, sw);

                // 添加到zip
                zip.putNextEntry(new ZipEntry(GenUtils.getFileName(template, table, moduleName)));
                IOUtils.write(sw.toString(), zip, Constants.UTF8);
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            }
        } catch (IOException e) {
            log.error("渲染模板失败，表名：" + table.getTableName(), e);
        }finally {
            try {
                zip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
