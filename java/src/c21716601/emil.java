package c21716601;

import processing.core.*;

public class emil 
{
    rockstar er;
    float rotation = 0;

    public emil(rockstar er)
    {
        this.er = er;
    }

    public void render() {
        er.noFill();
        rotation += er.getAmplitude() / 3f;
        er.rotateX(rotation);
        er.strokeWeight(2);
    
        // Set color mode to HSB
        er.colorMode(PConstants.HSB, 255);
    
        float[] b = er.getSmoothedBands();
        for (int i = 0; i < b.length; i++) {
            float colour = PApplet.map(i, 0, b.length, 0, 155);
    
            // Get the audio amplitude
            float audioAmplitude = er.getAmplitude();
    
            // Calculate the hue based on the audio amplitude
            float hue = PApplet.map(audioAmplitude, 0, 1, 0, 255);
    
            // Set the stroke color using the calculated hue
            er.stroke(hue, 255, 255);
    
            er.pushMatrix();
            er.box(colour);
            er.popMatrix();
        }
    
        // Reset color mode to RGB (optional)
        er.colorMode(PConstants.RGB, 255);
    }
    
    
}
