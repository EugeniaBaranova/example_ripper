package com.example.writer;


import com.example.annotation.PostProxy;
import com.example.annotation.Profiling;
import com.example.annotation.TextWriters;

@Profiling
@TextWriters(name = "good bye")
public class GoodByeWriter implements TextWriter {

    @Override
    @PostProxy
    public void write() {
        System.out.println("Goodbye!");
    }
}
