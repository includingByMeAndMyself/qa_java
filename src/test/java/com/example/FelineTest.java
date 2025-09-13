package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @Test
    void shouldReturnCorrectMeatFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    void shouldReturnCatFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void shouldReturnOneKittenByDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    void shouldReturnSpecifiedKittensCount() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    void shouldThrowExceptionForNegativeKittens() {
        Feline feline = new Feline();
        assertThrows(IllegalArgumentException.class, () -> feline.getKittens(-1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Животные", "Птицы", "Рыба"})
    void shouldContainAllMeatTypes(String foodType) throws Exception {
        Feline feline = new Feline();
        assertTrue(feline.eatMeat().contains(foodType));
    }
}