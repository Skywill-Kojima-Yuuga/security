package com.example.demosecurity;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        val user = usersRepository.findByEmail(email);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("ユーザが見つかりませんでした");
        }

        val authorities = new ArrayList();
        val roleAdmin = "ROLE_ADMIN";
        val roleUser = "ROLE_USER";
        if (roleAdmin.equals(user.getRole())) {
            authorities.add(new SimpleGrantedAuthority(roleAdmin));
        } else if (roleUser.equals(user.getRole())) {
            authorities.add(new SimpleGrantedAuthority(roleUser));
        }

        return new UserDetailsImpl(user, authorities);
    }
}