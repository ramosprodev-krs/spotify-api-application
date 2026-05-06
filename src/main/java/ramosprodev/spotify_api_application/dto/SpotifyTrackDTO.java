package ramosprodev.spotify_api_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyTrackDTO {
    private String id;
    private String name;
    private String artist;
    private String albumName;
    private String externalUrl;
}
