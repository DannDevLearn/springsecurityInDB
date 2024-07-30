package com.example.usingdb.config;

import com.example.usingdb.entity.UserEntity;
import com.example.usingdb.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User does not exist!"));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName().name())));

        return new User(userEntity.getUserName(),
                userEntity.getPassword(),
                authorities);
    }
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
//
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        userEntity.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())));
//
//        return new User(userEntity.getUserName(), userEntity.getPassword(), authorities);
//    }
}
