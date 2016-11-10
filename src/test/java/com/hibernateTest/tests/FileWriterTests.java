package com.hibernateTest.tests;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by suay on 8/23/16.
 */
public class FileWriterTests {

    final static String TEST_FILE = "src/test/resources/test.txt" ;

    //new FileWriter(path, boolean append)
    // by default append is set to false and the file will be deleted
    // if you set to true it will append.
    @Test
    public void testWrite(){

        //open the file in append mode
        try(Writer writer = new FileWriter(TEST_FILE, true)){
            writer.write("\nappend this line at the end");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    public void testWriteUsingFiles(){
        Path path = Paths.get(TEST_FILE);
        try(Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
            writer.write("\nappend this line at the end");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    public void testFileSetAttribute() throws IOException {
        Path path = Paths.get(TEST_FILE);
        Files.setAttribute(path, "user:type", ByteBuffer.wrap(("test").getBytes("UTF-8")));

        byte[] attribute = (byte[]) Files.getAttribute(path, "user:type");
        String attributeStr = new String(attribute);
        assertThat("test").isEqualTo(attributeStr);
    }


}
