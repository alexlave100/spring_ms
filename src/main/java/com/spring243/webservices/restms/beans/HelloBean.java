package com.spring243.webservices.restms.beans;

public class HelloBean {
  private String msg;

  public HelloBean(String msg) {
    setMsg(msg);
  }

  @Override
  public String toString() {
    return String.format("message=%s", msg);
  }
  
  private void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
  
}
