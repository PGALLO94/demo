package com.example.demo.Service;

import com.example.demo.Model.Rectangle;
import com.example.demo.Model.ResultDTO;
import com.example.demo.Repository.RectangleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RectangleServiceTest {


    private RectangleService rectangleService;

    @Mock
    private RectangleRepository rectangleRepository;

    @Test
    public void testCreateRectangle(){
        rectangleService = new RectangleService(rectangleRepository);
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1L);
        rectangle.setHeight(10);
        rectangle.setWidth(20);

        lenient().when(rectangleRepository.save(rectangle)).thenReturn(rectangle);
        assertThat(rectangleService.createRectangle(rectangle)).isEqualTo(rectangle);

    }

    @Test
    public void testAddRectangle(){
        rectangleService = new RectangleService(rectangleRepository);
        Rectangle rectangle = new Rectangle();
        ResultDTO resultDTO = new ResultDTO();
        assertThat(rectangleService.addRectangle(rectangle,resultDTO)).isEqualTo(resultDTO);

    }

    @Test
    public void testGetRectangleById(){
        rectangleService = new RectangleService(rectangleRepository);
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1L);
        rectangle.setHeight(10);
        rectangle.setWidth(20);

        lenient().when(rectangleRepository.findById(1L)).thenReturn(Optional.of(rectangle));
        assertThat(rectangleService.getRectangleById(1L)).isEqualTo(rectangle);

    }

    @Test
    public void testGetArea() {
        rectangleService = new RectangleService(rectangleRepository);
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1L);
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        UUID uuid = UUID.randomUUID();


        rectangleService.getMap().put(uuid.toString(),rectangle);
        assertThat(rectangleService.getArea(uuid.toString())).isEqualTo(200F);

    }

    @Test
    public void testGetPerimeter() {
        rectangleService = new RectangleService(rectangleRepository);
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1L);
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        UUID uuid = UUID.randomUUID();

        rectangleService.getMap().put(uuid.toString(),rectangle);
        assertThat(rectangleService.getPerimeter(uuid.toString())).isEqualTo(30F);

    }


}