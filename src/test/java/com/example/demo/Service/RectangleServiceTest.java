package com.example.demo.Service;

import com.example.demo.Model.Rectangle;
import com.example.demo.Repository.RectangleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
    public void testGetRectangleById(){
        rectangleService = new RectangleService(rectangleRepository);
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1L);
        rectangle.setHeight(10);
        rectangle.setWidth(20);

        when(rectangleRepository.findById(1L)).thenReturn(Optional.of(rectangle));

        assertThat(rectangleService.getRectangleById(1L)).isEqualTo(rectangle);

    }


}