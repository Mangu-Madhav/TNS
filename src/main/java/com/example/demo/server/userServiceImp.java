package com.example.demo.server;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.users;
import com.example.demo.repository.userRepository;
@Service
public class  userServiceImp implements userService{
	
	@Autowired
	userRepository rep;
	@Override
	public users getusers(int id) {
		return rep.findById(id).get();
	}
	@Override
	public List<users> getAllusers() {
		
		return rep.findAll();
	}	
	@Override
	public void addusers(users e) {
		rep.save(e);
	}

}
