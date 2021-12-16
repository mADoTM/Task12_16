package ru.vsu.cs.dolzhenkoms;

import java.util.ArrayList;
import java.util.List;

public class Horse {
    private Point spawnLocation;
    private ChessFieldObject[][] field;

    private List<Point> visitedPoints = new ArrayList<>();

    private int countSteps;
    private int step = 0;

    public Horse(int countSteps, Point spawnLocation, ChessField chessField) {
        this.countSteps = countSteps;
        this.spawnLocation = spawnLocation;
        this.field = chessField.getField();

        visitedPoints.add(spawnLocation);

        move(spawnLocation, 0);
    }

    public List<Point> getVisitedPoints() {
        return visitedPoints;
    }

    private void move(Point horseLocation, int step) {
        if(step < countSteps) {

            Point upLeftPoint = new Point(horseLocation.getX() - 1, horseLocation.getY() - 2);
            Point upRightPoint = new Point(horseLocation.getX() + 1, horseLocation.getY() - 2);
            Point rightUpPoint = new Point(horseLocation.getX() + 2, horseLocation.getY() - 1);
            Point rightDownPoint = new Point(horseLocation.getX() + 2, horseLocation.getY() + 1);
            Point downLeftPoint = new Point(horseLocation.getX() - 1, horseLocation.getY() + 2);
            Point downRightPoint = new Point(horseLocation.getX() + 1, horseLocation.getY() + 2);
            Point leftUpPoint = new Point(horseLocation.getX() - 2, horseLocation.getY() - 1);
            Point leftDownPoint = new Point(horseLocation.getX() - 2, horseLocation.getY() + 1);


            if(isPointInsideField(field, upLeftPoint)) {
                if(field[upLeftPoint.getY() - 1][upLeftPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(upLeftPoint) == false) {
                        visitedPoints.add(upLeftPoint);
                        move(upLeftPoint, step++);
                    }
                }
            }
            if(isPointInsideField(field, upRightPoint)) {
                if(field[upRightPoint.getY() - 1][upRightPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(upRightPoint) == false) {
                        visitedPoints.add(upRightPoint);
                        move(upRightPoint, step++);
                    }
                }
            }if(isPointInsideField(field, rightUpPoint)) {
                if(field[rightUpPoint.getY() - 1][rightUpPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(rightUpPoint) == false) {
                        visitedPoints.add(rightUpPoint);
                        move(rightUpPoint, step++);
                    }
                }
            }
            if(isPointInsideField(field, rightDownPoint)) {
                if(field[rightDownPoint.getY() - 1][rightDownPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(rightDownPoint) == false) {
                        visitedPoints.add(rightDownPoint);
                        move(rightDownPoint, step++);
                    }
                }
            }
            if(isPointInsideField(field, downLeftPoint)) {
                if(field[downLeftPoint.getY() - 1][downLeftPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(downLeftPoint) == false) {
                        visitedPoints.add(downLeftPoint);
                        move(downLeftPoint, step++);
                    }
                }
            }
            if(isPointInsideField(field, downRightPoint)) {
                if(field[downRightPoint.getY() - 1][downRightPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(downRightPoint) == false) {
                        visitedPoints.add(downRightPoint);
                        move(downRightPoint, step++);
                    }
                }
            }
            if(isPointInsideField(field, leftUpPoint)) {
                if(field[leftUpPoint.getY() - 1][leftUpPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(containsVisitedPoint(leftUpPoint) == false) {
                        visitedPoints.add(leftUpPoint);
                        move(leftUpPoint, step++);
                    }
                }
            }
            if(isPointInsideField(field, leftDownPoint)) {
                if(field[leftDownPoint.getY() - 1][leftDownPoint.getX() - 1] == ChessFieldObject.EMPTY) {
                    if(!containsVisitedPoint(leftDownPoint)) {
                        visitedPoints.add(leftDownPoint);
                        move(leftDownPoint, step++);
                    }
                }
            }
        }
    }

    private boolean isPointInsideField(ChessFieldObject[][] field, Point point) {
        return (point.getX() >= 1 && point.getX() <= field.length) && (point.getY() >= 1 && point.getY() <= field.length);
    }

    private boolean containsVisitedPoint(Point point) {
        for(int i = 0; i < visitedPoints.size(); i++) {
            if(visitedPoints.get(i).getX() == point.getX() && visitedPoints.get(i).getY() == point.getY())
                return true;
        }
        return false;
    }
}
