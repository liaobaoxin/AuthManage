package com.authmanage.generator.service;

import java.util.zip.ZipOutputStream;

public interface IGenService {
    public void generatorCode(String tableName, ZipOutputStream zip);
}
