package com.me.www.androidroboletricdemo.mockitotest;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-9-29
 */

public class BaseTest {

    @Test
    public void testList() {
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }


}
