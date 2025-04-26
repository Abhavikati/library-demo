package com.book.bookdemo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@ConfigurationProperties(prefix = "author.datasource")
@EnableJpaRepositories(
        basePackages = "com.book.bookdemo.repository.author",
        entityManagerFactoryRef = "authorEntityManagerFactory",
        transactionManagerRef = "authorTransactionManager"
)
public class AuthorDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.author")
    public DataSourceProperties authorDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource authorDataSource() {

        return authorDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean authorEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(authorDataSource())
                .packages("com.book.bookdemo.entity.author")
                .persistenceUnit("author")
                .build();
    }

    @Bean
    public PlatformTransactionManager authorTransactionManager(
            @Qualifier("authorEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}

