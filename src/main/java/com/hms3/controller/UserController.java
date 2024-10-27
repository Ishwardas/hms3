package com.hms3.controller;

import com.hms3.entity.AppUser;
import com.hms3.repository.AppUserRepository;
import com.hms3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private AppUserRepository appUserRepository;
    private UserService userService;

    public UserController(AppUserRepository appUserRepository, UserService userService) {
        this.appUserRepository = appUserRepository;
        this.userService = userService;
    }
@PostMapping("/signup")
    public ResponseEntity<?> createUser(
            @RequestBody AppUser appUser
    ) {
        Optional<AppUser> opUsername = appUserRepository.findByUsername(appUser.getUsername());
        if (opUsername.isPresent()) {
            return new ResponseEntity<>("this is allready preasent", HttpStatus.INTERNAL_SERVER_ERROR);
         }
        Optional<AppUser> opEmail = appUserRepository.findByEmail(appUser.getEmail());
        if (opEmail.isPresent()) {
            return new ResponseEntity<>("this is allready present", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        AppUser saveProfile = userService.createProfile(appUser);
        return new ResponseEntity<>(saveProfile,HttpStatus.CREATED);
    }
    @GetMapping("/message")
public String getMessage(){
        return "hello";
    }
}
