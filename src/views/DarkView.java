package views;

import processing.core.PApplet;

public class DarkView  extends BaseView {
    public static void main(String... args) {
        PApplet.runSketch(new String[]{""}, new DarkView());
    }


   @Override
    protected void addColorScheme(){
    background(color(0x404258));
    colorMode(RGB,71, 78, 104);
   }
}
