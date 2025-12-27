package me.chahyunwoo.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.chahyunwoo.springbootdeveloper.domain.User;
import me.chahyunwoo.springbootdeveloper.dto.AddUserRequest;
import me.chahyunwoo.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
        // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}
