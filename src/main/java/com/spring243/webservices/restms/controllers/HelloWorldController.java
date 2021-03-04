package com.spring243.webservices.restms.controllers;

import com.spring243.webservices.restms.beans.HelloBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {
  
  final static String HELLO_WORLD = "/hello-world";
  final static String PATH_VAR = "/path-var";
  
  @GetMapping(HELLO_WORLD)
  public String helloWorld() {
    return "Hello World!";
  }

  // /hello-world/path-var
  @GetMapping(HELLO_WORLD + PATH_VAR)
  public HelloBean helloBean(@RequestParam("name") String name) {
    return new HelloBean("Hello " + name);
  }

  @GetMapping("/hello/goodbye/{name}")
  public HelloBean helloGoodbyeBean(@PathVariable("name") String name) {
    return new HelloBean("GoodBye " + name);
  }

}
