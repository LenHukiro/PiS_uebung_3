package views;

import processing.core.PApplet;

/**
 * Dark themed view of the game
 */
public class DarkView  extends BaseView {
    /**
     * The entry point of the application
     *
     * @param args the userinput arguments
     */
    public static void main(String... args) {
        PApplet.runSketch(new String[]{""}, new DarkView());
    }

    /**
     * Darkens the color scheme of the game
     */
   @Override
    protected void addColorScheme(){
    background(color(0x404258));
    colorMode(RGB,71, 78, 104);
   }
}
