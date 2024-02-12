package web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.models.User;

@Controller
@RequestMapping("/allUsers")
public class UserController {

    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", userDAO.allUsers());
        return "/allUsers";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userDAO.show(id));
////        System.out.println(userDAO.show(id));
//        return "/show";
//
//
//    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        User user = userDAO.show(id);
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect: /allUsers";
    }
}
