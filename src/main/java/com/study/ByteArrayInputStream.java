package com.study;

public class ByteArrayInputStream implements InputStream {

    private int currentIndex;
    private final byte[] array;

    public ByteArrayInputStream(byte[] array) {
        this.array = array;
    }

    @Override
    public int read() {
        if (currentIndex > array.length - 1) {
            return -1;
        }
        return array[currentIndex++];
    }

    @Override
    public int read(byte[] array) {
        System.arraycopy(this.array, 0, array, 0, array.length);
        return array.length;
    }

    @Override
    public void close() {
    }
}
