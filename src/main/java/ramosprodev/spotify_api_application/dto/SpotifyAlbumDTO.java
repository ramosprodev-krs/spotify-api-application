package ramosprodev.spotify_api_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyAlbumDTO {
    private String id;
    private String title;
    private String primaryArtist;
    private String externalUrl;
    private String imageUrl;
}
