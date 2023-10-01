package com.example.demo.enums;

public enum Schedule {
    MORNING,
    AFTERNOON,
    EVENING;

    public static boolean contains(String test) {
        for (Schedule schedule : Schedule.values()) {
            if (schedule.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

}

