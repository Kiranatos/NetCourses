package net.kiranatos.stepik.java_web_mail_ru.L6_4_NIO;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    
    private static final String PATH = "./src/stepik/java_web_mail_ru/L6_4_NIO/data/data.txt";
    
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile(PATH, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(64);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.print("\n");
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
