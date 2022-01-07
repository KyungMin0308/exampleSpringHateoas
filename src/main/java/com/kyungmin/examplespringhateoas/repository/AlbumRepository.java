package com.kyungmin.examplespringhateoas.repository;

import com.kyungmin.examplespringhateoas.entity.AlbumEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumRepository extends PagingAndSortingRepository<AlbumEntity, Long> {

}
