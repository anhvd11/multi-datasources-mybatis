package com.test.anhvdweb.config.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = "com.test.anhvdweb.repository.partnerholidays2",
        entityManagerFactoryRef = "db2EntityManager",
        transactionManagerRef = Datasources.DATASOURCE2
)
public class DataSource2Config {
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean db2EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource2());
        em.setPackagesToScan(new String[] { "com.test.anhvdweb.domain" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource dataSource2(){
        OracleDataSource r = new OracleDataSource();
        r.setPoolName("jdbc.datasource2");
        r.setJdbcUrl(env.getProperty("jdbc.datasource2.url"));
        r.setMaximumPoolSize(env.getProperty("jdbc.datasource2.max_pool_size", Integer.class));
        r.setPassword(env.getProperty("jdbc.datasource2.password"));
        r.setUsername(env.getProperty("jdbc.datasource2.user"));
        return r;
    }

    @Bean
    public PlatformTransactionManager db2TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(db2EntityManager().getObject());
        return transactionManager;
    }
}
