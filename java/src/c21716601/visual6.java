package c21716601;

import processing.core.PApplet;
import processing.core.PConstants;

public class visual6 {

    rockstar rs;
    private float[] hoopSizes = { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }; // starting size at 5 pixels for the 5 hoops
    private float[] hoopOpacities = { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    private float[] newHoopSizes = { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }; // starting size at 5 pixels for the 5 new hoops
    private float[] newHoopOpacities = { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    private int lastHoopTime = 0;
    private int hoopInterval = 1000; // 1 second interval
    private int currentHoop = 0;

    public visual6(rockstar rs) {
        this.rs = rs;
    }

    float angle = 0.0f;
    float width = 800f;
    float height = 800f;

    // render
    public void render() {

        rs.background(0);
        angle += 1.0; // Increment the angle by a small amount
        rs.camera(-1800, -1800, 0, 0, 0, 0, 1, 0, 0);

        rs.pushMatrix();
        rs.translate(400, 400);
        rs.rotateX(angle);
        float amplitude = rs.getSmoothedAmplitude();

        // Smoothly transition color values through RGB spectrum
        rs.colorMode(PConstants.RGB);
        rs.stroke((float) Math.abs(255 * Math.sin(angle)), (float) Math.abs(255 * Math.sin(angle + PConstants.PI / 2)),
                (float) Math.abs(255 * Math.sin(angle + PConstants.PI)));

        // Expand the current hoop
        hoopSizes[currentHoop] += amplitude * 20;
        hoopOpacities[currentHoop] = rs.map(amplitude, 0, 1, 0, 255);

        // Create and expand new hoops every 1 second interval
        int currentTime = rs.millis();
        if (currentTime - lastHoopTime > hoopInterval) {
            lastHoopTime = currentTime;
            currentHoop++;
            if (currentHoop >= hoopSizes.length) {
                currentHoop = 0;
            }
            newHoopSizes[currentHoop] = 5.0f;
            newHoopOpacities[currentHoop] = 0.0f;
        }

        // Expand the new hoops
        for (int i = 0; i < newHoopSizes.length; i++) {
            newHoopSizes[i] += amplitude * 20;
            newHoopOpacities[i] = rs.map(amplitude, 0, 1, 0, 255);
        }

        // Draw all the hoops
        for (int i = 0; i < hoopSizes.length; i++) {
            rs.strokeWeight(10);

            // Set stroke color to smoothly transition through RGB spectrum
            float r = (float) (255 * Math.abs(Math.sin(angle + i * PConstants.PI / 4)));
            float g = (float) (255 * Math.abs(Math.sin(angle + i * PConstants.PI / 4 + PConstants.PI / 2)));
            float b = (float) (255 * Math.abs(Math.sin(angle + i * PConstants.PI / 4 + PConstants.PI)));
            rs.colorMode(PConstants.RGB);
            rs.stroke(r, g, b, hoopOpacities[i]);

            rs.noFill();
            rs.ellipse(rs.width / 2, rs.height / 2, hoopSizes[i], hoopSizes[i]);

            // Set stroke color for new hoop
            r = (float) (255 * Math.abs(Math.sin(angle + i * PConstants.PI / 4)));
            g = (float) (255 * Math.abs(Math.sin(angle + i * PConstants.PI / 4 + PConstants.PI / 2)));
            b = (float) (255 * Math.abs(Math.sin(angle + i * PConstants.PI / 4 + PConstants.PI)));
            rs.colorMode(PConstants.RGB);
            rs.stroke(r, g, b, newHoopOpacities[i]);
            rs.noFill();

            // Reset the new hoop when it goes out of camera
            if (newHoopSizes[i] >= PApplet.sqrt(PApplet.pow(rs.width, 2) + PApplet.pow(rs.height, 2)) + 200) {
                newHoopSizes[i] = 5.0f;
                newHoopOpacities[i] = 0.0f;
            }
            rs.ellipse(rs.width / 2, rs.height / 2, newHoopSizes[i], newHoopSizes[i]);
        }
        rs.popMatrix();

       
    }
}
