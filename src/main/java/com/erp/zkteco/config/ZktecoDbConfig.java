package com.erp.zkteco.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.erp.zkteco.repository", // Cambia al paquete de tus repositorios ZKTECO
        entityManagerFactoryRef = "zktecoEntityManagerFactory",
        transactionManagerRef = "zktecoTransactionManager"
)
public class ZktecoDbConfig {

    @Bean(name = "zktecoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.zktecodata")
    public DataSource zktecoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "zktecoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean zktecoEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("zktecoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.erp.zkteco.entity") // Cambia al paquete de tus entidades ZKTECO
                .persistenceUnit("zkteco")
                .build();
    }

    @Bean(name = "zktecoTransactionManager")
    public PlatformTransactionManager zktecoTransactionManager(
            @Qualifier("zktecoEntityManagerFactory") EntityManagerFactory zktecoEntityManagerFactory) {
        return new JpaTransactionManager(zktecoEntityManagerFactory);
    }
}
