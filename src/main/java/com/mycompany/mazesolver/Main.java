/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mazesolver;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author abect
 */

public class Main {

    public static void main(String[] args) {
        Integer numRows = 35;
        Integer numCols = 35;
        Maze maze = new Maze(numRows, numCols);
        maze.generate();
        maze.printMaze();
        System.out.println();
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Unsolved Maze");
        frame.setSize(2000, 2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(numRows, numCols));
        Integer value;
        //frame.add(new thing()) for each corresponding maze location
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++) {
                value = maze.returnValue(j, i);
                if(i==1 && j==1) {
                    frame.add(new Start());
                }
                else if(i==numRows-2 && j==numCols-2) {
                    frame.add(new Finish());
                }
                else {
                    switch(value) {
                    case 0: //Wall
                        frame.add(new Wall());
                        break;
                    case 1: //Path
                        frame.add(new Path());
                        break;
                    case 2: //Solution
                        frame.add(new Solution());
                        break;
                }
                }
            }
        }
        frame.pack();
        frame.setVisible(true);
        
        //DFS Solution
        
        
        //BFS Solution
        
        
        //Prim's MST Solution
        
        
        //Kruskal's MST Solution
        
    }
}
