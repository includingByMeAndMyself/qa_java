package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Predator predator;

    @Test
    void shouldReturnMeowSound() {
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void shouldDelegateGetFoodToPredator() throws Exception {
        when(predator.eatMeat()).thenReturn(List.of("Мышь", "Рыба"));

        Cat cat = new Cat(predator);
        List<String> result = cat.getFood();

        assertEquals(List.of("Мышь", "Рыба"), result);
        verify(predator).eatMeat(); // Проверяем вызов
    }

    @Test
    void shouldThrowExceptionWhenPredatorThrowsException() throws Exception {
        when(predator.eatMeat()).thenThrow(new Exception("Ошибка питания"));

        Cat cat = new Cat(predator);

        assertThrows(Exception.class, () -> cat.getFood());
    }
}