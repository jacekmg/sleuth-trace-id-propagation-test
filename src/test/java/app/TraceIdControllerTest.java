package app;

import app.dtos.TraceIdDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TraceIdControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testTraceId() {

        TraceIdDto traceIdDto = webTestClient.get().uri("/api/v1/traceId/test")
                .exchange().expectStatus().isOk()
                .expectBody(TraceIdDto.class)
                .returnResult().getResponseBody();

        assertThat(traceIdDto.getNativeThreadTraceId()).isEqualTo(traceIdDto.getElasticThreadTraceId());
    }

}
