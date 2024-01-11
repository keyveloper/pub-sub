package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentTest {
    @Test
    void testMultiThread() throws InterruptedException {
        ConcurrentList concurrent = new ConcurrentList();
        //Given
        Thread t1 = new Thread(concurrent);
        Thread t2 = new Thread(concurrent);

        // when
        t1.start();
        t2.start();

        t1.join();;
        t2.join();

        // then
    }

}