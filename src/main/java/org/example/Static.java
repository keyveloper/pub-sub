package org.example;

public class Static {
    private static int sharedValue;

    private int instanceValue;

    public Static(int instanceValue){
        this.instanceValue = instanceValue;
        sharedValue = 5;
        sharedValue--;
    }

    public int getSharedValue(){
        return sharedValue;
    }

    public int getInstanceValue(){
        return instanceValue;
    }

    public static int add(int a, int b){
        return a + b;
    }
}


