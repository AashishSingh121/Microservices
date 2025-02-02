package com.rest.demo.users;
import java.time.LocalDate;
import java.util.List;
import com.rest.demo.posts.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "USER_DETAILS")
public class User {

	protected User(){}
	@Id
	@GeneratedValue
	private Integer id;

	@Size( min=2, message = "Name should have atleast 2 characters")
	private String name;

	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User( final Integer id, final String name, final LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId( final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( final String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate( final LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts( final List<Post> p_posts ) {
		posts = p_posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}

