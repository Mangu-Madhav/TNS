package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users;
import com.example.demo.server.userServiceImp;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class usercont {
	@Autowired
	userServiceImp service;
	@GetMapping("/users/{id}")
	public ResponseEntity<users> getusers(@PathVariable int id){
		users e = service.getusers(id);
		if (e!=null)
			return new ResponseEntity<users>(e,HttpStatus.OK);
		else
			return new  ResponseEntity<users>(e,HttpStatus.NOT_FOUND);		
	}
	@GetMapping("/users")
	public List<users>list()
	{
		return service.getAllusers();
	}
	@PostMapping("/users")
	public void addusers(@RequestBody users e)
	{
		service.addusers(e);
	}	
}
