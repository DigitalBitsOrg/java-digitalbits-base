package org.stellar.base.xdr;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class XdrDataInputStream extends DataInputStream {

    // The underlying input stream
    private final XdrInputStream mIn;

    // The total bytes read so far.
    private final int mCount;

    /**
     * Creates a XdrDataInputStream that uses the specified
     * underlying InputStream.
     *
     * @param in the specified input stream
     */
    public XdrDataInputStream(InputStream in) {
        super(new XdrInputStream(in));
        mIn = (XdrInputStream) super.in;
        mCount = 0;
    }

    public String readString() throws IOException {
        int l = readInt();
        byte[] ascii = new byte[l];
        readFully(ascii);
        pad();
        return new String(ascii, Charset.forName("US-ASCII"));
    }

    public int[] readIntArray() throws IOException {
        int l = readInt();
        return readIntArray(l);
    }

    public int[] readIntArray(int l) throws IOException {
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = readInt();
        }
        return arr;
    }

    public float[] readFloatArray() throws IOException {
        int l = readInt();
        return readFloatArray(l);
    }

    public float[] readFloatArray(int l) throws IOException {
        float[] arr = new float[l];
        for (int i = 0; i < l; i++) {
            arr[i] = readFloat();
        }
        return arr;
    }

    public double[] readDoubleArray() throws IOException {
        int l = readInt();
        return readDoubleArray(l);
    }

    public double[] readDoubleArray(int l) throws IOException {
        double[] arr = new double[l];
        for (int i = 0; i < l; i++) {
            arr[i] = readDouble();
        }
        return arr;
    }

    /**
     * Skips ahead to bring the stream to 4 byte alignment.
     */
    public void pad() throws IOException {
        mIn.pad();
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    /**
     * Need to provide a custom impl of InputStream as DataInputStream's read methods
     * are final and we need to keep track of the count for padding purposes.
     */
    private static final class XdrInputStream extends InputStream {

        // The underlying input stream
        private final InputStream mIn;

        // The amount of bytes read so far.
        private int mCount;

        public XdrInputStream(InputStream in) {
            mIn = in;
            mCount = 0;
        }

        @Override
        public int read() throws IOException {
            int read = mIn.read();
            if (read >= 0) {
                mCount++;
            }
            return read;
        }

        @Override
        public int read(byte[] b) throws IOException {
            return read(b, 0, b.length);
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            int read = mIn.read(b, off, len);
            mCount += read;
            return read;
        }

        public void pad() throws IOException {
            int pad = 0;
            int mod = mCount % 4;
            if (mod > 0) {
                pad = 4-mod;
            }
            skip(pad);
        }
    }
}
