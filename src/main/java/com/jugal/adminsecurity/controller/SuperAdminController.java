package com.jugal.adminsecurity.controller;

import com.jugal.adminsecurity.model.AppRole;
import com.jugal.adminsecurity.model.Role;
import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.repository.RoleRepository;
import com.jugal.adminsecurity.service.RoleService;
import com.jugal.adminsecurity.service.UserService;
import com.jugal.adminsecurity.user.service.StudentServiceImpl;
import com.jugal.adminsecurity.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/super-admin")
public class SuperAdminController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudentServiceImpl studentService;


    @GetMapping()
    public String welcome(Model model) {
        if (!model.containsAttribute("userForm")) {
            model.addAttribute("userForm", new User());
        }
        model.addAttribute("userProfile", userService.getCurrentUser());
        model.addAttribute("student", studentService.findAll());
        Role adminRole = roleService.findByRole(AppRole.ROLE_ADMIN.toString());
        model.addAttribute("admins", adminRole.getUsers());
        return "/views/super-admin/super-admin";
    }

    @PostMapping()
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            redirectAttrs.addFlashAttribute("id", 123);
            redirectAttrs.addFlashAttribute("userForm", userForm);
            return "redirect:/super-admin";
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName(AppRole.ROLE_ADMIN.toString()));
        userForm.setRoles(roles);
        userService.save(userForm);
        return "redirect:/super-admin";
    }
}
