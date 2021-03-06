package com.sparta.cloneproject.security;

import com.sparta.cloneproject.model.User;
import com.sparta.cloneproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userid).orElseThrow(
                ()-> new UsernameNotFoundException("등록되지 않은 사용자 입니다"));
        return new UserDetailsImpl(user);
    }
}
