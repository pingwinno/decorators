package study;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
    public void should_return_when_callReadWithEmptyArray() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FIVE_ELEMENT_ARRAY);
        assertEquals(65, byteArrayInputStream.read());
        assertEquals(66, byteArrayInputStream.read());
        assertEquals(67, byteArrayInputStream.read());
        assertEquals(68, byteArrayInputStream.read());
        assertEquals(69, byteArrayInputStream.read());
        assertEquals(-1, byteArrayInputStream.read());
    }

}
