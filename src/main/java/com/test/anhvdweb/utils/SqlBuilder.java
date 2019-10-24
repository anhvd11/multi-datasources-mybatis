package com.test.anhvdweb.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SqlBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlBuilder.class);

    public final static String SQL_WEB = "web";

    public static String getSqlQueryById(String module, String queryId) {
        File folder = null;
        try {
            folder = new ClassPathResource(
                    "sql" + File.separator + module + File.separator + queryId + ".sql").getFile();
            // Read file
            if (folder.isFile()) {
                return new String(Files.readAllBytes(Paths.get(folder.getAbsolutePath())));
            }
        } catch (IOException e) {
            LOGGER.error("Err::: get sql module" + e);
            return null;
        }
        return null;
    }
}
