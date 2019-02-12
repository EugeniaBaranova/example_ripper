package com.example;

import com.example.writer.TextWriter;

import java.util.HashMap;
import java.util.Map;

public class TextWriterFactory {
    private Map<String, Object> textWriters = new HashMap<String, Object>();

    public TextWriter getTextWriter(String textWriterName) {
        if (textWriterName != null) {
            return (TextWriter) textWriters.get(textWriterName);
        }
        return null;
    }
}
