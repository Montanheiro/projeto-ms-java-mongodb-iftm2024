package com.montanha.user_api.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.montanha.user_api.models.dto.UserDTO;
import com.montanha.user_api.models.User;
import com.montanha.user_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}
