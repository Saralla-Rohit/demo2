package com.rohit.demo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="registration")
public class RegistrationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 private String email;
	 private String username;
	 private String password;
	public RegistrationDetail() {
		super();
	}


	@Override
	public String toString() {
		return "RegistrationDetail [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ "]";
	}
	 
}


