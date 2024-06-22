package ru.netology.statistic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetInvalidStationAboveMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(10);
        assertNotEquals(10, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentStation()); // начальная станция по умолчанию 0
    }

    @Test
    public void shouldNotSetInvalidStationBelowMin() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertNotEquals(-1, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentStation()); // начальная станция по умолчанию 0
    }

    @Test
    public void shouldSetStationToMinBoundary() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationToMaxBoundary() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapToZeroWhenNextOnMaxStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapToMaxWhenPrevOnZeroStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetValidVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetInvalidVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        assertNotEquals(101, radio.getCurrentVolume());
        assertEquals(0, radio.getCurrentVolume()); // начальный уровень громкости по умолчанию 0
    }

    @Test
    public void shouldNotSetInvalidVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        assertNotEquals(-1, radio.getCurrentVolume());
        assertEquals(0, radio.getCurrentVolume()); // начальный уровень громкости по умолчанию 0
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}