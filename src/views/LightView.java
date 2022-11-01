package views;

import processing.core.PApplet;

public class LightView extends BaseView {

    public static void main(String... args) {
        PApplet.runSketch(new String[]{""}, new LightView());
    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(27);
        noStroke();
        background(color(179, 189, 214));
        colorMode(HSB, 360, 100, 100);

        controller.random_tile();
        controller.random_tile();
        show();
    }
}
