package com.epam.automation.java.fundamentals.main;

import java.util.Scanner;

public class RandomNumbersPrint {
    public static void main(String[] args) {
        int number;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter count of random numbers:");
        while (true){
            if(inputScanner.hasNextInt()){
                number = inputScanner.nextInt();
                inputScanner.close();
                break;
            }
            System.out.println("Please enter integer.");
            inputScanner.nextLine();
        }
        System.out.println("Output with line breaks:");
        for (int i = 0; i < number; i++) {
            System.out.println(Math.random());
        }
        System.out.println("\nOutput without line breaks:");
        for (int i = 0; i < number; i++) {
            System.out.print(Math.random() + " ");
        }
    }
}
