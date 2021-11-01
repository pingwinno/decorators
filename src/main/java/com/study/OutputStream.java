package com.study;

import java.io.IOException;

public interface OutputStream extends AutoCloseable {
    void write(int data) throws IOException;

    void write(byte[] array) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
