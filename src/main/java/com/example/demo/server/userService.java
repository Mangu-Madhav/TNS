package com.example.demo.server;
import java.util.List;
import com.example.demo.users;
public interface userService {
public users getusers(int id);
 public List<users>getAllusers();
 public void addusers(users e);
}
