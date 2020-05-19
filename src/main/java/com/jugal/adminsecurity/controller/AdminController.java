package com.jugal.adminsecurity.controller;


import com.jugal.adminsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;



    @GetMapping({""})
    public String welcome(Model model) {
        return "admin";
    }

}
