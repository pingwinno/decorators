package com.study;

public interface OutputStream {
    void write(int data);

    void write(byte[] array);

    void close();

    void flush();
}
