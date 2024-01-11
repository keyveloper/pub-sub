package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Subscriber implements Runnable{
    private HashMap<String, ArrayList<String>> subData;
    private String id;

    public Subscriber(){
        subData = new HashMap<>();
    }

    public void setId(){
        this.id = String.valueOf(Thread.currentThread().getId());
    }
    public synchronized void register(String topic){
        Broker.getInstance().registerSubscriber(topic, id);
    }

    public void getData(String topic){
        try{
            ArrayList<String> receivedData = Broker.getInstance().sendData(topic, this.id);
            if(!receivedData.isEmpty()){
                subData.put(topic, receivedData);
            }else{
                System.out.println("No data available for topic" + topic);
            }
        }catch (NotRegisterException e){
            System.err.println("not registerd for topic:  " + topic);
        }catch(NotFoundKeyException e){
            System.err.println("Topic not found: " + topic);
        }
    }

    public void print(){
        synchronized (subData) {
            for (String key : subData.keySet()) {
                System.out.println("ID: " + id);
                System.out.println("Key: " + key);
                System.out.println("Value: " + subData.get(key));
                System.out.println();
            }
        }
    }

    public void run(){
        setId();
        System.out.println("my id: " + this.id);
        register("movie");

        while(true){
            try{
                System.out.println("give me a data");
                getData("movie");
                print();

                Thread.sleep(10);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}