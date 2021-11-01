package com.study;

public class ByteArrayInputStream {

    private int currentIndex;
    private byte[] array;

    public ByteArrayInputStream(byte[] array) {
        this.array = array;
    }

    public int read() {
        if (currentIndex > array.length - 1) {
            return -1;
        }
        return array[currentIndex++];
    }

    public int read(byte[] array) {
        System.arraycopy(this.array, 0, array, 0, array.length);
        return array.length;
    }

    public void close() {
    }
}
