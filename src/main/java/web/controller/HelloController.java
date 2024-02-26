package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.DAO.UserDAO;
import web.DAO.UserDaoImpl;
import web.model.User;
import web.service.UserService;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping(value = "/")
//    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("it's my first CRUD APP ");
//        model.addAttribute("messages", messages);
//        return "index";
//    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {

        List<User> allUser = userService.getAllUsers();
        model.addAttribute("allUser", allUser);

        return "all-users";

    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();

        model.addAttribute("user", user);


        return "user-info";
    }


    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){

        userService.saveUser(user);

        return "redirect:/";
    }



}



