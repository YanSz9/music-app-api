package com.correa.yan.poc.Service;

import com.correa.yan.poc.Client.Album;
import com.correa.yan.poc.Client.AlbumSpotify;
import com.correa.yan.poc.Client.AuthSpotify;
import com.correa.yan.poc.Client.LoginRequest;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotifyService {

    private final AuthSpotify authSpotify;
    private final AlbumSpotify albumSpotify;
    private final String clientId;
    private final String clientSecret;

    public SpotifyService(AuthSpotify authSpotify, AlbumSpotify albumSpotify) {
        this.authSpotify = authSpotify;
        this.albumSpotify = albumSpotify;
        
        Dotenv dotenv = Dotenv.load();
        this.clientId = dotenv.get("CLIENT_ID");
        this.clientSecret = dotenv.get("CLIENT_SECRET");
    }
    
    public List<Album> getLatestAlbums() {
        var request = new LoginRequest(
                "client_credentials",
                clientId,
                clientSecret
        );
        var token = authSpotify.login(request).getAccessToken();
        var response = albumSpotify.getReleases("Bearer " + token);
        return response.getAlbums().getItems();
    }
}
