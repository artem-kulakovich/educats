package by.bntu.fitr.controller;


import by.bntu.fitr.entity.User;
import by.bntu.fitr.service.UserService;
import by.bntu.fitr.util.AuthenticationUtil;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String getSignInForm() {
        return "login";
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestParam("userName") String userName,
                         @RequestParam("password") String password,
                         HttpSession httpSession) {

        User user = userService.findUserByUserName(userName);

        if (!AuthenticationUtil.isValidSignIn(password, user)) {
            return "redirect:/sign-in";
        }
        httpSession.setAttribute("user", user);
        return "redirect:/main";
    }

    @GetMapping("/sign-up")
    public String getSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/sign-up";
        }

        if (!AuthenticationUtil.isValidSignUp(user)
                || userService.findUserByUserName(user.getUserName())
                != null) {
            return "redirect:/sign-up";
        }

        userService.registerUser(user);

        return "redirect:/sign-in";
    }
}
