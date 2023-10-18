package com.backend.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "First_Name", nullable = false)
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Email_Address")
	private String emailAddress;

	
}
