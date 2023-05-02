package c21716601;

import processing.core.PApplet;

public class us1 {

    rockstar emil;

    float smallSphereSize = 0; // initial size of small sphere
    float smallSphereAngle = 0; // initial angle of rotation for small sphere

    public us1(rockstar emil) {
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
        emil.stroke(250, 96, 78);
        for (int i = 0; i < stars.length; i++) {
            float speed = emil.map(emil.getSmoothedAmplitude(), 0, 1, 1, 5);
            stars[i] += speed;
            if (stars[i] > emil.width) {
                stars[i] = emil.random(-emil.width, 0);
            }
            emil.point(stars[i], emil.random(-emil.height, emil.height));
        }

        float[] b = emil.getSmoothedBands();
        emil.stroke(250, 96, 78);
        float size = b[2];
        emil.circle(0, 0, size);

        emil.noFill();
        emil.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(4);

        float[] b1 = emil.getSmoothedBands();
        emil.stroke(250, 96, 78);
        float size1 = b1[2];
        emil.circle(0, 0, size1);

        emil.noFill();
        emil.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(2);

        /* 
        float[] b2 = emil.getSmoothedBands();
        for (int i = 0; i < b2.length; i++) {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            emil.stroke(78, 233, 250);
            float s = b2[i];
            emil.pushMatrix();
            emil.translate(0, 0, s / 2); // move to center of the small sphere
            emil.rotateZ(PApplet.radians(smallSphereAngle)); // rotate around the Z-axis
            emil.sphere(smallSphereSize); // draw the small sphere
            emil.popMatrix();
        }
*/
        // animate and rotate the small sphere
        smallSphereSize = PApplet.map(PApplet.sin(PApplet.radians(smallSphereAngle)), -1, 1, 5, 10);
        smallSphereAngle -=5;
        



}


    }
    
