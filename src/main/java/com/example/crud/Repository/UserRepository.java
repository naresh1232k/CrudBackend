package com.example.crud.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	
}
