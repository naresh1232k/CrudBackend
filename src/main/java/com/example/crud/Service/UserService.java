package com.example.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.Model.Users;
import com.example.crud.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public List<Users> Allusers() {
		return repo.findAll();
	}	
	
	
	public Users saveUsers(Users users) {
	    return repo.save(users);
	}
	
	
	public void  deleteUser(Long id) {
		repo.deleteById(id);
	}
	
	


	public Users updateUser(Long id, Users user) {

	    Users existingUser = repo.findById(id).orElse(null);

	    if (existingUser != null) {
	        existingUser.setName(user.getName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setCity(user.getCity());
	        existingUser.setPhone(user.getPhone());

	        return repo.save(existingUser);
	    }

	    return null;
	}
	
}
