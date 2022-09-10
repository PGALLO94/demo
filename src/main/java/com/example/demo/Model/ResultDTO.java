package com.example.demo.Model;

import java.util.UUID;

public class ResultDTO {

    private UUID uuid;
    private Rectangle rectangle;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
