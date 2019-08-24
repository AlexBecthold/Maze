/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mazesolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author abect
 */

public class Maze {
    
    private Integer[][] maze;
    private Integer startRow, startCol, endRow, endCol;
    
    public Maze(Integer rowDim, Integer colDim) {
        if(rowDim%2 == 0) {
            System.out.println("Rows Dimension must be odd, reset to " + String.valueOf(rowDim+1));
            rowDim++;
        }
        else if(colDim%2 == 0) {
            System.out.println("Y Dimension must be odd, reset to " + String.valueOf(colDim+1));
            colDim++;
        }
        this.maze = new Integer[rowDim][colDim];
        this.startRow = 1;
        this.startCol = 1;
        this.endRow = rowDim-1;
        this.endCol = colDim-1;
        reset();
    }
    
    public Integer[][] generate() {
        reset();
        maze[startRow][startCol] = 1;
        dfs(startRow, startCol);
        return maze;
    }
    
    public void dfs(Integer row, Integer col) {
        Integer[] randomDirections = randomDirections();
        for(int i=0; i<randomDirections.length; i++) {
            switch(randomDirections[i]) {
                //Up
                case 0:
                    if(row-2 <= 0) {
                        continue;
                    }
                    if(maze[row-2][col] !=1) {
                        maze[row-2][col] = 1;
                        maze[row-1][col] = 1;
                        dfs(row-2, col);
                    }
                    break;
                //Down
                case 1:
                    if(row+2 >= maze.length-1) {
                        continue;
                    }
                    if(maze[row+2][col] !=1) {
                        maze[row+2][col] = 1;
                        maze[row+1][col] = 1;
                        dfs(row+2, col);
                    }
                    break;
                //Left
                case 2:
                    if(col-2 <= 0) {
                        continue;
                    }
                    if(maze[row][col-2] != 1) {
                        maze[row][col-2] = 1;
                        maze[row][col-1] = 1;
                        dfs(row, col-2);
                    }
                    break;
                //Right
                case 3:
                    if(col+2 >= maze[0].length) {
                        continue;
                    }
                    if(maze[row][col+2] != 1) {
                        maze[row][col+2] = 1;
                        maze[row][col+1] = 1;
                        dfs(row, col+2);
                    }
                    break;
            }
        }
    }
    
    public Integer[] randomDirections() {
        ArrayList<Integer> directions = new ArrayList<Integer>();
        for(int i=0; i<4; i++) {
            directions.add(i);
        }
        Collections.shuffle(directions);
        return directions.toArray(new Integer[4]);
    }
    
    public Integer[] addLocation(Integer row, Integer col) {
        Integer[] location = new Integer[2];
        location[0] = row;
        location[1] = col;
        return location;
    }
    
    public void printMaze() {
        System.out.println("\nRows: " + String.valueOf(maze.length));
        System.out.println("Cols: " + String.valueOf(maze[0].length) + "\n");
        //Print method 1
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                System.out.print(String.valueOf(maze[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Print method 2
        for(int i=0; i<maze.length; i++) {
            System.out.println(Arrays.deepToString(maze[i]));
        }
    }
    
    public void reset() {
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                maze[i][j] = 0;
            }
        }
    }
    
    public void iterate() {
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                returnValue(i, j);
            }
        }
    }
    
    public Integer returnValue(Integer row, Integer col) {
        return maze[row][col];
    }
}
