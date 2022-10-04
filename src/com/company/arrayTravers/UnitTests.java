package com.company.arrayTravers;


import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UnitTests {

    MainApplication mainApplication;
    ArrayCursor cursor;

    @BeforeEach
    void initializaObjects(){
        mainApplication = new MainApplication();
        cursor = new ArrayCursor();
    }

    @Test
    @DisplayName("Test of if movement list created proper")
    void testMovementCalculationList() {
        ArrayList<Integer> integers = mainApplication.movementList(5);
        Integer total = integers.stream().mapToInt(i->i.intValue()).sum();
        assertEquals(total, 5*5);
    }

    @Test
    @DisplayName("Cursor position test")
    void testCursorPosition() {
        cursor.incrementColumnIndex(5);
        assertEquals(cursor.getColumnIndex(), 5);
        cursor.decrementColumnIndex(5);
        assertEquals(cursor.getColumnIndex(), 0);
        cursor.incrementRowIndex(2);
        assertEquals(cursor.getRowIndex(), 2);
        cursor.decrementRowIndex(2);
        assertEquals(cursor.getRowIndex(), 0);
    }

    @Test
    @DisplayName("Movement direction order test")
    void testGetNextMovementDirection() {
        assertEquals(mainApplication.getNextMovementDirection(MovementDirection.UP), MovementDirection.RIGHT);
        assertEquals(mainApplication.getNextMovementDirection(MovementDirection.RIGHT), MovementDirection.DOWN);
        assertEquals(mainApplication.getNextMovementDirection(MovementDirection.DOWN), MovementDirection.LEFT);
        assertEquals(mainApplication.getNextMovementDirection(MovementDirection.LEFT), MovementDirection.UP);
    }

    @Test
    @DisplayName("check if MoveCursor method moves cursor one step on given direction")
    void testMoveCursorIfMovesTheCursorRight() {
        cursor.setColumnIndex(0);
        cursor.setRowIndex(0);
        mainApplication.moveCursor(cursor, MovementDirection.DOWN);
        assertEquals(cursor.getColumnIndex(), 1);
        mainApplication.moveCursor(cursor, MovementDirection.UP);
        assertEquals(cursor.getColumnIndex(), 0);
        mainApplication.moveCursor(cursor, MovementDirection.RIGHT);
        assertEquals(cursor.getRowIndex(), 1);
        mainApplication.moveCursor(cursor, MovementDirection.LEFT);
        assertEquals(cursor.getRowIndex(), 0);

    }


}
