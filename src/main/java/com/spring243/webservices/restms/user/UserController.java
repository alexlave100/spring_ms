package com.spring243.webservices.restms.user;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Controller
@ResponseBody
public class UserController {
  // retrieveAllUsers()
  // retrieveUser(int id)
  private final String USERS = "/users";
  private final String PATHVAR_ID = "/{id}";

  @Autowired
  private UserDaoService userDaoService;

  @GetMapping(USERS)
  public List<User> retrieveAllUsers() {
    return userDaoService.findAll();
  }

  @GetMapping(USERS + PATHVAR_ID)
  public User retrieveUser(@PathVariable("id") int id) {
    User user = userDaoService.findOneUser(id);

    if(user == null) {
      throw new UserNotFoundException("id-"+id);
    }
    else return userDaoService.findOneUser(id);
  }

  // CREATED (201)
  // output - CREATED and return the created URI
  @PostMapping(USERS)
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userDaoService.save(user);

    URI uri = ServletUriComponentsBuilder
    .fromCurrentRequest()
    .path("PATHVAR_ID")
    .buildAndExpand(savedUser.getId())
    .toUri();

    return ResponseEntity.created(uri).build();
  }

}
