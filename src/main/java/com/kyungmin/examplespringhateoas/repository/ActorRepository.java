package com.kyungmin.examplespringhateoas.repository;

import com.kyungmin.examplespringhateoas.entity.ActorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActorRepository extends PagingAndSortingRepository<ActorEntity, Long> {

}
