package ramosprodev.spotify_api_application.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
    String errorCode,
    String message,
    LocalDateTime timestamp,
    String path
) {
    public ErrorResponse(String errorCode, String message, String path) {
        this(errorCode, message, LocalDateTime.now(), path);
    }
}
