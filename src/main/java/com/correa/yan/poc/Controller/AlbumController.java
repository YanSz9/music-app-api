package com.correa.yan.poc.Controller;

import com.correa.yan.poc.Client.Album;
import com.correa.yan.poc.Service.SpotifyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final SpotifyService spotifyService;
    
    public AlbumController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {
        var albums = spotifyService.getLatestAlbums();
        return ResponseEntity.ok(albums);
    }
}
