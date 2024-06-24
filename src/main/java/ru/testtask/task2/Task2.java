package ru.testtask.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        File circleFile = new File("src/main/java/ru/testtask/task2/files/file1.txt");
        File pointsFile = new File("src/main/java/ru/testtask/task2/files/file2.txt");

        double centerX = 0;
        double centerY = 0;
        double radius = 0;

        try {
            Scanner circleScanner = new Scanner(circleFile);
            centerX = circleScanner.nextDouble();
            centerY = circleScanner.nextDouble();
            radius = circleScanner.nextDouble();
            circleScanner.close();

            Scanner pointsScanner = new Scanner(pointsFile);
            while (pointsScanner.hasNextDouble()) {
                double x = pointsScanner.nextDouble();
                double y = pointsScanner.nextDouble();
                int position = getPointPosition(centerX, centerY, radius, x, y);
                System.out.println(position);
            }
            pointsScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static int getPointPosition(double centerX, double centerY, double radius, double x, double y) {
        double distance = Math.sqrt((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY));
        if (distance == radius) {
            return 0;
        } else if (distance < radius) {
            return 1;
        } else {
            return 2;
        }
    }
}