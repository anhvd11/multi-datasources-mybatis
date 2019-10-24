package com.test.anhvdweb.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
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
        basePackages = "com.test.anhvdweb.repository.partnerholidays",
        entityManagerFactoryRef = "db1EntityManager",
        transactionManagerRef = Datasources.DATASOURCE1
)
public class Datasource1Config {
    @Autowired
    private Environment env;

    @Bean("datasource1.datasource")
    public DataSource dataSource(){
        OracleDataSource r = new OracleDataSource();
        r.setPoolName("jdbc.datasource1");
        r.setJdbcUrl(env.getProperty("jdbc.datasource1.url"));
        r.setMaximumPoolSize(env.getProperty("jdbc.datasource1.max_pool_size", Integer.class));
        r.setPassword(env.getProperty("jdbc.datasource1.password"));
        r.setUsername(env.getProperty("jdbc.datasource1.user"));
        return r;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean db1EntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(
                new String[] { "com.test.anhvdweb.domain" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager db1TransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                db1EntityManager().getObject());
        return transactionManager;
    }
}
