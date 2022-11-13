package com.example.phase3;

import java.util.ArrayList;

public class Store {
    public static int testVar = 0;
    public static int testing = 1;

    public static ArrayList<Order> orders = new ArrayList<>();

    public static boolean asuriteValidation(String asuID) {
        try {
            int id = Integer.parseInt(asuID);
            int length = String.valueOf(id).length();
            if(length < 10 || length > 10) {
                return false;
            }
            System.out.println(id);
        }
        catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
