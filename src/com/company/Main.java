package com.company;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        System.out.println("Selectionsort");

        String[] list ={"Hej","Goddag","Farvel","Miav","Wuff","Pip","Hjem","Abekat","MonkaS","Godnat"};
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

        System.out.println();
        System.out.println("Insertionsort");

        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

        System.out.println();
        System.out.println("Bubblesort");

        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

        System.out.println();
        System.out.println("Mergesort");

        mergeSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

    }


    public static void selectionSort(String[] list){

        for (int i = 0; i < list.length-1; i++) {
            String currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i+1; j < list.length; j++) {

                if (currentMin.compareToIgnoreCase(list[j]) > 0){
                    currentMin = list[j];
                    currentMinIndex= j;

                }

            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }


    }
    
    public static void insertionSort(String[] list){
        for (int i = 0; i < list.length; i++) {
            String currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k].compareToIgnoreCase(currentElement) > 0; k--) {
                list[k+1] = list[k];
            }
            list[k+1] = currentElement;
        }
        
    }

    public static void bubbleSort(String[] list){
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {

            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i].compareToIgnoreCase(list[i]+1) > 0) {

                    String  temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    public static void mergeSort(String[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            String[] firstHalf = new String[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - (list.length / 2);
            String[] secondHalf = new String[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }
    public static void merge(String[] list1, String[] list2, String[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareToIgnoreCase(list2[current2])< 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }



}
