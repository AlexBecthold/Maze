/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mazesolver;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author abect
 */
public class Finish extends JPanel{
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 25, 25);
    }
}
