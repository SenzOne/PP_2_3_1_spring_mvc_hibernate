package web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect: /allUsers";
    }

}
