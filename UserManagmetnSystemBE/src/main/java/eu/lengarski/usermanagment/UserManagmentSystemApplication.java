package eu.lengarski.usermanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan ("eu.lengarski.usermanagment")
@EnableJpaRepositories ("eu.lengarski.usermanagment")
@EntityScan ("eu.lengarski.usermanagment")
public class UserManagmentSystemApplication
{

    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(UserManagmentSystemApplication.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("server.port", 19090);
        map.put("spring.jpa.hibernate.ddl-auto", "update");
        map.put("spring.jpa.database-platform", "org.hibernate.dialect.MySQL8Dialect");
        app.setDefaultProperties(map);

        app.run(args);

    }

}
