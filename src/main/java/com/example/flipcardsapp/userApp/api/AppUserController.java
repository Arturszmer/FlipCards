package com.example.flipcardsapp.userApp.api;

import com.example.flipcardsapp.userApp.dao.model.AppUserDTO;
import com.example.flipcardsapp.userApp.service.AppUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    List<AppUserDTO> showAllUsers(){
        return appUserService.getAllUsers();
    }

}
