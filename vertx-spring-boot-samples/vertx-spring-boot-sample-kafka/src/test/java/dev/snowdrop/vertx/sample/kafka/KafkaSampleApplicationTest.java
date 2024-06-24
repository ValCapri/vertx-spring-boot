package dev.snowdrop.vertx.sample.kafka;

import java.time.Duration;
import java.util.List;

import dev.snowdrop.vertx.VertxAutoConfiguration;
import dev.snowdrop.vertx.http.server.ServerAutoConfiguration;
import dev.snowdrop.vertx.kafka.KafkaAutoConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(partitions = 1, ports = { 9092 })
@ImportAutoConfiguration({KafkaAutoConfiguration.class, VertxAutoConfiguration.class, ServerAutoConfiguration.class})
public class KafkaSampleApplicationTest {

    @Autowired
    ApplicationContext context;

    private WebTestClient client;

    @BeforeEach
    public void setup() {
        this.client = WebTestClient.bindToApplicationContext(this.context).build();
    }

    @Test
    public void shouldLogAndReceiveMessages() {
        logMessage("first");
        logMessage("second");

        await()
            .atMost(Duration.ofSeconds(2))
            .untilAsserted(() -> assertThat(getLoggedMessages()).containsOnly("first", "second"));
    }

    private List<String> getLoggedMessages() {
        return client.get()
            .accept(TEXT_EVENT_STREAM)
            .exchange()
            .expectStatus()
            .isOk()
            .returnResult(String.class)
            .getResponseBody()
            .collectList()
            .block(Duration.ofSeconds(2));
    }

    private void logMessage(String message) {
        client.post()
            .bodyValue(message)
            .exchange()
            .expectStatus()
            .isOk();
    }
}
