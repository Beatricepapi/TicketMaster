package atu.ie.ticketmaster.controller;

import atu.ie.ticketmaster.model.User;
import atu.ie.ticketmaster.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }
}
