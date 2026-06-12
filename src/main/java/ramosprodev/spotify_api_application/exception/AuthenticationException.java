package ramosprodev.spotify_api_application.exception;

public class AuthenticationException extends SpotifyApiException {
    public AuthenticationException(String message) {
        super("AUTH_ERROR", message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super("AUTH_ERROR", message, cause);
    }
}
