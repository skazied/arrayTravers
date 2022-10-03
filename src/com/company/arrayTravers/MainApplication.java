package com.company.arrayTravers;

import java.util.ArrayList;

public class MainApplication {

    public static void main(String[] args) {
        MainApplication main = new MainApplication();
        main.resolveProblem();
    }

    public void resolveProblem() {
        //Declaration of array
        int [][] arrayTable = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        //Calculation of movements
        ArrayList<Integer> movements = movementList(arrayTable.length);
        ArrayList<Integer> result = new ArrayList<>();

        ArrayCursor cursor = new ArrayCursor(0,0);
        MovementDirection movementDirection = MovementDirection.RIGHT;

        //moves cursor movements[n] times to get variables from arrayTable
        for (int movementCounter = 0; movementCounter < movements.size(); movementCounter++ ) {
            for (int i = 0; i < movements.get(movementCounter); i++) {
                result.add(arrayTable[cursor.getColumnIndex()][cursor.getRowIndex()]);

                //gets into the right position for next iteration at end of the current iteration
                if (movements.get(movementCounter) -1 == i) {
                    movementDirection = getNextMovementDirection(movementDirection);
                }
                moveCursor(cursor,movementDirection);
            }
        }
        System.out.println(result);
    }

    //count movement numbers of every iteration
    public ArrayList<Integer> movementList(int number) {
        ArrayList<Integer> response = new ArrayList<>();
        response.add(number);
        while (number != 1) {
            number--;
            response.add(number);
            response.add(number);
        }
        return response;
    }

    //Moves cursor one step on the given direction
    public void moveCursor(ArrayCursor cursor, MovementDirection movementDirection){
        if (movementDirection == MovementDirection.RIGHT)
            cursor.incrementRowIndex(1);
        else if (movementDirection == MovementDirection.DOWN)
            cursor.incrementColumnIndex(1);
        else if (movementDirection == MovementDirection.LEFT)
            cursor.decrementRowIndex(1);
        else if (movementDirection == MovementDirection.UP)
            cursor.decrementColumnIndex(1);
    }

    //Gets next movement direction by order (right,down,left,up,right,down,left,....)
    public MovementDirection getNextMovementDirection(MovementDirection movementDirection) {
        if (movementDirection == MovementDirection.RIGHT)
            return MovementDirection.DOWN;
        else if (movementDirection == MovementDirection.DOWN)
            return MovementDirection.LEFT;
        else if (movementDirection == MovementDirection.LEFT)
            return MovementDirection.UP;
        else
            return MovementDirection.RIGHT;
    }

}