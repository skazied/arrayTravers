package com.company.arrayTravers;

public class ArrayCursor {
    private Integer rowIndex = 0;
    private Integer columnIndex = 0;

    public ArrayCursor(Integer rowIndex, Integer columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public ArrayCursor() {
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(Integer columnIndex) {
        this.columnIndex = columnIndex;
    }




    public Integer incrementRowIndex(Integer value) {
        rowIndex = rowIndex+value;
        return rowIndex;
    }

    public Integer decrementRowIndex(Integer value) {
        rowIndex = rowIndex-value;
        return rowIndex;
    }

    public Integer incrementColumnIndex(Integer value) {
        columnIndex = columnIndex+value;
        return columnIndex;
    }

    public Integer decrementColumnIndex(Integer value) {
        columnIndex = columnIndex-value;
        return columnIndex;
    }


}
