package ramosprodev.spotify_api_application.service;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import ramosprodev.spotify_api_application.dto.SpotifyAlbumDTO;
import ramosprodev.spotify_api_application.dto.SpotifyArtistDTO;
import ramosprodev.spotify_api_application.dto.SpotifyTrackDTO;
import ramosprodev.spotify_api_application.exception.AuthenticationException;
import ramosprodev.spotify_api_application.exception.SpotifyApiException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SpotifyService {

    private final SpotifyApi spotifyApi;

    public SpotifyService(SpotifyApi spotifyApi) {
        this.spotifyApi = spotifyApi;
    }


    public String getCurrentUser() {
        try {
            var user = spotifyApi.getCurrentUsersProfile().build().execute();
            return user.getDisplayName();
        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new SpotifyApiException("Failed to get current user profile", e);
        }
    }

    public List<SpotifyAlbumDTO> getMyAlbums() {
        try {
            var pagingSavedAlbums = spotifyApi.getCurrentUsersSavedAlbums()
                    .build()
                    .execute();

            return Arrays.stream(pagingSavedAlbums.getItems())
                    .map(savedAlbum -> {
                        var album = savedAlbum.getAlbum();
                        return new SpotifyAlbumDTO(
                                album.getId(),
                                album.getName(),
                                album.getArtists()[0].getName(),
                                album.getExternalUrls().get("spotify"),
                                album.getImages()[0].getUrl()
                        );
                    }).toList();

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new SpotifyApiException("Failed to get saved albums", e);
        }
    }

    public List<SpotifyTrackDTO> getMySavedTracks() {
        try {
            var pagingSavedTracks = spotifyApi.getUsersSavedTracks()
                    .limit(30)
                    .build()
                    .execute();

            return Arrays.stream(pagingSavedTracks.getItems())
                    .map(savedTrack -> {
                        var track = savedTrack.getTrack();
                        return new SpotifyTrackDTO(
                                track.getId(),
                                track.getName(),
                                track.getArtists()[0].getName(),
                                track.getAlbum().getName(),
                                track.getExternalUrls().get("spotify")
                        );

                    }).toList();

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new SpotifyApiException("Failed to get saved tracks", e);
        }
    }

    public List<SpotifyTrackDTO> getMyTopTracks() {
        try {
            var pagingTopTracks = spotifyApi.getUsersTopTracks()
                    .limit(20)
                    .time_range("short_term")
                    .build()
                    .execute();

            return Arrays.stream(pagingTopTracks.getItems())
                    .map(track -> new SpotifyTrackDTO(
                                track.getId(),
                                track.getName(),
                                track.getArtists()[0].getName(),
                                track.getAlbum().getName(),
                                track.getExternalUrls().get("spotify")
                    )).toList();

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new SpotifyApiException("Failed to get top tracks", e);
        }
    }

    public List<SpotifyArtistDTO> getMyTopArtists() {
        try {
            var pagingTopArtists = spotifyApi.getUsersTopArtists()
                    .limit(20)
                    .time_range("short_term")
                    .build()
                    .execute();

            return Arrays.stream(pagingTopArtists.getItems())
                    .map(artist -> new SpotifyArtistDTO(
                            artist.getId(),
                            artist.getName(),
                            artist.getExternalUrls().get("spotify"),
                            artist.getImages()[1].getUrl()
                    )).toList();

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new SpotifyApiException("Failed to get top artists", e);
        }
    }

    public String getAuthorizationUrl() {
        return spotifyApi.authorizationCodeUri()
                .scope("user-library-read user-top-read ")
                .show_dialog(true)
                .build()
                .execute()
                .toString();
    }

    public void exchangeCodeForToken(String code) {
        try {
            var request = spotifyApi.authorizationCode(code).build();
            var credentials = request.execute();

            spotifyApi.setAccessToken(credentials.getAccessToken());
            spotifyApi.setRefreshToken(credentials.getRefreshToken());

        } catch (Exception e) {
            throw new AuthenticationException("Failed to exchange authorization code for token", e);
        }
    }

}

