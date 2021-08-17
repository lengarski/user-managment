package eu.lengarski.usermanagment;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javafx.application.Application;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by Georgi Lengarski on  Tuesday 17/08/2021   08:02
 */
@RunWith(SpringRunner.class)
@ContextConfiguration (classes = Application.class, loader = SpringBootContextLoader.class)
@AutoConfigureTestDatabase (connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles (profiles = "test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class AbstractTest
{
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

}
