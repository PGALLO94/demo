package com.example.demo.Controller;

import com.example.demo.Model.ResultDTO;
import com.example.demo.Repository.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.Model.Rectangle;

@RestController
public class RectangleController {

    private Map<String, Rectangle> map  = new HashMap<>();

    @Autowired
    private RectangleRepository rectangleRepository;

    @GetMapping(value="/api/get-rectangle/{uuid}",produces = "application/json")
    public Rectangle getRectangle(@PathVariable String uuid){
        Rectangle rectangle = map.get(uuid);
        if (rectangle == null) {
            return new Rectangle(-1.0f,-1.0f);
        }
        return rectangle;
    }

    @GetMapping(value="/api/get-rectangleH2/{id}",produces = "application/json")
    public Rectangle getRectangle(@PathVariable long id){
        Rectangle rectangle = rectangleRepository.findById(id).orElse(null);
        if (rectangle != null) {
                return rectangle;
        }
        return new Rectangle(-1.0f,-1.0f);

    }


    @PostMapping(value="/api/create-rectangle" , consumes = "application/json")
    public ResultDTO addRectangle(@RequestBody Rectangle rectangle){
        UUID uuid = UUID.randomUUID();
        ResultDTO resultDTO = new ResultDTO();
        map.put(uuid.toString(),rectangle);
        resultDTO.setRectangle(rectangle);
        resultDTO.setUuid(uuid);
        rectangleRepository.save(rectangle);
        return resultDTO;
    }

    @GetMapping(value="/api/get-all-rectangles",produces = "application/json")
    public List<Rectangle> getAllRectangles(){
        ArrayList<Rectangle> arr = new ArrayList<Rectangle>(map.values());
        return arr;
    }

    @GetMapping(value="/api/get-area-rectangle/{uuid}",produces = "application/json")
    public Float getArea(@PathVariable String uuid){
        Rectangle rectangle = map.get(uuid);
        return rectangle.getHeight() * rectangle.getWidth();
    }

    @GetMapping(value="/api/get-perimeter-rectangle/{uuid}",produces = "application/json")
    public Float getPerimeter(@PathVariable String uuid){
        Rectangle rectangle = map.get(uuid);
        return rectangle.getHeight() + rectangle.getWidth();
    }



}