package ronandoyle.ie.wordgenerator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.Random;

/**
 * Contains handy utility methods.
 *
 */
public class Utilities {

    /**
     * Gets the pastel colour of the
     * @return
     */
    public static int getPastelColour() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        int color = Color.rgb(red, green, blue);
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

    /**
     * Sets a custom typeface on the provided TextView.
     *
     * @param context A context.
     * @param textView A TextView to have a typeface set on.
     */
    public static void setCustomTypeface(Context context, TextView textView) {
        if (textView == null) {
            return;
        }
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),
                "fonts/theBubbleLetters.ttf");
        textView.setTypeface(typeface);
    }

}
