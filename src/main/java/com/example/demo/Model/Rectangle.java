package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Rectangle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float width;
    private float height;

    public Rectangle() {

    }

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
