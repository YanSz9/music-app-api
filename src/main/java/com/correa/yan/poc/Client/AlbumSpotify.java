package com.correa.yan.poc.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AlbumSpotifyClient",
        url = "https://api.spotify.com"
)
public interface AlbumSpotify {
    @GetMapping(value = "v1/browse/new-releases")
    AlbumResponse getReleases(@RequestHeader("Authorization")String authorization);
}
