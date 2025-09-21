package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Predator predator;

    @Spy
    private Feline feline = new Feline();

    @Test
    void shouldHaveManeIfSexIsMale() throws Exception {
        Lion lion = new Lion(predator, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void shouldNotHaveManeIfSexIsFemale() throws Exception {
        Lion lion = new Lion(predator, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void shouldThrowExceptionForInvalidSex() throws Exception {
        assertThrows(Exception.class, () -> new Lion(predator, "Неизвестно"));
    }

    @Test
    void shouldDelegateGetFoodToPredator() throws Exception {
        when(predator.eatMeat()).thenReturn(List.of("Олень", "Заяц"));

        Lion lion = new Lion(predator, "Самец");
        List<String> result = lion.getFood();

        assertEquals(List.of("Олень", "Заяц"), result);
        verify(predator).eatMeat();
    }

    @Test
    void shouldReturnDefaultKittensWhenPredatorIsNotFeline() throws Exception {
        Lion lion = new Lion(predator, "Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test
    void shouldReturnFelineKittensWhenPredatorIsFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(feline, "Самец");
        assertEquals(3, lion.getKittens());
    }

    @Test
    void shouldThrowExceptionWhenPredatorThrowsEatMeat() throws Exception {
        when(predator.eatMeat()).thenThrow(new Exception("Ошибка еды"));

        Lion lion = new Lion(predator, "Самец");

        assertThrows(Exception.class, () -> lion.getFood());
    }
}