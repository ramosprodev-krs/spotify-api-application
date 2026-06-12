package ramosprodev.spotify_api_application.exception;

public class ResourceNotFoundException extends SpotifyApiException {
    public ResourceNotFoundException(String message) {
        super("RESOURCE_NOT_FOUND", message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super("RESOURCE_NOT_FOUND", message, cause);
    }
}
