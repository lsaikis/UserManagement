package com.backend.main.model;


import java.security.Timestamp;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.generator.Generator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "User_T")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Size(min=4)
	@Column(name = "user_name")
	private String userName;
	
	@Email
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "Password")
	private String password;
	
	@OneToMany(mappedBy = "user")// It is to be mapped to the user field in post bean
	@JsonIgnore //to not to get the postList in JSon format
	private List<Post> posts;
	
	@Column(name="Create_Date")
	private Instant createDate;

	@PrePersist //executed before inserting entity to the db
	public void prePersist() {
	   createDate = Instant.now(); // Set the current date before persisting
	}
	
	
	/* Auditing with Spring Data JPA:
		Spring Data JPA provides built-in support for auditing, 
		which can automatically set fields like creation date, modification date, 
		and user who created or modified the entity. This is useful for maintaining audit trails.
		You can achieve this using annotations 
		like @CreatedDate, @LastModifiedDate, @CreatedBy, and @LastModifiedBy.
		This approach is especially powerful when combined with Spring Security to track users.
	*/
}
