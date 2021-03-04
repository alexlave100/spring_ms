package com.spring243.webservices.restms.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
  private static List<User> users = new ArrayList<>();

  private int usersCount = 3;

  static {
    users.add(new User(1 ,"Adam", new Date()));
    users.add(new User(2 ,"Eve", new Date()));
    users.add(new User(3 ,"Steve", new Date()));
  }

  // save a user to the "database", which for now is an in-memory arrayList
  public User save(User user) {
    if(user.getId() == null) 
      user.setId(++usersCount);
    users.add(user);
    return user;
  }

  // return all users back in the form of a list
  public List<User> findAll() {
    return users;
  }

  public User findOneUser(int id) {
    for(User u : users)
      if(u.getId() == id)
        return u;

    return null;
  }

}
