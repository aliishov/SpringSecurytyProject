package ru.alishov.springcourse.FirstSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alishov.springcourse.FirstSecurityApp.security.PersonDetails;
import ru.alishov.springcourse.FirstSecurityApp.services.AdminService;

@Controller
public class HelloController
{
    private final AdminService adminService;

    public HelloController(AdminService adminService)
    { this.adminService = adminService; }

    @GetMapping("/hello")
    public String sayHello()
    { return "hello"; }

    @GetMapping("/showUserInfo")
    public String showUserInfo()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage()
    {
        adminService.doAdminStuff();
        return "admin";
    }
}