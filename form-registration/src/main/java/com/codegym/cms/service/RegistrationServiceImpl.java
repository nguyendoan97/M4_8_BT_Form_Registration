package com.codegym.cms.service;

import com.codegym.cms.model.User;
import com.codegym.cms.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Iterable<User> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public void save(User user) {
        registrationRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        registrationRepository.delete(id);

    }
}
