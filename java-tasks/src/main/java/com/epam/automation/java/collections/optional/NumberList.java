package com.epam.automation.java.collections.optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Pavel Sharuba 2020
 * Не используя вспомогательных объектов, переставить отрицательные
 * элементы данного списка в конец, а положительные — в начало списка.
 */

public class NumberList {
    private List<Double> numbers;

    public NumberList(int count, double border) {
        border = Math.abs(border);
        numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(Math.random() * border - border / 2);
        }
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return "NumberList{" +
                "numbers=" + numbers +
                '}';
    }

    public static void main(String[] args) {
        int numberCount = (int) (Math.random() * 30 + 20);
        int border = (int) (Math.random() * 100 + 100);
        NumberList numberList = new NumberList(numberCount, border);
        System.out.println(numberList);
        numberList.sortNumbers();
        System.out.println(numberList);

    }
}
