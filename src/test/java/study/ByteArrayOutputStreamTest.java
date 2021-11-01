package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {

    private static final byte[] ONE_ELEMENT_ARRAY = new byte[]{65};
    private static final byte[] FIVE_BYTES_ELEMENT_ARRAY = new byte[]{65, 66, 67, 68, 69};


    @Test
    void should_returnArrayWithOneByte_when_writeArrayWithOneByteStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(ONE_ELEMENT_ARRAY);
        Assertions.assertArrayEquals(ONE_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithFiveBytes_when_writeArrayWithFiveBytesStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(FIVE_BYTES_ELEMENT_ARRAY);
        Assertions.assertArrayEquals(FIVE_BYTES_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }

    @Test
    void should_returnArrayWithFiveBytes_when_writeEachByteWithFiveBytesStream() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(65);
        byteArrayOutputStream.write(66);
        byteArrayOutputStream.write(67);
        byteArrayOutputStream.write(68);
        byteArrayOutputStream.write(69);
        Assertions.assertArrayEquals(FIVE_BYTES_ELEMENT_ARRAY, byteArrayOutputStream.toByteArray());
    }
}
