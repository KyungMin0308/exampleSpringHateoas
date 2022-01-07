package com.kyungmin.examplespringhateoas.assembler;

import com.kyungmin.examplespringhateoas.controller.WebController;
import com.kyungmin.examplespringhateoas.entity.ActorEntity;
import com.kyungmin.examplespringhateoas.entity.AlbumEntity;
import com.kyungmin.examplespringhateoas.model.ActorModel;
import com.kyungmin.examplespringhateoas.model.AlbumModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ActorModelAssembler
        extends RepresentationModelAssemblerSupport<ActorEntity, ActorModel> { //Entity -> Model 로 변환

    public ActorModelAssembler() {
        super(WebController.class, ActorModel.class);
    }

    @Override
    public ActorModel toModel(ActorEntity entity) {
        ActorModel actorModel = instantiateModel(entity);

        actorModel.add( linkTo(methodOn(WebController.class).getActorById(entity.getId()))
                .withSelfRel() );

        actorModel.setId(entity.getId());
        actorModel.setFirstName(entity.getFirstName());
        actorModel.setLastName(entity.getLastName());
        actorModel.setBirthDate(entity.getBirthDate());
        actorModel.setAlbums(toAlbumModel(entity.getAlbums()));
        return actorModel;
    }

    @Override
    public CollectionModel<ActorModel> toCollectionModel(Iterable<? extends ActorEntity> entities) {
        CollectionModel<ActorModel> actorModels = super.toCollectionModel(entities);

        actorModels.add(linkTo(methodOn(WebController.class).getAllActors()).withSelfRel());

        return actorModels;
    }

    private List<AlbumModel> toAlbumModel(List<AlbumEntity> albums) {
        if (albums.isEmpty())
            return Collections.emptyList();

        return albums.stream()
                .map(album -> AlbumModel.builder()
                        .id(album.getId())
                        .title(album.getTitle())
                        .build()
                        .add(linkTo(methodOn(WebController.class).getAlbumById(album.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());
    }
}
