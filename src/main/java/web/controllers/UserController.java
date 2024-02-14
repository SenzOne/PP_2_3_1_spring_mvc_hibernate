package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/new")
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
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }


//    @GetMapping()
//    public String showAllUser(Model model){
//        model.addAttribute("users", userService.getAllUser());
//        return "allUsers";
//    }
//
//    @GetMapping("/addNewUser")
//    public String addNewUser(Model model){
//        model.addAttribute("user", new User());
//        return "user-info";
//    }
//
//
//    @RequestMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect: /allUsers";
//    }

//    @GetMapping()
//    public String allUsers(Model model) {
//        model.addAttribute("users", userService.getAllUser());
//        return "/allUsers";
//    }
//
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        return "user-info";
//    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect: /allUsers";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("user", userService.getUser(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userService.update(id, user);
//        return "redirect: /allUsers";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect: /allUsers";
//    }


}
