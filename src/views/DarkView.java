package views;

import processing.core.PApplet;

public class DarkView  extends BaseView {
    public static void main(String... args) {
        PApplet.runSketch(new String[]{""}, new DarkView());
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
