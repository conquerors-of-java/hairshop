package we.conquerors.hairshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import we.conquerors.hairshop.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String selectUser (
            Model model
    ) throws Exception {
        Integer count = userService.selectUser();
        model.addAttribute("count", count);
        return "index";
    }

    @GetMapping("/users/user/add")
    public String addUser () {
        try{
            userService.registerUser();
        } catch (RuntimeException re) {
            System.err.println(re.getMessage());
        }
        return "redirect:/users";
    }
}
