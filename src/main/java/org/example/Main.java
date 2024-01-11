package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReaderM = new BufferedReader(new InputStreamReader(System.in));
        Publisher pub = new Publisher();
        Boolean flag = true;

        Thread sub0 = new Thread(new Subscriber());

        sub0.start();

        while(flag){
            System.out.println("how many data?");
            int amount = Integer.parseInt(bufferedReaderM.readLine());

            if(amount == 0){
                flag = false;
                continue;
            }

            System.out.println("topic");
            String topic = bufferedReaderM.readLine();
            pub.setTopic(topic);

            for(int i =0; i < amount; i++){
                System.out.println("data");
                String data = bufferedReaderM.readLine();

                pub.publish(data);
            }

        }



    }
}