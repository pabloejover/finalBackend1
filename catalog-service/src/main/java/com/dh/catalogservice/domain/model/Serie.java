package com.dh.catalogservice.domain.model;

import com.dh.catalogservice.client.SerieServiceClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    private String id;
    private String name;
    private String genre;
    private List<SerieServiceClient.SerieDTO.Season> seasons = new ArrayList<>();

}
