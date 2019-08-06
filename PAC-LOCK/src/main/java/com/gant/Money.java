package com.gant;

/**
 * @author 甘明波
 * @date 2019-08-05
 */
public class Money {

    private String name;
    private Integer number;

    public Money(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Money{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
