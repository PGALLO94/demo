package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Rectangle;

import java.util.UUID;

@Repository
public interface RectangleRepository extends CrudRepository<Rectangle, Long> {

}
