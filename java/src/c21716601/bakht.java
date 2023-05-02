package c21716601;

import processing.core.PApplet;

public class bakht {
    rockstar bakht;

    public bakht(rockstar bakht)
    {
        this.bakht = bakht;
    }

    public void render() {

  // set background color
  if (bakht.frameCount % 120 < 60) {
    bakht.background(100, 0, 0); // dark red
  } else {
    bakht.background(0); // black
  }

// Draw the middle white circle
bakht.stroke(255);
bakht.fill(255);
bakht.circle(0, 0, 20);


if (bakht.frameCount % 120 < 60) {
 bakht.stroke(255, 0, 0); // set stroke color to red
 bakht.fill(0); // set fill color to red
 bakht.circle(0, 0, 10);} 
 else {
  bakht.background(0); // black
  bakht.stroke(255, 0, 0); // set stroke color to red
 bakht.fill(255, 0, 0); // set fill color to red
 bakht.circle(0, 0, 10);
 
}

// draw the circles
bakht.noFill();
bakht.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
bakht.translate(0, 0, 0);
bakht.strokeWeight(4);

// Calculate the position of the three circles around the center circle
float angle = bakht.radians(bakht.frameCount * 2);
float[] x = new float[4];
float[] y = new float[4];
for (int i = 0; i < 4; i++) {
    x[i] = 60 * bakht.cos(angle + i * bakht.radians(120));
    y[i] = 60 * bakht.sin(angle + i * bakht.radians(120));
}

// Draw the three white circles
for (int i = 0; i < 3; i++) {
    bakht.stroke(255);
    bakht.fill(255);
    bakht.circle(x[i], y[i], 20);

 // Draw a solid red circle inside the white circle
  // Set color of the red circles based on the background color
  if (bakht.frameCount % 120 < 60) {
    bakht.stroke(0); // set stroke color to black when background is dark red
    bakht.fill(0); // set fill color to black when background is dark red
    bakht.circle(x[i], y[i], 10); // draw the red circle at the same position as the white circle
  } else {
    bakht.stroke(255, 0, 0); // set stroke color to red when background is black
    bakht.fill(255, 0, 0); // set fill color to red when background is black
    bakht.circle(x[i], y[i], 10); // draw the red circle at the same position as the white circle
  }
}

        // draw the hollow circles that expand
        bakht.noFill();
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(4);
    
        bakht.noFill();
        bakht.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(2);
    
        float[] b2 = bakht.getSmoothedBands();
        for(int i=0; i<b2.length ; i++)
        {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            if(i == 2){
                bakht.stroke(200, 200, 200); // set stroke color to blue for band index 2
            }
            else{
                bakht.stroke(200, 200, 200); // set stroke color for other bands
            }
            float s = b2[i];
            bakht.pushMatrix();
            bakht.circle(0, 0, s);
            bakht.popMatrix();
        }
        if (bakht.frameCount % 60 == 0){ // every 60 frames
            bakht.stroke(100); // set stroke color to white
        }
}
}