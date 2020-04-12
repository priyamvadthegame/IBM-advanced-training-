package com.springdata.restApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.restApi.Utils.UserUtils;
import com.springdata.restApi.json.User;
import com.springdata.restApi.repositories.UserRepositories;
@Service
public class userServiceImp implements UserService {
	
	@Autowired
	private UserRepositories userRepository;
	@Override
	public List<User> getAllUsers() {
		List<com.springdata.restApi.entity.UserEntity> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public User getCurrentUserDetails(String id) {
		com.springdata.restApi.entity.UserEntity userEntity = userRepository.findBySessionId(id).get(0);
		return UserUtils.convertUserEntityToUser(userEntity);	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<com.springdata.restApi.entity.UserEntity> userEntityList = userRepository.findByFirstName(firstName);
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		com.springdata.restApi.entity.UserEntity userEntity = 
				userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	@Override
	public User update(User user) {
		com.springdata.restApi.entity.UserEntity userEntity = userRepository.findById(user.getId()).get();
		if(userEntity != null) {
			userEntity.setFirstName(user.getFirstName());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity.setLastName(user.getLastName());
			userEntity.setEmail(user.getEmail());
			userEntity.setPhone(user.getPhone());
			userEntity = userRepository.save(userEntity);
			return UserUtils.convertUserEntityToUser(userEntity);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		if(userRepository.existsById(Long.valueOf(id))) {
			userRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

	@Override
	public List<User> getUsersByOrderByFirstNameAsc() {
		List<com.springdata.restApi.entity.UserEntity> userEntityList = userRepository.findByOrderByFirstNameAsc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public List<User> getUsersByOrderByFirstNameDesc() {
		List<com.springdata.restApi.entity.UserEntity> userEntityList = userRepository.findByOrderByFirstNameDesc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	

	@Override
	public String autoLogin(User user) {
		com.springdata.restApi.entity.UserEntity user1=userRepository.findByUserName(user.getUserName()).get(0);
		if(user1!=null) {
			if(user1.getPassword().equals((user.getPassword()))) {
				String sessionId = new java.rmi.server.UID().toString().substring(0, 10);
				user1.setSessionId(sessionId);
				userRepository.save(user1);
				return sessionId;
			}
			else {
				return "invalid password";
			}
		}
		
		else {
			return "invalid username";
		}	
	}

	@Override
	public User autoLogout(String apiKey) {
		com.springdata.restApi.entity.UserEntity user1=userRepository.findBySessionId(apiKey).get(0);
		user1.setSessionId(null);
		com.springdata.restApi.entity.UserEntity userEntity=userRepository.save(user1);	
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	

}
