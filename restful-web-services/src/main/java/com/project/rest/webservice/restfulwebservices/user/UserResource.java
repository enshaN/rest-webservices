package com.project.rest.webservice.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired 
	UserDaoService service;
	
@GetMapping(path="/users") 
public List<User> getAllUsers(){
	return service.findAll();
	
	
}

@RequestMapping(method=RequestMethod.GET,path="/users/{id}")
public User findUser(@PathVariable int id) throws UserNotFoundException  {
	User user=service.findById(id);
	if(user==null)
		throw new UserNotFoundException("id :"+id);
	return user;
}

@PostMapping(path="/users")
public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
	User CreatedUser= service.save(user);
	
URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(CreatedUser.getId())
				.toUri();
	return ResponseEntity.created(location).build();
}
@DeleteMapping(path="/users/{id}")
public void deleteUser(@PathVariable int id) throws UserNotFoundException  {
	User user=service.deleteById(id);
	if(user==null)
		throw new UserNotFoundException("id :"+id);
	
}

	
	
}
