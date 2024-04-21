package com.crud.operation.service;

import java.util.List;

import com.crud.operation.modal.User;

public interface UserService {
	public User getUserById(long id);

	public User createUser(User user);

	public User updateUser(User user);
	
	public List<User> getAllUser();
	
	public void deleteUser(long id);
}
