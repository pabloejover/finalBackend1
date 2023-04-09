package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
