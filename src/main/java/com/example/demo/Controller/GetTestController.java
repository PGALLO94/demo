package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GetTestController {

    @RequestMapping(method = RequestMethod.GET, value = "/test/{version}/hello")
    public String getData(@PathVariable(value = "version") String version,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "age") String age) {
        return "Version is : " + version + " Name is : " + name + " Age is :" + age;
    }
}