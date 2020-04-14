package com.demo.controller;

import com.demo.UserPrincipal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @RequestMapping("/")
  public ResponseEntity<?> submitRequest(ExpiringUsernameAuthenticationToken userToken) {
    try {
//      User user = (User) userToken.getPrincipal();
      return new ResponseEntity<>(userToken.getPrincipal(), HttpStatus.CREATED);
    } catch(UsernameNotFoundException ex) {
      return new ResponseEntity<>("User doesnot exists", HttpStatus.UNAUTHORIZED);
    }
  }

  @RequestMapping("/api/user")
  public ResponseEntity<?> submitRequest2(ExpiringUsernameAuthenticationToken userToken) {
    UserPrincipal user = (UserPrincipal) userToken.getPrincipal();
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }
}
