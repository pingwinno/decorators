package com.study;

public interface InputStream extends AutoCloseable {
    int read();

    int read(byte[] array);

    void close();
}
