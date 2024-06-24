package ru.testtask.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        File file = new File("src/main/java/ru/testtask/task4/file/mas.txt");

        try {
            Scanner scanner = new Scanner(file);

            ArrayList<Integer> numbers = new ArrayList<>();

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
            int[] array = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                array[i] = numbers.get(i);
            }

            System.out.println(minMoves(array));

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
