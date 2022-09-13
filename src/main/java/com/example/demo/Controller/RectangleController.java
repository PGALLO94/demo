package com.example.demo.Controller;

import com.example.demo.Model.ResultDTO;
import com.example.demo.Service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.Model.Rectangle;

@RestController
public class RectangleController {

    @Autowired
    private RectangleService rectangleService;


    @GetMapping(value="/api/get-rectangle/{uuid}",produces = "application/json")
    public Rectangle getRectangle(@PathVariable String uuid){
        return rectangleService.getRectangleByMap(uuid);

    }

    @GetMapping(value="/api/get-rectangleH2/{id}",produces = "application/json")
    public Rectangle getRectangle(@PathVariable long id){
        return rectangleService.getRectangleById(id);
    }

    @GetMapping(value="/api/get-rectangle-height/{height}",produces = "application/json")
    public List<Rectangle> getRectangleByHeight(@PathVariable Float height){
        return rectangleService.getRectangleByHeight(height);
    }

    @PostMapping(value="/api/create-rectangle" , consumes = "application/json")
    public ResultDTO addRectangle(@RequestBody Rectangle rectangle,ResultDTO resultDTO){
        rectangleService.createRectangle(rectangle);
        return rectangleService.addRectangle(rectangle,resultDTO);
    }

    @GetMapping(value="/api/get-all-rectangles",produces = "application/json")
    public List<Rectangle> getAllRectangles(){
        return rectangleService.getRectangles();
    }

    @GetMapping(value="/api/get-area-rectangle/{uuid}",produces = "application/json")
    public Float getArea(@PathVariable String uuid){
        return rectangleService.getArea(uuid);
    }

    @GetMapping(value="/api/get-perimeter-rectangle/{uuid}",produces = "application/json")
    public Float getPerimeter(@PathVariable String uuid){
        return rectangleService.getPerimeter(uuid);
    }



}