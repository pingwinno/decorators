package com.study;

public class ByteArrayInputStream implements InputStream {

    private final byte[] array;
    private int currentIndex;

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
    public int read(byte[] buffer) {
        if (currentIndex > array.length - 1) {
            return -1;
        }
        //System.arrayCopy не копирует меньшие массивы в большие
        for (int i = currentIndex, k = 0; i < array.length && k < buffer.length; i++, k++) {
            buffer[k] = array[i];
        }
        //Да, индекс уходит за длинну внутреннего массива. Именно поэтому вверху такая проверка и да это не очевидный код я знаю.
        var copiedItemsNumber = array.length - currentIndex;
        currentIndex += buffer.length;
        return Math.min(copiedItemsNumber, buffer.length);
    }

    @Override
    public void close() {
    }
}
