package ronandoyle.ie.wordgenerator;

import android.graphics.Color;

import java.util.Random;

/**
 * Contains handy utility methods.
 *
 */
public class Utilities {

    public static int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return Color.rgb(red, green, blue);
    }

    public static int getContrastVersionForColor() {
        int color = generateRandomColor();
        float[] hsv = new float[3];
        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color),
                hsv);
        if (hsv[2] < 0.5) {
            hsv[2] = 0.75f;
        } else {
            hsv[2] = 0.25f;
        }
        hsv[1] = hsv[1] * 0.75f;
        return Color.HSVToColor(hsv);
    }

}
