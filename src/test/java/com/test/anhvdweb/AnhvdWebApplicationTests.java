package com.test.anhvdweb;

import com.test.anhvdweb.config.datasource.Datasources;
import com.test.anhvdweb.service.WebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AnhvdWebApplicationTests {
    @Autowired
    WebService webService;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional(Datasources.DATASOURCE1)
    public void testConnectDatasource1(){
        webService.getAllHolidays();
    }

}
