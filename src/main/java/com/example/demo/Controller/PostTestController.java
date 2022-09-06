package com.example.demo.Controller;

import com.example.demo.Dto.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostTestController {

    @RequestMapping(value = "/test/postmethod/sayhello", method = RequestMethod.POST, consumes = "application/json")
    public String getData(@RequestBody Student student) {
        return "Student Name is :" + student.getName() + " Age : " + student.getAge() + " Gender is : " + student.getGender();
    }
}