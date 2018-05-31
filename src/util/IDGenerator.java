package util;

import java.net.InetAddress;

public class IDGenerator {
    private static final int IP;
    static {
        int ipadd;
        try {
            ipadd = toInt(InetAddress.getLocalHost().getAddress());
        } catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }
    private static short counter = (short) 0;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

    private static int toInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }

    /**
     * Unique in a local network
     */
    private int getIP() {
        return IP;
    }

    /**
     * Unique down to millisecond
     */
    private int getLoTime() {
        return (int) System.currentTimeMillis();
    }

    /**
     * Unique across JVMs on this machine (unless they load this class in the
     * same quater second - very unlikely)
     */
    private int getJVM() {
        return JVM;
    }

    private String format(int intval) {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("000");
        buf.replace(0, 3, formatted.substring(5,8));
        return buf.toString();
    }

    private String format(short shortval) {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("000");
        buf.replace(3-formatted.length(), 3, formatted);
        return buf.toString();
    }

    public String generate() {
        return new StringBuilder(12).append(format(getIP()))
                .append(format(getJVM()))
                .append(format(getLoTime()))
                .append(format(getCount())).toString();
    }
    /**
     * Unique in a millisecond for this JVM instance (unless there are >
     * Short.MAX_VALUE instances created in a millisecond)
     */
    private short getCount() {
        synchronized (IDGenerator.class) {
            if (counter < 0)
                counter = 0;
            return counter++;
        }
    }

}
