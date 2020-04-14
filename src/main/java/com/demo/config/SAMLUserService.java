package com.demo.config;

import com.demo.models.User;
import com.demo.repository.UsersRepository;
import com.demo.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SAMLUserService implements SAMLUserDetailsService {
  @Autowired
  UsersRepository users;

  @Override
  public User loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
    User user = users.findByEmail(credential.getNameID().getValue());

    /**
     * Anonymus role added to handle unauthorized users trying to login
     * AND Spring security needs role in ROLE_* format
     * */

    return user;
  }

  private List<GrantedAuthority> getAuthorities(String role) {
    List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
    list.add(new SimpleGrantedAuthority(role));
    return list;
  }
}
