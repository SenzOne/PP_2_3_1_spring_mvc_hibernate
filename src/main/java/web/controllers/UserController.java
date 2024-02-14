package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @RequestMapping("/new")
    public String CreateUserForm(@ModelAttribute("user") User user) {
        return "userCreate";
    }

    @PostMapping("/userCreate")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/updateUser")
    public String getEditUserForm(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "userUpdate";
    }


    @PostMapping("/updateUser")
    public String postEditUserForm(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
