package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getUsersList());
        return "users";
    }

    @RequestMapping("/edituser/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edituser");
        User user = userService.findById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping( "/user-update")
    public String update(@ModelAttribute("user") User user) {
         userService.edit(user);
         return "redirect:/users";
    }

    @GetMapping("/adduser")
    public String addUsers(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }
    @PostMapping("/users")
    public String newUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
