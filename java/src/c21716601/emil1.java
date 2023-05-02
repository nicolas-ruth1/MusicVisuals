package c21716601;

import processing.core.PApplet;

public class emil1 {

    rockstar emil;

    float smallSphereSize = 0; // initial size of small sphere
    float smallSphereAngle = 0; // initial angle of rotation for small sphere

    public emil1(rockstar emil) {
        this.emil = emil;
    }

    public void render() {
        emil.noFill();
        emil.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(4);
        float[] stars = new float[500];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = emil.random(-emil.width, emil.width);
        }

        //stars
        emil.stroke(255,255, 255);//colour
        for (int i = 0; i < stars.length; i++) {
            float speed = emil.map(emil.getSmoothedAmplitude(), 0, 1, 1, 5);
            stars[i] += speed;
            if (stars[i] > emil.width) {
                stars[i] = emil.random(-emil.width, 0);
            }
            emil.point(stars[i], emil.random(-emil.height, emil.height));
        }
/* 
        float[] b = emil.getSmoothedBands();
        emil.stroke(250, 96, 78);
        float size = b[2];
        emil.circle(0, 0, size);
*/
        emil.noFill();
        emil.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(4);

        // animate and rotate the small sphere
        smallSphereSize = PApplet.map(PApplet.sin(PApplet.radians(smallSphereAngle)), -1, 1, 5, 10);
        smallSphereAngle -=5;
        



}


    }
    
