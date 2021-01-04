package service;

import java.util.HashMap;

public class DataComparator {
    public static boolean compareData(HashMap<String, String> receivedData, DataReader expectedData) {
        boolean flag = true;
        for (String key : receivedData.keySet()) {
            System.out.println(key + " = " + receivedData.get(key));
            if (!expectedData.readData(key).toLowerCase().contains(receivedData.get(key).toLowerCase()))
                flag = false;
        }
        return flag;
    }
}
