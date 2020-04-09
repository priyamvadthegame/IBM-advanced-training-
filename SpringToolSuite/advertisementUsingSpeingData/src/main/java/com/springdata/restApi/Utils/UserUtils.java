package com.springdata.restApi.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.springdata.restApi.entity.User;

public class UserUtils {
	
	public static List<com.springdata.restApi.json.User> convertUserEntityListToUserList(List<User> userEntityList) {
		List<com.springdata.restApi.json.User> userList = new ArrayList<com.springdata.restApi.json.User>();
		Consumer<User> consumer = ((User userEntity)->userList.add(convertUserEntityToUser(userEntity)));
		userEntityList.stream().forEach(consumer);
		return userList;
	}
	
	public static com.springdata.restApi.json.User convertUserEntityToUser(User userEntity) {
		return new com.springdata.restApi.json.User(userEntity.getId(), userEntity.getUserName(), 
				userEntity.getFirstName(), userEntity.getLastName(),userEntity.getPassword(),userEntity.getEmail(),userEntity.getPhone());
	}

	public static User convertUserToUserEntity(com.springdata.restApi.json.User user) {
		return new User(user.getId(), user.getUserName(), 
				user.getFirstName(), user.getLastName(),user.getPassword(),user.getEmail(),user.getPhone());
	}
}