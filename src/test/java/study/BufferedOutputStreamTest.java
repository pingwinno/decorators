package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

    private static final byte[] ONE_ELEMENT_ARRAY = new byte[]{65};
    private static final byte[] FIVE_BYTES_ELEMENT_ARRAY = new byte[]{65, 66, 67, 68, 69};


    @Test
    void should_returnArrayWithOneByte_when_writeArrayWithOneByteStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream)) {
            bufferedOutputStream.write(ONE_ELEMENT_ARRAY);
        }
        Assertions.assertArrayEquals(ONE_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithFiveBytes_when_writeArrayWithFiveBytesStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream)) {
            bufferedOutputStream.write(FIVE_BYTES_ELEMENT_ARRAY);
        }
        Assertions.assertArrayEquals(FIVE_BYTES_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithFiveBytes_when_writeEachByteWithFiveBytesStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream)) {
            bufferedOutputStream.write(65);
            bufferedOutputStream.write(66);
            bufferedOutputStream.write(67);
            bufferedOutputStream.write(68);
            bufferedOutputStream.write(69);
        }
        Assertions.assertArrayEquals(FIVE_BYTES_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithOneByte_when_writeArrayWithOneByteStreamAndCloseStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        bufferedOutputStream.write(ONE_ELEMENT_ARRAY);
        bufferedOutputStream.close();
        Assertions.assertArrayEquals(ONE_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithOneByte_when_writeArrayWithOneByteStreamAndFlushStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        bufferedOutputStream.write(ONE_ELEMENT_ARRAY);
        bufferedOutputStream.flush();
        Assertions.assertArrayEquals(ONE_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }
}
