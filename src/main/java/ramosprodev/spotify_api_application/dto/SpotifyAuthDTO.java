package ramosprodev.spotify_api_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyAuthDTO {
    private String accessToken;
    private Integer expiresIn;
    private String tokenType;
}
