package ramosprodev.spotify_api_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyArtistDTO {
    private String id;
    private String name;
    private String externalUrl;
    private String imageUrl;
}
