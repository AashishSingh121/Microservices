package com.rest.demo.users;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import java.util.List;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.rest.demo.version.VersioningPersonController;
import jakarta.validation.Valid;

@RestController
public class UserResource {

	private final UserDaoService service;

	public UserResource( final UserDaoService service) {
		this.service = service;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable final int id) {
		final User user = service.findOne( id);

		if(user==null) {
			throw new UserNotFoundException("id:"+id);
		}

		final EntityModel<User> entityModel = EntityModel.of( user);

		final WebMvcLinkBuilder linkAllUsers =  linkTo( methodOn( getClass()).retrieveAllUsers());
//		final WebMvcLinkBuilder linkGreet = linkTo( methodOn( getClass()).greet() );
		final Link l_linkBuilder = Link.of( "http://localhost:8080/" );
		final WebMvcLinkBuilder linkDelete =   linkTo( methodOn( VersioningPersonController.class).getSecondVersionOfPerson());
//		final Link link = Link.valueOf( "http://localhost:8080/" );
		entityModel.add(linkAllUsers.withRel("all-users"));
		entityModel.add( l_linkBuilder.withRel( "homepage" ) );
		entityModel.add( linkDelete.withRel( "version2-user" ));
//		entityModel.add( linkGreet.withSelfRel() );

		return entityModel;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {

		final User savedUser = service.save( user);

		final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable final int id) {
		service.deleteById(id);
		return "Record Deleted";
	}

	public String greet(){
		return "Welcome";
	}

}
