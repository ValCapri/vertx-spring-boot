package dev.snowdrop.vertx.mail;

import dev.snowdrop.vertx.VertxAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ImportAutoConfiguration({MailAutoConfiguration.class, VertxAutoConfiguration.class})
public class MailAutoConfigurationTest {

    @Autowired
    private MailClient mailClient;

    @Test
    public void shouldInjectBeans() {
        assertThat(mailClient).isNotNull();
    }

    @SpringBootApplication
    public static class TestApplication {
        public static void main(String[] args) {
            SpringApplication.run(TestApplication.class, args);
        }
    }
}
