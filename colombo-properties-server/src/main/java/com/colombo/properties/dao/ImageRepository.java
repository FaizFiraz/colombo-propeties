package com.colombo.properties.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}
