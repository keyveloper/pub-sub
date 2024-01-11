package org.example;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentList implements Runnable{
    // ArrayList<Integer> testList;
    CopyOnWriteArrayList<Integer> testList;

    ConcurrentList(){
        testList = new CopyOnWriteArrayList<>();
    }
    @Override
    public void run(){
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            int randomInt = random.nextInt(100);
            testList.add(randomInt);
            System.out.println("+" + randomInt);
            System.out.println("added!! "+ testList);

            int removeInt = testList.remove(0);
            System.out.println("-" + removeInt);
            System.out.println("deleted!!" + testList);
        }
    }

    public int getListLength(){
        return testList.size();
    }

}
