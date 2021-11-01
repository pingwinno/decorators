package com.study;

import java.util.Arrays;

public class ByteArrayOutputStream implements OutputStream {
    private static final int DEFAULT_CAPACITY = 64;
    private byte[] bytes;
    private int currentIndex;

    public ByteArrayOutputStream() {
        this(DEFAULT_CAPACITY);
    }

    public ByteArrayOutputStream(int size) {
        this.bytes = new byte[size];
    }

    @Override
    public void write(int data) {
        if (currentIndex > bytes.length) {
            bytes = Arrays.copyOf(bytes, bytes.length * 2);
        }
        bytes[currentIndex] = (byte) data;
        currentIndex++;
    }

    @Override
    public void write(byte[] array) {
        if (array.length > bytes.length) {
            bytes = Arrays.copyOf(bytes, bytes.length + array.length);
        }
        System.arraycopy(array, 0, bytes, currentIndex, array.length);
        currentIndex += array.length;
    }

    @Override
    public void close() {

    }

    @Override
    public void flush() {

    }

    public byte[] toByteArray() {
        return Arrays.copyOf(bytes, currentIndex);
    }

}
