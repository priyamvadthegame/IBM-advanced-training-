package com.springdata.restApi.repositories;
	
	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Component;
	import com.springdata.restApi.entity.User;

	@Component
	public interface UserRepositories extends JpaRepository<User, Long> {
		
		List<User> findByFirstName(String firstName);
		List<User> findByOrderByFirstNameAsc();
		List<User> findByOrderByFirstNameDesc();
		List<User> findByUserName(String userName);
		List<User> findBySessionId(String sessionId);
	}

