package com.study;

public interface InputStream {
    int read();

    int read(byte[] array);

    void close();
}
