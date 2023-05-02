package c21716601;

import processing.core.PApplet;


public class case4{
    rockstar case4;

    public case4(rockstar case4)
    {
        this.case4 = case4;
    }

    public void render() {
      // set background color
      if (case4.frameCount % 120 < 60) {
        case4.background(0, 0, 100); // blue
      } else {
        case4.background(0); // black
      }
      
      // draw the circles
      case4.noFill();
      case4.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
      case4.translate(0, 0, 0);
      case4.strokeWeight(4);
        
      /*float[] b = case4.getSmoothedBands();
      case4.stroke(100, 100, 100);
      float size = b[2];
      case4.circle(0, 0, size);*/
      
      case4.noFill();
      case4.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
      case4.translate(0, 0, 0);
      case4.strokeWeight(4);
        
      /*float[] b1 = case4.getSmoothedBands();
      case4.stroke(100, 100, 100);
      float size1 = b1[2];
      case4.circle(0, 0, size1);*/
      
      case4.noFill();
      case4.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
      case4.translate(0, 0, 0);
      case4.strokeWeight(2);
        
      float[] b2 = case4.getSmoothedBands();
      for(int i=0; i<b2.length ; i++)
      {
          float c = PApplet.map(i, 255, b2.length, 50, 150);
          if(i == 2){
              case4.stroke(200, 200, 200); // set stroke color to blue for band index 2
          }
          else{
              case4.stroke(200, 200, 200); // set stroke color for other bands
          }
          float s = b2[i];
          case4.pushMatrix();
          case4.circle(0, 0, s);
          case4.popMatrix();
      }
      
      if (case4.frameCount % 60 == 0){ // every 60 frames
          case4.stroke(100); // set stroke color to white
      }
    
      // draw the circles
      case4.noFill();
      case4.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
      case4.translate(0, 0, 0);
      case4.strokeWeight(4);
    
      // Draw the middle white circle
      case4.stroke(255);
      case4.fill(255);
      case4.circle(0, 0, 20);
    
      case4.stroke(255, 0, 0); // set stroke color to red
      case4.fill(255, 0, 0); // set fill color to red
      case4.circle(0,0,10);
    
 case4.circle(0, 0, 10);


// Calculate the position of the three circles around the center circle
float angle = case4.radians(case4.frameCount * 2);
float[] x = new float[4];
float[] y = new float[4];
for (int i = 0; i < 4; i++) {
    x[i] = 60 * case4.cos(angle + i * case4.radians(120));
    y[i] = 60 * case4.sin(angle + i * case4.radians(120));
}

float s = 0;

// Draw the three white circles
for (int i = 0; i < 4; i++) {
    case4.stroke(255);
    case4.fill(255);
    case4.circle(x[i], y[i], s*2);

 // Draw a solid red circle inside the white circle
 case4.stroke(255, 0, 0); // set stroke color to red
 case4.fill(255, 0, 0); // set fill color to red
 case4.circle(x[i], y[i], 10); // draw the red circle at the same position as the white circle



}




}




}