package ru.testtask.task1;

import java.util.Arrays;
import java.util.Scanner;

public class CircularArrayPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        Arrays.setAll(arr, i -> ++i);
        int current = 0;
        do {
            System.out.print(arr[current]);
            current = (current + m - 1) % n;
        } while (current != 0);
    }
}
