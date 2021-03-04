package com.spring243.webservices.restms.user;

import java.util.Date;

public class User {
  
  private Integer id;
  private String name;
  private Date birthDate;

  protected User() {
    
  }

  public User(Integer id, String name, Date birthDate) {
    // invoking the parent class constructor is done implicitly if we don't do it, but what the heck!
    super();
    setId(id);
    setName(name);
    setBirthDate(birthDate);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

}
