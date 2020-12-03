package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TraceIdDto {
    private String nativeThreadTraceId;
    private String elasticThreadTraceId;
}
