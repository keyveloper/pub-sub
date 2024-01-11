package org.example;

import java.util.*;

public class Broker {
    public static Broker brokerInstance;

    private static HashMap<String, ArrayList<String>> subscribers;

    private static HashMap<String, ArrayList<String>> dataBase;

    public Broker(){
        subscribers = new HashMap<>();
        dataBase = new HashMap<>();
    }

    public static Broker getInstance(){
        if(brokerInstance == null){
            brokerInstance = new Broker();
        }
        return brokerInstance;
    }

    public void registerSubscriber(String topic, String id){
        if(subscribers.containsKey(topic)){
            ArrayList<String> insertList = subscribers.get(topic);
            if(insertList.contains(id)){
                System.out.println("already exist.");
                return;
            }
            insertList.add(id);
            subscribers.put(topic, insertList);
            ArrayList<String> printedList = subscribers.get(topic);
            System.out.println("register success!" + printedList);
        }else{
            ArrayList<String> newSubIDs = new ArrayList<>();
            newSubIDs.add(id);
            subscribers.put(topic, newSubIDs);
            ArrayList<String> printedList = subscribers.get(topic);
            System.out.println("register success!" + printedList);
        }
    }

    public void setData(String topic, String data){
        if(dataBase.containsKey(topic)){
            ArrayList<String> insertList = dataBase.get(topic);
            insertList.add(data);
            dataBase.put(topic, insertList);
        }else{
            ArrayList<String> newList = new ArrayList<>();
            newList.add(data);
            dataBase.put(topic, newList);
        }
    }

    public static ArrayList<String> sendData(String topic, String id){
        if(subscribers.containsKey(topic)){
            ArrayList<String> searchList = subscribers.get(topic);
            if(searchList.contains(id)){
                ArrayList<String> sendData =  dataBase.get(topic);
                if(sendData == null){
                    return new ArrayList<>();
                }
                return sendData;
            }else{
                throw new NotRegisterException();
            }
        }
        throw new NotFoundKeyException();
    }
}