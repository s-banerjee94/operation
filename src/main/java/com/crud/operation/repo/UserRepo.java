package com.crud.operation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.operation.modal.User;
@Repository
public interface UserRepo extends JpaRepository<User, String> {

	public Optional<User> findById(long id);
	public void deleteById(long id);
}
