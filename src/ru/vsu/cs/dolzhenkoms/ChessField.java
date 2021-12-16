package ru.vsu.cs.dolzhenkoms;

import java.util.List;

public class ChessField {
    ChessFieldObject[][] field;

    public ChessField(int size, Point horseLocation, List<Point> walls) {
        initializeField(size, horseLocation, walls);
    }

    public ChessFieldObject[][] getField() {
        return field;
    }

    public void drawField() {
        for(int y = 0; y < field.length; y++) {
            System.out.print("|");
            for(int x = 0; x < field[y].length; x++) {
                System.out.print(field[y][x].toString());
            }
            System.out.print("|\n");
        }
    }

    private void initializeField(int size, Point horseLocation, List<Point> walls) {
        field = new ChessFieldObject[size][size];

        for(int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                field[y][x] = ChessFieldObject.EMPTY;

                if(horseLocation.getX() - 1 == x && horseLocation.getY() - 1 == y) {
                    field[y][x] = ChessFieldObject.HORSE;
                }
                if(walls.contains(x + 1) && walls.contains(y + 1)) {
                    field[y][x] = ChessFieldObject.WALL;
                }
            }
        }
    }
}
