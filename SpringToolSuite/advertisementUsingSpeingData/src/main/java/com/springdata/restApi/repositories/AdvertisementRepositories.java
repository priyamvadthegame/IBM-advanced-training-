package com.springdata.restApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.restApi.entity.AdvertisementEntity;
import com.springdata.restApi.entity.UserEntity;

public interface AdvertisementRepositories extends JpaRepository<AdvertisementEntity, Long> {
	List<AdvertisementEntity> findByName(String name);
	List<AdvertisementEntity> findByOrderByNameAsc();
	List<AdvertisementEntity> findByOrderByNameDesc();
	List<AdvertisementEntity> findByStatus(String status);
	List<AdvertisementEntity> findById(long id);
	List<AdvertisementEntity> findByPostId(String postId);
}

