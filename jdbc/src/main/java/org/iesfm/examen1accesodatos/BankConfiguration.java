package org.iesfm.examen1accesodatos;

import org.iesfm.examen1accesodatos.dao.AccountDAO;
import org.iesfm.examen1accesodatos.dao.CustomerDAO;
import org.iesfm.examen1accesodatos.dao.MovementDAO;
import org.iesfm.examen1accesodatos.jdbc.JDBCAccountDAO;
import org.iesfm.examen1accesodatos.jdbc.JDBCCustomerDAO;
import org.iesfm.examen1accesodatos.jdbc.JDBCMovementDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class BankConfiguration {

    @Bean
    public NamedParameterJdbcTemplate jdbc(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(
            @Value("${database.url}") String url,
            @Value("${database.user}") String user,
            @Value("${database.password}") String password) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public MovementDAO movementDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCMovementDAO(jdbc);
    }

    @Bean
    public AccountDAO accountDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCAccountDAO(jdbc);
    }

    @Bean
    public CustomerDAO customerDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCCustomerDAO(jdbc);
    }

}
