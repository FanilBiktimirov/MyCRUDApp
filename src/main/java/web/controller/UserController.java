package web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.UserDAO.JpaUserDAO;
import web.UserDAO.UserInterface;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInterface usersDAO;

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", usersDAO.getUserList());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersDAO.getUserById(id));
        return "users/user";
    }

    @GetMapping("/newuser")
    public String newUser(@ModelAttribute("user") @Valid User user) {
        return "users/newuser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/newuser";
        }
        usersDAO.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersDAO.getUserById(id));
        return "users/edit";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        usersDAO.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") long id) {
        usersDAO.delete(id);
        return "redirect:/users";
    }
}
