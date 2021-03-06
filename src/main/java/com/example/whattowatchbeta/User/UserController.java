package com.example.whattowatchbeta.User;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/")
    public String showIndex() {
        logger.info("index page called");
        return "login";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute @NotNull @Valid UserEntity user) {

        Optional<UserEntity> userEntity = userService.getUserByEmail(user.getEmail());

        if (userEntity.isPresent()) {
            if (user.isSubscribe()) {
                userService.updateUser(user, userEntity);
                return "successfulRegistration.html";
            }
            return "Error.html";
        }
        userService.registerUser(user);
        return "successfulRegistration.html";
    }

}
