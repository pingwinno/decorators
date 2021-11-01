package com.study;

import java.io.IOException;
import java.util.Arrays;

public class BufferedOutputStream implements OutputStream {
    private static final int DEFAULT_CAPACITY = 64;
    private byte[] buffer = new byte[DEFAULT_CAPACITY];
    private int currentIndex;
    private final OutputStream outputStream;
    private boolean isClosed;

    public BufferedOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int data) throws IOException {
        if (isClosed){
            throw new IOException("Stream is closed");
        }
        if (currentIndex > buffer.length) {
            flush();
        }
        buffer[currentIndex] = (byte) data;
        currentIndex++;
    }

    @Override
    public void write(byte[] array) throws IOException {
        if (isClosed){
            throw new IOException("Stream is closed");
        }
        if (array.length > buffer.length - currentIndex) {
            flush();
            outputStream.write(array);
        } else {
            System.arraycopy(array, 0, buffer, currentIndex, array.length);
            currentIndex += array.length;
        }
    }

    @Override
    public void close() throws IOException {
        flush();
        isClosed = true;
    }

    @Override
    public void flush() throws IOException {
        outputStream.write(Arrays.copyOf(buffer, currentIndex));
        buffer = new byte[DEFAULT_CAPACITY];
        currentIndex = 0;
    }
}
