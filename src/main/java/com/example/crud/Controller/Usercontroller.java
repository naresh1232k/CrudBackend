package com.example.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Model.Users;
import com.example.crud.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
	    "http://localhost:5173",
	    "http://localhost:5174"
	})
public class Usercontroller {
	
	@Autowired
	UserService service;

	@GetMapping("/users")
	public List<Users> findAllusers(){
		return service.Allusers();
		
	}
	
	
	@PostMapping("/users")
	public Users addUsers(@RequestBody Users users) {
	    return service.saveUsers(users);
	}
	
	@PutMapping("/users/{id}")
	public Users updateUser(@PathVariable Long id,
	                        @RequestBody Users user) {
	    return service.updateUser(id, user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable Long id){
		 service.deleteUser(id);
	}
	
}
