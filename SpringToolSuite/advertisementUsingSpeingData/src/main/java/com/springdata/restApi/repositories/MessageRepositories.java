package com.springdata.restApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.restApi.entity.MessageEntity;

public interface MessageRepositories extends JpaRepository<MessageEntity, Long> {
	
}


