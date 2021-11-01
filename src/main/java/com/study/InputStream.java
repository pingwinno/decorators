package com.study;

import java.io.IOException;

public interface InputStream extends AutoCloseable {
    int read() throws IOException;

    int read(byte[] array) throws IOException;

    void close();
}
