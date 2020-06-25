package com.codegym.cms.service;

import com.codegym.cms.model.User;

public interface RegistrationService{

    public Iterable<User> findAll();

    public void save(User user);

    public void remove(Long id);
}
