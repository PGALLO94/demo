package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class GetTestController {

    @GetMapping( value="/test/{version}/hello",produces="application/json")
    public Map<String,String> getData(@PathVariable(value = "version") String version,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "age") String age) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Version", version);
        map.put("Name", name);
        map.put("Age", age);
        return map;
    }
}