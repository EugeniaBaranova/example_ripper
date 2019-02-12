package com.example.writer;


import com.example.annotation.InjectRandomInt;
import com.example.annotation.Profiling;
import com.example.annotation.TextWriters;

@Profiling
@TextWriters(name = "good day")
public class GoodDayWriter implements TextWriter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    @Override
    public void write() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("Good day!");
        }
    }
}
