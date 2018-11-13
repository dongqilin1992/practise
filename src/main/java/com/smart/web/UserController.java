package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/11 17:57
 */
@RestController
@RequestMapping("/user")
//@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {

        User user = userService.findUserById(id);
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("demo");
        return user;
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public void adduser(User user){
        //User user = new User();
        user.setPassword("123");
        userService.adduser(user);
    }
    //@RequestMapping("/getUser")
    public String getUser(@Valid
                          @ModelAttribute("user") User user, BindingResult bindingresult) {
        if(bindingresult.hasErrors()){
            System.out.println("Validated error!");
            return "demo";
        }
        return "demo";
    }
    //@RequestMapping("/getUser2")
    public String getUser2(User user) {

        return "demo";
    }
    //@RequestMapping("/getUser3")
    public String getUser3(ModelMap modelMap, SessionStatus sessionstatus) {
         Object user = modelMap.get("user");
         System.out.println(user);
        sessionstatus.setComplete();
        return "demo";
    }

    //@ModelAttribute("user")
    public User user(){
        User user = new User();
        user.setPassword("b");
        return user;
    }
}
