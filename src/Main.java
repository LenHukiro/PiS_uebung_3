import processing.core.PApplet;
import views.BaseView;

public class Main {

/*  0  1  2  3     3  7 11 15     +12 +7  +2  -3  -> -5
    4  5  6  7     2  6 10 14     +9  +4  -1  -6  -> -5
    8  9 10 11     1  5  9 13     +6  +1  -4  -9  -> -5
   12 13 14 15     0  4  8 12     +3  -2  -7  -12 -> -5
                                   |   |   |   |
                                   V   V   V   V
                                  -3  -3  -3  -3
 */

    public static void main(String... args) {
        PApplet.runSketch(new String[]{""}, new BaseView());
    }
}