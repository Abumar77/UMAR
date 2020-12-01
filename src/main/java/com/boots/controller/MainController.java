package com.boots.controller;

 import com.boots.entity.Course;
 import com.boots.repository.CourseRepository;
 import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    CourseRepository courseRepository;

    //Admin Controllers
    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }


    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

    //Course controllers
    @GetMapping("/courses")
    public String coursesList(Model model) {
        model.addAttribute("allCourses",userService.allCourses());
        return "courses";
    }

    @GetMapping("/courses/gt/{cid}")
    public String coursesgt(@PathVariable("cid") int cid, Model model) {

        model.addAttribute("allCourses",userService.coursegt(cid));
        return "startcourse";
    }
}