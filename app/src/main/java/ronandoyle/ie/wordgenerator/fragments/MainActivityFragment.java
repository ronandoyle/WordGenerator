package ronandoyle.ie.wordgenerator.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Random;

import ronandoyle.ie.wordgenerator.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {



    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView randomWordTextView = (TextView) rootView.findViewById(R.id.tv_word);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/theBubbleLetters.ttf");
        randomWordTextView.setTypeface(font);

        final Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);;

        rootView.setBackgroundColor(generateRandomColor());

        randomWordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] wordArray = getResources().getStringArray(R.array.random_word);
                String randomWord = wordArray[new Random().nextInt(wordArray.length)];
                while (randomWord.equals(randomWordTextView.getText())) {
                    randomWord = wordArray[new Random().nextInt(wordArray.length)];
                }
                randomWordTextView.setText(randomWord);

                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.wobbler);
                animation.setDuration(100);
                animation.setFillAfter(true);
                randomWordTextView.startAnimation(animation);

                int bgColor = getContrastVersionForColor(generateRandomColor());
                randomWordTextView.setBackgroundColor(bgColor);
                rootView.setBackgroundColor(bgColor);

                vibrator.vibrate(50);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getView() != null) {
            TextView randomWordTextView = (TextView) getView().findViewById(R.id.tv_word);
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
            animation.setFillAfter(true);
            randomWordTextView.setAnimation(animation);
        }
    }

    public int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return Color.rgb(red, green, blue);
    }

    public static int getContrastVersionForColor(int color) {
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
