package com.spring243.webservices.restms.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class UserController {
  // retrieveAllUsers()
  // retrieveUser(int id)
  private final String USERS = "/users";

  @Autowired
  private UserDaoService userDaoService;

  @GetMapping(USERS)
  public List<User> retrieveAllUsers() {
    return userDaoService.findAll();
  }

  @GetMapping(USERS + "/{id}")
  public User retrieveUser(@PathVariable("id") int id) {
    return userDaoService.findOneUser(id);
  }

  // CREATED (201)
  // output - CREATED and return the created URI
  @PostMapping(USERS)
  public User createUser(@RequestBody User user) {
    User savedUser = userDaoService.save(user);
    return savedUser;
  }

}
