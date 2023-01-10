package ru.rombyator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rombyator.model.User;
import ru.rombyator.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());

        return "user/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());

        return "user/create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user, Model model) {
        userService.add(user);
        model.addAttribute("user", user);

        return "user/show";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));

        return "user/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));

        return "user/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") long id, @ModelAttribute("user") User user, Model model) {
        user.setId(id);
        userService.update(user);
        model.addAttribute("user", user);

        return "user/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);

        return "redirect:/";
    }
}
