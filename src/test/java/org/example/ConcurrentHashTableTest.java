package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentHashTableTest {

    @Test
    public void concurrentTest() throws InterruptedException {
        // Givenc
        ConcurrentHashTable concurrentHashTable = new ConcurrentHashTable("start", 1);

        Thread t1 = new Thread(concurrentHashTable);
        Thread t2 = new Thread(concurrentHashTable);
        Thread t3 = new Thread(concurrentHashTable);
        Thread t4 = new Thread(concurrentHashTable);
        Thread t5 = new Thread(concurrentHashTable);

        // When
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

       // Then

    }

}