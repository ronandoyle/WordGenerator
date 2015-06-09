package ronandoyle.ie.wordgenerator.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import ronandoyle.ie.wordgenerator.R;

/**
 * TODO Update this line
 *
 */
public class CustomWordFragment extends Fragment {

    public static final String TAG = "CustomWordFragment";

    public CustomWordFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_custom_word, container, false);

        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        int randomColour = Color.rgb(
                red, green, blue);

        view.findViewById(R.id.custom_word_view)
                .setBackgroundColor(generateRandomColor());

        EditText newInputWord = (EditText) view.findViewById(R.id.et_custom_word);


        return view;
    }

    public int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // mix the color
//        if (colour != 0) {
            red = (red) / 2;
            green = (green) / 2;
            blue = (blue) / 2;
//        }

        return Color.rgb(red, green, blue);
    }
}
