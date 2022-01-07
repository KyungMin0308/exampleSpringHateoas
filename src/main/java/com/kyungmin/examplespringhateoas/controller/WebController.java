package com.kyungmin.examplespringhateoas.controller;

import com.kyungmin.examplespringhateoas.assembler.ActorModelAssembler;
import com.kyungmin.examplespringhateoas.assembler.AlbumModelAssembler;
import com.kyungmin.examplespringhateoas.entity.ActorEntity;
import com.kyungmin.examplespringhateoas.entity.AlbumEntity;
import com.kyungmin.examplespringhateoas.model.ActorModel;
import com.kyungmin.examplespringhateoas.model.AlbumModel;
import com.kyungmin.examplespringhateoas.repository.ActorRepository;
import com.kyungmin.examplespringhateoas.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController { //사용자 요청을 처리하는 Main Controller

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorModelAssembler actorModelAssembler;

    @Autowired
    private AlbumModelAssembler albumModelAssembler;

    //Read, 전체 Actor 조회
    @GetMapping("/api/actors")
    public ResponseEntity<CollectionModel<ActorModel>> getAllActors()
    {
        List<ActorEntity> actorEntities = (List<ActorEntity>) actorRepository.findAll();

        return new ResponseEntity<>(
                actorModelAssembler.toCollectionModel(actorEntities),
                HttpStatus.OK);

        //return ResponseEntity.ok(actorModelAssembler.toCollectionModel(actorEntities));
    }

    //Read, ID에 해당하는 Actor 조회
    @GetMapping("/api/actors/{id}")
    public ResponseEntity<ActorModel> getActorById(@PathVariable("id") Long id)
    {
        return actorRepository.findById(id)
                .map(actorModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Read, 전체 Album 조회
    @GetMapping("/api/albums")
    public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums()
    {
        List<AlbumEntity> albumEntities = (List<AlbumEntity>) albumRepository.findAll();

        return new ResponseEntity<>(
                albumModelAssembler.toCollectionModel(albumEntities),
                HttpStatus.OK);

        //return ResponseEntity.ok(albumModelAssembler.toCollectionModel(albumEntities));
    }

    //Read, ID에 해당하는 Album 조회
    @GetMapping("/api/albums/{id}")
    public ResponseEntity<AlbumModel> getAlbumById(@PathVariable("id") Long id)
    {
        return albumRepository.findById(id)
                .map(albumModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
