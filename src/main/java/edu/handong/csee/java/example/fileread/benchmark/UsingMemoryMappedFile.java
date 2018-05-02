package edu.handong.csee.java.example.fileread.benchmark;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sherxon on 4/23/17. https://github.com/sherxon/AlgoDS/tree/master/src/oi
 */
public class UsingMemoryMappedFile {
    public static void main(String[] args) throws IOException {

        //-------------- Test reading 1 MB file. --------------------
        StopWatch.start();

        RandomAccessFile memoryFile = new RandomAccessFile(DumpDataWriter.input1MB, "rw");
        MappedByteBuffer mappedByteBuffer = memoryFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, DumpDataWriter.size1MB);
        for (int i = 0; i < DumpDataWriter.size1MB; i++) {
            mappedByteBuffer.get(i);
        }

        long duration = StopWatch.stop();
        System.out.println(duration + " milsec");
        
        memoryFile.close();

        //-------------- Test reading 10 MB file. --------------------

        StopWatch.start();

        RandomAccessFile memoryFile2 = new RandomAccessFile(DumpDataWriter.input10MB, "rw");
        MappedByteBuffer mappedByteBuffer1 = memoryFile2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, DumpDataWriter.size10MB);
        for (int i = 0; i < DumpDataWriter.size10MB; i++) {
            mappedByteBuffer1.get(i);
        }

        long duration2 = StopWatch.stop();
        System.out.println(duration2 + " milsec");
        
        memoryFile2.close();

        /*
        //-------------- Test reading 100 MB file. --------------------

        StopWatch.start();

        RandomAccessFile memoryFile3 = new RandomAccessFile(DumpDataWriter.input100MB, "rw");
        MappedByteBuffer mappedByteBuffer3 = memoryFile3.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, DumpDataWriter.size100MB);

        for (int i = 0; i < DumpDataWriter.size100MB; i++) {
            mappedByteBuffer3.get(i);
        }
        long duration3 = StopWatch.stop();
        System.out.println(duration3 + " milsec");

        memoryFile3.close();
        
        //-------------- Test reading 1000 MB file. --------------------

        StopWatch.start();

        RandomAccessFile memoryFile4 = new RandomAccessFile(DumpDataWriter.input1000MB, "rw");
        MappedByteBuffer mappedByteBuffer4 = memoryFile4.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, DumpDataWriter.size1000MB);

        for (int i = 0; i < DumpDataWriter.size1000MB; i++) {
            mappedByteBuffer4.get(i);
        }
        long duration4 = StopWatch.stop();
        System.out.println(duration4 + " milsec");
        
        memoryFile4.close();
        */
    }
}
