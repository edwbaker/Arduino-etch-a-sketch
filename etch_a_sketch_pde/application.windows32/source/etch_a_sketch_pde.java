import processing.core.*; 
import processing.xml.*; 

import processing.serial.*; 
import cc.arduino.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class etch_a_sketch_pde extends PApplet {




float x = 0;
int y = 0;
float x_old = 0;
int y_old = 0;
Arduino arduino;

public void setup() {
  size (500, 500);
  background(0);
  arduino = new Arduino(this, Arduino.list()[0], 57600);
  x = x_old = arduino.analogRead(0);
  y = y_old = arduino.analogRead(1);
}

public void draw() {

  stroke(255);
  
  x = arduino.analogRead(0);
  y = arduino.analogRead(1);
  line (x_old, y_old, x, y);
  x_old = x;
  y_old = y ;
  
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "etch_a_sketch_pde" });
  }
}
