package com.jugal.adminsecurity.controller;

import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.service.UserService;
import com.jugal.adminsecurity.user.model.Student;
import com.jugal.adminsecurity.user.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@PreAuthorize("hasRole('ROLE_USER')")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    protected UserService userService;

@Autowired
protected StudentServiceImpl studentService;

    /*@GetMapping({""})
    public String welcome(Model model) {
        return "/views/user/dashboard";
    }*/

    @GetMapping({""})
    public String dashboard(@ModelAttribute("userForm") Student userForm, Model model, HttpServletRequest httpServletRequest) {
        model.addAttribute("student", studentService.findAllByUser(userService.getCurrentUser()));
        httpServletRequest.setAttribute("url", "dashboard");
        return "/views/user/dashboard";
    }

    /*
    @PostMapping("/nn")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
        //userForm.setUser(userService.getCurrentUser());
        try {
            studentService.store(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());

        }
        return "/views/user/add-excel";
    }

*/

}
