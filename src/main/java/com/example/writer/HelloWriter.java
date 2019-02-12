package com.example.writer;


import com.example.annotation.Profiling;
import com.example.annotation.TextWriters;

@Profiling
@TextWriters(name = "hello")
public class HelloWriter implements TextWriter {

    public void write() {
        System.out.println("Hello!");
    }
}
