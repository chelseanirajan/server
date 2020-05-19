package com.jugal.adminsecurity.user.controller;

import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.service.UserService;
import com.jugal.adminsecurity.user.model.Student;
import com.jugal.adminsecurity.user.service.StudentServiceImpl;
import com.jugal.adminsecurity.validator.UserStudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@PreAuthorize("hasRole('ROLE_USER')")
@Controller
@RequestMapping("/user/student")
public class UserStudentController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected StudentServiceImpl studentService;



    @Autowired
    private UserStudentValidator validator;

    @GetMapping("")
    public String getForm(@ModelAttribute("userForm") Student userForm,Model model,
                          HttpServletRequest     httpServletRequest) {
        // userform vanne chahinxa ra use vako  xaina  tah? yeslegarda  ho issue ako ho tara bind bha
        //User user =userService.getCurrentUser();
        //Student userForm = studentService.findByUser(user);
        //model.addAttribute("student", userForm);
        return "/views/user/add_product";
    }
    @PostMapping({"search"})
    public String searchStudent(@RequestParam("searchName") String searchName, Model model){
        //if(searchName==null){

       // }
        model.addAttribute("student",studentService.findByNameLike(searchName));
        return "/views/user/dashboard";

    }
   /* @PostMapping({"searching"})
    public String findStudent(@ModelAttribute("userForm") Student userForm, Model model){
        //model.addAttribute("student",studentService.findAll());
        return "/views/user/dashboard";
    } */
    /*@PostMapping("/checked")
    public String postCheckedStudent(@RequestParam("checkIds") List<Long> ids,Model model,
                          HttpServletRequest httpServletRequest) {
        //User user =userService.getCurrentUser();
        //Student userForm = studentService.findByUser(user);
        //model.addAttribute("student", userForm);
        List<Student> std = studentService.findAllById(ids); //parsing garnu parxa ki k ho
        std.stream().forEach(System.out::println);
        System.out.println(ids);
        return "redirect:/";  //yo  page xa ki  nai?xa
    }
*/

    /*
    public String contact(Model model, HttpServletRequest httpServletRequest) {
        userService.getCurrentUser();
        //User user =
       /* Student student = studentService.findByUser(user);
        if (null == student) {
            return "/views/user/dashboard";
        }
        if (!model.containsAttribute("userForm")) {
            Student userForm = studentService.findByUser(user);
            if (null == userForm) {
                userForm = new Student();
            }
            model.addAttribute("userForm", userForm);
        }
        //Student userForm = studentService.findByUser(user);
       // model.addAttribute("userForm", userForm);
        //httpServletRequest.setAttribute("url", "student");
        return "/views/user/add_product";
    }
*/
    @PostMapping("")
    public ModelAndView saveOrUpdateContact(@ModelAttribute("userForm") Student userForm,
                                            HttpServletRequest httpServletRequest,
                                            BindingResult result,
                                            RedirectAttributes redirectAttrs) {
        userForm.setUser(userService.getCurrentUser());
        validator.validate(userForm, result);
        if (result.hasErrors()) {
            httpServletRequest.setAttribute("url", "userForm");
            return new ModelAndView("/views/user/add_product");
        }
        studentService.save(userForm);
        redirectAttrs.addFlashAttribute("student",userForm);
        return new ModelAndView("redirect:/");
    }


    @GetMapping({"/edit"})
    public String editStudent(@RequestParam("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("userForm",student);
        model.addAttribute("id",student.getId());
        return "/views/user/edit-student";
    }
    @PostMapping({"/update"})
    public ModelAndView updateContact(@ModelAttribute("userForm") Student userForm,
                                            HttpServletRequest httpServletRequest,
                                            BindingResult result,
                                            RedirectAttributes redirectAttrs) {
        userForm.setUser(userService.getCurrentUser());
        validator.validate(userForm, result);
        if (result.hasErrors()) {
            httpServletRequest.setAttribute("url", "student");
            return new ModelAndView("/views/user/add_product");
        }
        studentService.save(userForm);
        redirectAttrs.addFlashAttribute("student",userForm);
        return new ModelAndView("redirect:/");
    }
    @GetMapping({"/delete"})
    public String deleteStudent(@RequestParam("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping({"/details"})
    public String studentDetailsdById(@RequestParam("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("detail", student);
        return "/views/user/detail-student";
    }
    @GetMapping({"excel"})
    public String getExcel() {
        return "/views/user/add-excel";
    }

    @PostMapping({"/nn"})
    public ModelAndView updateFile(@RequestParam("uploadfile") MultipartFile file,
                                 //  @ModelAttribute("studentList") Student studentList,
                                   HttpServletRequest httpServletRequest,

                                   RedirectAttributes redirectAttrs) {

      /*
      validation
       */
        if(file.getSize() == 0){
            httpServletRequest.setAttribute("url", "student");
            return new ModelAndView("/views/user/add-excel");
        }

     //   studentList.setUser(userService.getCurrentUser());
        //validator.validate(studentList, result);
//        if (result.hasErrors()) {
//            httpServletRequest.setAttribute("url", "student");
//            return new ModelAndView("/views/user/add-excel");
//        }
       // try {
           // userForm.setUser(userService.findByUsername(httpServletRequest.getUserPrincipal().getName()));
            studentService.store(file);
            redirectAttrs.addFlashAttribute("message","File Uploaded Successfully!");
       // } catch (Exception e) {
         redirectAttrs.addFlashAttribute("message","Fail! -> Uploaded filename: " + file.getOriginalFilename());

        //}
        return new ModelAndView("redirect:/");
    }


}
