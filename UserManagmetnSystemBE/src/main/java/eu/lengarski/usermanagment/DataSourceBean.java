package eu.lengarski.usermanagment;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Georgi Lengarski on  Thursday 12/08/2021   08:06
 */
@Configuration
@Component
public class DataSourceBean
{
    @ConfigurationProperties (prefix = "spring.datasource")
    @Bean
    @Primary
    public DataSource getDataSource()
    {
        return DataSourceBuilder.create()
                .url(UserManagmentSystemConstants.DB_URL)
                .username(UserManagmentSystemConstants.DB_USERNAME)
                .password(UserManagmentSystemConstants.DB_PASSWORD)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

}

