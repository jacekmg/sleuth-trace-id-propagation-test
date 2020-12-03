package app.controllers;

import app.dtos.TraceIdDto;
import brave.Span;
import brave.Tracer;
import brave.propagation.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

@RestController
public class TraceIdController {
    private Tracer tracer;

    @Autowired
    public TraceIdController(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping(value = "/api/v1/traceId/test")
    public Mono<TraceIdDto> get() {
        String traceId = getTraceId().orElse(null);
        return Mono.defer(() -> Mono.just(getTraceId()))
                .subscribeOn(Schedulers.elastic())
                .map(elasticThreadId -> new TraceIdDto(traceId, elasticThreadId.orElse(null)));
    }

    private Optional<String> getTraceId() {
        return Optional.of(tracer)
                .map(Tracer::currentSpan)
                .map(Span::context)
                .map(TraceContext::traceIdString);
    }

}


