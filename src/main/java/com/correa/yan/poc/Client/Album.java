package com.correa.yan.poc.Client;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Album {
    private String id;
    private String name;
    private String releaseDate;
}
