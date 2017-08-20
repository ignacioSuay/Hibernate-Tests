package com.hibernateTest.tests;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by natxo on 07/12/16.
 */
public class CopyFile {

    public final static String TMP_INPUT_FILE_NAME = "/tmp/input_test.txt";
    public final static String TMP_OUTPUT_FILE_NAME = "/tmp/output_test.txt";


    @Test
    public void testFileCopy() throws Exception{

        try(OutputStream outputStream = new FileOutputStream(TMP_OUTPUT_FILE_NAME)){
            Path path = Paths.get(TMP_INPUT_FILE_NAME);
            Files.copy(path, outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
