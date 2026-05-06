package ramosprodev.spotify_api_application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import ramosprodev.spotify_api_application.dto.SpotifyAlbumDTO;
import ramosprodev.spotify_api_application.dto.SpotifyArtistDTO;
import ramosprodev.spotify_api_application.dto.SpotifyTrackDTO;
import ramosprodev.spotify_api_application.service.SpotifyService;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class SpotifyAPIController {

    private final SpotifyService spotifyService;

    public SpotifyAPIController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/login")
    public RedirectView login() {
        return new RedirectView(spotifyService.getAuthorizationUrl());
    }

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code) {
        spotifyService.exchangeCodeForToken(code);
        return "You are successfully authenticated!";
    }

    @GetMapping("/current-user")
    public ResponseEntity<String> getCurrentUser() {
        return ResponseEntity.ok(spotifyService.getCurrentUser());
    }

    @GetMapping("/my-saved-albums")
    public ResponseEntity<List<SpotifyAlbumDTO>> getMyAlbums() {
        return ResponseEntity.ok(spotifyService.getMyAlbums());
    }

    @GetMapping("/my-saved-tracks")
    public ResponseEntity<List<SpotifyTrackDTO>> getMySavedTracks() {
        return ResponseEntity.ok(spotifyService.getMySavedTracks());
    }

    @GetMapping("/my-top-tracks")
    public ResponseEntity<List<SpotifyTrackDTO>> getMyTopTracks() {
        return ResponseEntity.ok(spotifyService.getMyTopTracks());
    }

    @GetMapping("/my-top-artists")
    public ResponseEntity<List<SpotifyArtistDTO>> getMyTopArtists() {
        return ResponseEntity.ok(spotifyService.getMyTopArtists());
    }

}
