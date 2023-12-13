package ru.sevastopall.readersDairy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sevastopall.readersDairy.service.RoleService;
import ru.sevastopall.readersDairy.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/register")
    public String getRegistationPage(Model model) {
        model.addAttribute("roles", roles.findAll());
        model.addAttribute("classes", classes.findAll());
        return "users/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute User user, String[] roleId, String classId) {
        user.setConfirmed(false);
        List<Role> roleSet = new ArrayList<>();
        for (String id : roleId) {
            roleSet.add(roles.findById(Integer.parseInt(id)).get());
        }
        user.setRoles(roleSet);
        var savedUser = userService.create(user);
        if (user.getRoles().get(0).getName().equals("Teacher")) {
            teacherRegister(user);
        } else if (user.getRoles().get(0).getName().equals("Student")) {
            studentRegister(user, classId);
        }
        if (savedUser == null) {
            model.addAttribute("message", "Ошибка регистрации. Логин занят.");
            return "error/404";
        }
        return "redirect:users/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
        var userOptional = userService
                .findUserByLoginAndPassword(user.getLogin(), user.getPassword());
        if (userOptional.isEmpty()) {
            model.addAttribute("error", "Почта или пароль введены неверно");
            return "error/404";
        }
        var session = request.getSession();
        session.setAttribute("user", userOptional.get());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }
}
