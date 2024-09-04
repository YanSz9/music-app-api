package com.correa.yan.poc.Controller;

import com.correa.yan.poc.Client.Album;
import com.correa.yan.poc.Client.AlbumSpotify;
import com.correa.yan.poc.Client.AuthSpotify;
import com.correa.yan.poc.Client.LoginRequest;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {
    
    Dotenv dotenv = Dotenv.load();
    String clientId = dotenv.get("CLIENT_ID");
    String clientSecret = dotenv.get("CLIENT_SECRET");
    
    private final AuthSpotify authSpotify;
    private final AlbumSpotify albumSpotify;

    public AlbumController(AuthSpotify authSpotify, AlbumSpotify albumSpotify) {
        this.authSpotify = authSpotify;
        this.albumSpotify = albumSpotify;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> helloWorld(){
        var request = new LoginRequest(
                "client_credentials", 
                clientId,
                clientSecret
        );
        var token = authSpotify.login(request).getAccessToken();
        var response = albumSpotify.getReleases("Bearer " + token);
        
        return ResponseEntity.ok(response.getAlbums().getItems());
    }
}
