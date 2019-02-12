package com.example;


import com.example.writer.TextWriter;


public class BaseApplication {

    private TextWriter textWriter;

    public BaseApplication(TextWriter textWriter) {
        this.textWriter = textWriter;
    }

    public void start(){
        textWriter.write();
    }
}
