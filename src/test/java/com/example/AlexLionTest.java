package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlexLionTest {

    @Mock
    private Predator predator;

    @Test
    void shouldReturnZeroKittensRegardlessOfPredator() throws Exception {
        AlexLion alex = new AlexLion(predator);
        assertEquals(0, alex.getKittens());
    }

    @Test
    void shouldReturnCorrectFriends() throws Exception {
        AlexLion alex = new AlexLion(predator);
        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    void shouldReturnNewYorkZooAsPlaceOfLiving() throws Exception {
        AlexLion alex = new AlexLion(predator);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void shouldHaveManeBecauseSexIsAlwaysMale() throws Exception {
        AlexLion alex = new AlexLion(predator);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void shouldDelegateGetFoodToPredator() throws Exception {
        when(predator.eatMeat()).thenReturn(List.of("Олень", "Заяц"));

        AlexLion alex = new AlexLion(predator);
        List<String> food = alex.getFood();

        assertEquals(List.of("Олень", "Заяц"), food);
        verify(predator).eatMeat();
    }

    @Test
    void shouldThrowExceptionIfPredatorThrowsEatMeat() throws Exception {
        when(predator.eatMeat()).thenThrow(new Exception("Ошибка питания"));

        AlexLion alex = new AlexLion(predator);

        assertThrows(Exception.class, () -> alex.getFood());
    }
}