package ru.netology.statistic;

public class Radio {
    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation <= 9) {
            this.currentStation = currentStation;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= 0 && currentVolume <= 100) {
            this.currentVolume = currentVolume;
        }
    }

    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation += 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation -= 1;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume += 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume -= 1;
        }
    }
}
