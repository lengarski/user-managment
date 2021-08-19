package eu.lengarski.usermanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class UserManagmentSystemApplication
{

    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(UserManagmentSystemApplication.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("server.port", 2020);
        map.put("spring.jpa.hibernate.ddl-auto", "update");
        map.put("spring.jpa.database-platform", "org.hibernate.dialect.MySQL8Dialect");
        app.setDefaultProperties(map);

        app.run(args);

    }

}
