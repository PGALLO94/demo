package com.example.demo.Service;


import com.example.demo.Model.Rectangle;
import com.example.demo.Model.ResultDTO;
import com.example.demo.Repository.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RectangleService {

    private Map<String, Rectangle> map  = new HashMap<>();

    @Autowired
    private RectangleRepository rectangleRepository;

    public Rectangle getRectangleById(long id){
        Rectangle rectangle = rectangleRepository.findById(id).orElse(null);
        if (rectangle != null) {
            return rectangle;
        }
        return new Rectangle(-1.0f,-1.0f);
    }
    public Rectangle getRectangleByMap(String uuid) {
        Rectangle rectangle = map.get(uuid);
        if (rectangle == null) {
            return new Rectangle(-1.0f, -1.0f);
        }
        return rectangle;
    }

    public Rectangle createRectangle(Rectangle rectangle) {
        return rectangleRepository.save(rectangle);
    }

    public ResultDTO addRectangle(Rectangle rectangle){
        UUID uuid = UUID.randomUUID();
        ResultDTO resultDTO = new ResultDTO();
        map.put(uuid.toString(),rectangle);
        resultDTO.setRectangle(rectangle);
        resultDTO.setUuid(uuid);
        return resultDTO;
    }
    public List<Rectangle> getRectangles(){
        return new ArrayList<>(map.values());
    }
    public Float getArea(String uuid){
        Rectangle rectangle = map.get(uuid);
        return rectangle.getHeight() * rectangle.getWidth();
    }

    public Float getPerimeter(String uuid){
        Rectangle rectangle = map.get(uuid);
        return rectangle.getHeight() + rectangle.getWidth();
    }

    public List<Rectangle> getRectangleByHeight(Float height){
        ArrayList<Rectangle> array = new ArrayList<>();
        for (Rectangle rectangle: rectangleRepository.findAll()){
            if (rectangle.getHeight() == height) array.add(rectangle);
        }
        return array;
    }

}
