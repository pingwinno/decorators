package com.study;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BufferedInputStreamTest {
    private static final byte[] EMPTY_ARRAY = new byte[]{};
    private static final byte[] ONE_ELEMENT_ARRAY = new byte[]{65};
    private static final byte[] FIVE_ELEMENT_ARRAY = new byte[]{65, 66, 67, 68, 69};


    @Test
    public void should_returnByteFromArray_when_callReadWithOneElementArray() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ONE_ELEMENT_ARRAY);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        assertEquals(65, bufferedInputStream.read());
        assertEquals(-1, bufferedInputStream.read());
    }

    @Test
    public void should_returnEndOfStream_when_callReadWithEmptyArray() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(EMPTY_ARRAY);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        assertEquals(-1, bufferedInputStream.read());
    }

    @Test
    public void should_returnEachElementFromArray_when_callReadWithFiveElementsArray() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        assertEquals(65, bufferedInputStream.read());
        assertEquals(66, bufferedInputStream.read());
        assertEquals(67, bufferedInputStream.read());
        assertEquals(68, bufferedInputStream.read());
        assertEquals(69, bufferedInputStream.read());
        assertEquals(-1, bufferedInputStream.read());
    }

    @Test
    public void should_returnNumberOfReadElementsAndFilledArray_when_callReadAndPassEmptyArray() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        var actualArray = new byte[5];
        var actualCount = bufferedInputStream.read(actualArray);
        assertArrayEquals(FIVE_ELEMENT_ARRAY, actualArray);
        assertEquals(FIVE_ELEMENT_ARRAY.length, actualCount);
        assertEquals(-1, bufferedInputStream.read(actualArray));
    }

    @Test
    public void should_returnNumberOfReadElementsAndFilledArray_when_callReadAndPassEmptyArrayBiggerThanStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        var actualArray = new byte[100];
        var actualCount = bufferedInputStream.read(actualArray);
        assertEquals(65, actualArray[0]);
        assertEquals(66, actualArray[1]);
        assertEquals(67, actualArray[2]);
        assertEquals(68, actualArray[3]);
        assertEquals(69, actualArray[4]);
        assertEquals(FIVE_ELEMENT_ARRAY.length, actualCount);
        assertEquals(-1, bufferedInputStream.read(actualArray));
    }

    @Test
    public void should_throwIOException_when_callReadOnClosedStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ONE_ELEMENT_ARRAY);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        bufferedInputStream.close();
        assertThrows(IOException.class, bufferedInputStream::read);
    }

}
