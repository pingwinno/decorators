package com.study;

import java.io.IOException;
//TODO: Надо бы отрефакторить
public class BufferedInputStream implements InputStream {

    private final byte[] buffer = new byte[64];
    private final InputStream inputStream;
    private int currentIndex;
    private int filledElements;
    private boolean isClosed;
    private boolean isBufferNotInitialized = true;

    public BufferedInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        if (isClosed) {
            throw new IOException("Stream is closed");
        }
        initializeBuffer();
        if (filledElements == -1 || (currentIndex == filledElements && refillBuffer())) {
            return -1;
        }
        return buffer[currentIndex++];
    }


    @Override
    public int read(byte[] array) throws IOException {
        if (isClosed) {
            throw new IOException("Stream is closed");
        }
        initializeBuffer();
        for (int i = 0; i < array.length; i++, currentIndex++) {
            if (filledElements == -1 || (currentIndex == filledElements && refillBuffer())) {
                return i != 0 ? i : -1;
            }
            array[i] = buffer[currentIndex];
        }
        return array.length;
    }

    @Override
    public void close() {
        isClosed = true;
    }

    //Я тоже не в восторге от обновления буффера в методе возвращающего статус, но так удобнее
    private boolean refillBuffer() throws IOException {
        if ((filledElements = inputStream.read(buffer)) == -1) {
            return true;
        }
        currentIndex = 0;
        return false;
    }

    //тоже такое себе решение, но был вариант с исключением в конструкторе а он вроде хуже
    private void initializeBuffer() throws IOException {
        if (isBufferNotInitialized) {
            filledElements = inputStream.read(buffer);
            isBufferNotInitialized = false;
        }
    }

}
