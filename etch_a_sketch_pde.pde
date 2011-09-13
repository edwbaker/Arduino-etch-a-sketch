import processing.serial.*;
import cc.arduino.*;

float x = 0;
int y = 0;
float x_old = 0;
int y_old = 0;
Arduino arduino;

void setup() {
  size (500, 500);
  background(0);
  arduino = new Arduino(this, Arduino.list()[0], 57600);
 

}

void draw() {
 if (frameCount == 1) {
   delay(3000);
   x = x_old = arduino.analogRead(0);
   y = y_old = arduino.analogRead(1);
 }
  stroke(255);
  
  x = arduino.analogRead(0);
  y = arduino.analogRead(1);
  line (x_old, y_old, x, y);
  
  stroke(0, 25, 0);
  point(x,y);
  
  x_old = x;
  y_old = y ;
  
}
