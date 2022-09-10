package com.example.demo.Controller;

import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class PostTestController {

    @PostMapping(value = "/test/postmethod/sayhello", consumes = "application/json")
    public Map<String,String> getData(@RequestBody Student student) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Student Name", student.getName());
        map.put("Age", Integer.toString(student.getAge()));
        map.put("Gender", student.getGender());
        return map;

    }
}