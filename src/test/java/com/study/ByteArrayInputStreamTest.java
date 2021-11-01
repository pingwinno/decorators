package com.study;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


// read, read(byte[])
// write(int), write(byte[])
// close
// flush
public class ByteArrayInputStreamTest {

    private static final byte[] EMPTY_ARRAY = new byte[]{};
    private static final byte[] ONE_ELEMENT_ARRAY = new byte[]{65};
    private static final byte[] FIVE_ELEMENT_ARRAY = new byte[]{65, 66, 67, 68, 69};

    @Test
    public void should_returnByteFromArray_when_callReadWithOneElementArray() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ONE_ELEMENT_ARRAY);
        assertEquals(65, byteArrayInputStream.read());
        assertEquals(-1, byteArrayInputStream.read());
    }

    @Test
    public void should_returnEndOfStream_when_callReadWithEmptyArray() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(EMPTY_ARRAY);
        assertEquals(-1, byteArrayInputStream.read());
    }

    @Test
    public void should_returnEachElementFromArray_when_callReadWithFiveElementsArray() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        assertEquals(65, byteArrayInputStream.read());
        assertEquals(66, byteArrayInputStream.read());
        assertEquals(67, byteArrayInputStream.read());
        assertEquals(68, byteArrayInputStream.read());
        assertEquals(69, byteArrayInputStream.read());
        assertEquals(-1, byteArrayInputStream.read());
    }

    @Test
    public void should_returnNumberOfReadElementsAndFilledArray_when_callReadAndPassEmptyArray() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        var actualArray = new byte[5];
        var actualCount = byteArrayInputStream.read(actualArray);
        assertArrayEquals(FIVE_ELEMENT_ARRAY, actualArray);
        assertEquals(FIVE_ELEMENT_ARRAY.length, actualCount);
        assertEquals(-1, byteArrayInputStream.read(actualArray));
    }

    @Test
    public void should_returnNumberOfReadElementsAndFilledArray_when_callReadAndPassEmptyArrayBiggerThanStream() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        var actualArray = new byte[100];
        var actualCount = byteArrayInputStream.read(actualArray);
        assertEquals(65, actualArray[0]);
        assertEquals(66, actualArray[1]);
        assertEquals(67, actualArray[2]);
        assertEquals(68, actualArray[3]);
        assertEquals(69, actualArray[4]);
        assertEquals(FIVE_ELEMENT_ARRAY.length, actualCount);
        assertEquals(-1, byteArrayInputStream.read(actualArray));
    }
}
