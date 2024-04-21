package com.crud.operation.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.operation.modal.User;
import com.crud.operation.repo.UserRepo;
import com.crud.operation.service.exception.UserNotFondException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User getUserById(long id) {
		Optional<User> user = this.userRepo.findById(id);
		if (user.isPresent())
			return user.get();
		else
			throw new UserNotFondException("User not found with this  id" + id);

	}

	@Override
	public User createUser(User user) {
		return this.userRepo.save(user);
	}

	@Override
	public User updateUser(User updateUser) {
		User user = getUserById(updateUser.getId());
		user.setEmail(updateUser.getEmail());
		user.setName(updateUser.getName());
		user.setNumber(updateUser.getNumber());
		return this.userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = this.userRepo.findAll();
		return users.isEmpty() ? Collections.emptyList() : users;
	}

	@Override
	public void deleteUser(long id) {
		this.userRepo.deleteById(id);
	}
}
