package com.hms3.service;

import com.hms3.entity.AppUser;
import com.hms3.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser createProfile(AppUser appUser) {
        AppUser save = appUserRepository.save(appUser);
        return save;
    }
}
