package ru.vsu.cs.dolzhenkoms;

public enum ChessFieldObject {
    EMPTY(" "),
    HORSE("&"),
    WALL("|");

    private final String name;

    ChessFieldObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
