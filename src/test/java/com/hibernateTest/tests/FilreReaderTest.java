package com.hibernateTest.tests;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by suay on 8/22/16.
 */
public class FilreReaderTest {

//note:
//    java.io.File will most likely never be deprecated / unsupported.
// That said, java.nio.file.Path is part of the more modern java.nio.file lib,
// and does everything java.io.File can, but generally in a better way, and then some.

    @Test
    public void testFileReader(){
        String pathStr = "src/test/resources/test.txt";
        try(Reader fileReader = new FileReader(pathStr)){
            int c;
            while( (c = fileReader.read()) != -1){
                char caracter = (char) c;
                System.out.print(caracter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // Sometimes you need to read ahead a few characters to see what is coming, before you can determine how to interpret the current character
    //Basically the good thing is that you have a unread()
    @Test
    public void testPushBackReader(){
        String pathStr = "src/test/resources/test.txt";
        try(PushbackReader pushbackReader = new PushbackReader(new FileReader(pathStr))){
            int c;
            int count = 0 ;
            while( (c = pushbackReader.read()) != -1){
                char caracter = (char) c;
                System.out.print(caracter);
                // unread some characters, and read again
                if (count % 4 == 0)
                    pushbackReader.unread(c);
                count++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //BufferReader has a better performance because reduce the calls to the OS
    @Test
    public void testBufferReader(){
        String pathStr = "src/test/resources/test.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathStr))){
            String line;
            while( (line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Can create a bufferReader using the Files.newBufferedReader
    @Test
    public void testFiles(){
        Path path = Paths.get("src/test/resources/test.txt");
        try(BufferedReader bf = Files.newBufferedReader(path)){
            String line;
            while( (line = bf.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
