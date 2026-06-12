package ramosprodev.spotify_api_application.exception;

public class SpotifyApiException extends RuntimeException {
    private final String errorCode;

    public SpotifyApiException(String message) {
        super(message);
        this.errorCode = "SPOTIFY_API_ERROR";
    }

    public SpotifyApiException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "SPOTIFY_API_ERROR";
    }

    public SpotifyApiException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SpotifyApiException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
