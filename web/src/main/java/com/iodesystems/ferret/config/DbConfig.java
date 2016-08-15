package com.iodesystems.ferret.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Component
public class DbConfig {
    @Value("${ferret.db.jndi}")
    String jndi;

    @Value("${ferret.db.jdbc.url}")
    String jdbcUrl;

    @Value("${ferret.db.jdbc.user}")
    String jdbcUser;

    @Value("${ferret.db.jdbc.password}")
    String jdbcPassword;

    @Bean
    public DataSource dataSource() throws NamingException {
        if (!jndi.isEmpty()) {
            return InitialContext.doLookup(jndi);
        } else {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName(Driver.class.getName());
            hikariConfig.setConnectionTestQuery("select 1");
            hikariConfig.setJdbcUrl(jdbcUrl);
            hikariConfig.setUsername(jdbcUser);
            hikariConfig.setPassword(jdbcPassword);
            return new HikariDataSource(hikariConfig);
        }
    }
}
