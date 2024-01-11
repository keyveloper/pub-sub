package org.example;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentHashTable implements Runnable {
    //HashMap<String, Integer> hashMap;
    ConcurrentHashMap<String, Integer> hashMap;

    String key;
    Integer value;

    ConcurrentHashTable(String key, Integer value){
        hashMap = new ConcurrentHashMap<>();
        this.key = key;
        this.value = value;
    }

    @Override
    public void run(){
        if(hashMap.containsKey(this.key)){
            Integer lastValue = hashMap.get(this.key);
            lastValue++;
            hashMap.put(this.key, lastValue);
        }else{
            hashMap.put(this.key, this.value);
        }

        Integer result = hashMap.get(this.key);
        long threadId = Thread.currentThread().getId();
        System.out.println("Thread ID: " + threadId + "\n" + "result: "+ result);
    }


}

