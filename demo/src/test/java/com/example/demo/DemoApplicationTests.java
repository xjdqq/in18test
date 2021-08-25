package com.example.demo;

import com.example.demo.util.humen;
import com.example.demo.util.st;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void contextLoads() {
        Buffer buffer = IntBuffer.allocate(5);
        IntBuffer intBuffer = (IntBuffer) buffer;
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        buffer.flip();
        int[] a = new int[]{1,2};
        System.out.println(Arrays.stream(((IntBuffer) buffer).array()).boxed().map(i -> i.toString()) //必须将普通数组 boxed才能 在 map 里面 toString
                    .collect(Collectors.joining("")));
    }
    @Test
    void contextLoads1() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\sino club\\abc.txt");
        String a = "test测试";
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put(a.getBytes());
        buffer.position(0);
//        buffer.flip();
        channel.write(buffer);

        fileOutputStream.close();
    }

    @Test
    void contextLoads2() throws Exception {
        File file = new File("D:\\sino club\\abc.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        buffer.flip();
        System.out.println(new String(buffer.array()));
        fileInputStream.close();
    }

    @Test
    void contextLoads21() throws Exception {
        Map<String, BiConsumer<String,String>> map = new HashMap<>();
        map.put("12", (d, v) -> System.out.println(d+" "+v));
        map.get("12").accept("王文杰","sb");
    }


}
