package com.erp.restaurante.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.erp.restaurante.repository", // Paquete de tus repositorios del restaurante
        entityManagerFactoryRef = "restaurantEntityManagerFactory",
        transactionManagerRef = "restaurantTransactionManager"
)
public class RestaurantDbConfig {

    @Primary
    @Bean(name = "restaurantDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.restaurantdb")
    public DataSource restaurantDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "restaurantEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean restaurantEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("restaurantDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.erp.restaurante.entity") // Paquete de tus entidades del restaurante
                .persistenceUnit("restaurant")
                .build();
    }

    @Primary
    @Bean(name = "restaurantTransactionManager")
    public PlatformTransactionManager restaurantTransactionManager(
            @Qualifier("restaurantEntityManagerFactory") EntityManagerFactory restaurantEntityManagerFactory) {
        return new JpaTransactionManager(restaurantEntityManagerFactory);
    }
}
