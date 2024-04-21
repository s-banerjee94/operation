package com.crud.operation.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, nullable = false, length = 10)
	private long number;

	public User(long id, String name, String email, long number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}

	public User(String name, String email, long number) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

}
