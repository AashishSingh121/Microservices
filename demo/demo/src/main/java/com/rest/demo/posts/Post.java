package com.rest.demo.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.demo.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {


	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 10)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser( final User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}

	public void setId( final Integer p_id ) {
		id = p_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( final String p_description ) {
		description = p_description;
	}
}
