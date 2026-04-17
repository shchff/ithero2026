package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.User;
import com.envelope.ithero2026.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository repository;

    @Transactional(readOnly = true)
    public User loadUser(long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User with id=" + id + " not fount"));
    }
}
