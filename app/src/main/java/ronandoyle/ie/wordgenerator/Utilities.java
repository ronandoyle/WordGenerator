package ronandoyle.ie.wordgenerator;

import android.graphics.Color;

import java.util.Random;

/**
 * Contains handy utility methods.
 *
 */
public class Utilities {

    public static int generateRandomColor(int colour) {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // mix the color
        if (colour != 0) {
            red = (red + Color.red(colour)) / 2;
            green = (green + Color.green(colour)) / 2;
            blue = (blue + Color.blue(colour)) / 2;
        }

        return Color.rgb(red, green, blue);
    }

}
