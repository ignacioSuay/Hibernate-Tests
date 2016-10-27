package com.hibernateTest.tests;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by suay on 10/27/16.
 */
public class MockitoTests {


    @Mock
    Iterator<String> iterator;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockIterator(){
        Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
        assertThat(iterator.next()).isEqualTo("hello");
        assertThat(iterator.next()).isEqualTo("world");

    }


}
