package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDAO;
import web.models.User;

import java.util.Map;

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
}
