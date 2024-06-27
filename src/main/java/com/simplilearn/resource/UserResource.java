package com.simplilearn.resource;

import com.simplilearn.Dto.ChangePasswordDto;
import com.simplilearn.model.Purchase;
import com.simplilearn.model.User;
import com.simplilearn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
@SessionAttributes("token")

public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showUserList(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/changepass")
    public String changePass(Model model) {
        return "changepass";
    }

    @PostMapping("/changepass")
    public ResponseEntity<?> changePassword(@RequestBody @Valid ChangePasswordDto data) {
        userService.changePassword(data.getCurrentPassword(), data.getNewPassword());
        return ResponseEntity.ok().build();
    }
}
