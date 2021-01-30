package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.repositories.UserRepository;
import com.example.OnlineBankingSystemAPJ2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailService implements UserDetailsService, UserService {
    @Autowired
    private final UserRepository usersRepository;

    public UsersDetailService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = usersRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }

    @Override
    public User save(User entity) {
        return usersRepository.save(entity);
    }

    @Override
    public void update(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void remove(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public User getUserByUsername(String username) {
        return usersRepository.findUserByUsername(username);
    }
}