package org.example;

import java.util.*;

public class Publisher {
    private String topic;

    public Publisher(){
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public void publish(String data){
        Broker.getInstance().setData(this.topic, data);
    }
}
