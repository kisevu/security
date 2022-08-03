package com.ameda.kevin.oauthauthorizationserver.service;

import com.ameda.kevin.oauthauthorizationserver.entity.Student;
import com.ameda.kevin.oauthauthorizationserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Student student=studentRepository.findByEmailAddress(emailAddress);
        if(student==null){
            throw new UsernameNotFoundException("Student was not found!");
        }
        return new User(
                student.getEmailAddress(),
                student.getPassword(),
                student.isEnabled(),
                true,
                true,
                true,
                getAuthorities(List.of(student.getRole()))
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities=new ArrayList<>();
        for(String role:roles){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
