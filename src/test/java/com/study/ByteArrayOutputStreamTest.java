package com.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ByteArrayOutputStreamTest {

    private static final byte[] ONE_ELEMENT_ARRAY = new byte[]{65};
    private static final byte[] FIVE_BYTES_ELEMENT_ARRAY = new byte[]{65, 66, 67, 68, 69};


    @Test
    void should_returnArrayWithOneByte_when_writeArrayWithOneByteStream() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(ONE_ELEMENT_ARRAY);
        assertArrayEquals(ONE_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithFiveBytes_when_writeArrayWithFiveBytesStream() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(FIVE_BYTES_ELEMENT_ARRAY);
        assertArrayEquals(FIVE_BYTES_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithFiveBytes_when_writeEachByteWithFiveBytesStream() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(65);
        byteArrayOutputStream.write(66);
        byteArrayOutputStream.write(67);
        byteArrayOutputStream.write(68);
        byteArrayOutputStream.write(69);
        assertArrayEquals(FIVE_BYTES_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }


    @Test
    public void should_expandInternalArray_when_callReadWithArrayLargerThenBuffer() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        var data = new byte[100];
        Arrays.fill(data, (byte) 100);
        byteArrayOutputStream.write(data);
        assertArrayEquals(data, byteArrayOutputStream.toByteArray());
    }
}
