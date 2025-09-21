package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    void shouldReturnHerbivoreFood() throws Exception {
        List<String> food = animal.getFood("Травоядное");
        assertEquals(2, food.size());
        assertTrue(food.contains("Трава"));
        assertTrue(food.contains("Различные растения"));
    }

    @Test
    void shouldReturnCarnivoreFood() throws Exception {
        List<String> food = animal.getFood("Хищник");
        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    void shouldThrowExceptionForUnknownKind() throws Exception {
        assertThrows(Exception.class, () -> animal.getFood("Неизвестно"));
    }

    @Test
    void shouldReturnCorrectFamily() {
        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily()
        );
    }
}