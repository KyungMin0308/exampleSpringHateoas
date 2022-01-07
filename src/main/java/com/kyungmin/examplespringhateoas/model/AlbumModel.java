package com.kyungmin.examplespringhateoas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "albums", itemRelation = "album")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumModel extends RepresentationModel<AlbumModel> { //Representation 을 위한 클래스
    private Long id;
    private String title;
    private String description; //앨범 설명
    private String releaseDate; //발매일

    private List<ActorModel> actors;
}
