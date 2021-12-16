package ru.vsu.cs.dolzhenkoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int horseX = readInt("координату лошади X ");
        int horseY = readInt("координату лошади Y ");
	    Point horseStartPoint = new Point(horseX, horseY);

        int sizeField = readInt("размер поля (NxN)");

        int countWalls = readInt("количество стен");
        List<Point> walls = new ArrayList<>();
        for(int i = 0; i < countWalls; i++) {
            int wallX = readInt("координату " + (i + 1) + " стены X");
            int wallY = readInt("координату " + (i + 1) + " стены Y");
            Point wall = new Point(wallX, wallY);
            walls.add(wall);
        }
        ChessField chessField = new ChessField(sizeField, horseStartPoint, walls);

        int countSteps = readInt("максимальное количество шагов лошади");
        Horse horse = new Horse(countSteps, horseStartPoint, chessField);

        List<Point> visitedPoints = horse.getVisitedPoints();


        printResult(visitedPoints);
    }

    private static int readInt(String text) {
        Scanner scn = new Scanner(System.in);
        int value = 0;

        try {
            System.out.print("Введите " + text + " - ");
            value = scn.nextInt();
        }
        catch (Exception ex) {
            System.out.println("Вы ввели не число! Повторите заново");
            return readInt(text);
        }

        return value;
    }

    private static void printResult(List<Point> points) {
        System.out.println("Из точки " + points.get(0) + " можно дойти до точек:");
        for(int i = 1; i < points.size(); i++) {
            System.out.println(i + "." + points.get(i));
        }
    }
}
