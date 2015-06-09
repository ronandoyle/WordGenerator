package ronandoyle.ie.wordgenerator.fragments;

import android.content.Context;
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
import ronandoyle.ie.wordgenerator.Utilities;


/**
 * A placeholder fragment containing a simple view.
 */
public class WordShowFragment extends Fragment {

    /**
     * Views.
     */
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    public WordShowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final Vibrator vibrator =
                (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        final TextView randomWordTextView = (TextView) rootView.findViewById(R.id.tv_word);
        Utilities.setCustomTypeface(getActivity(), randomWordTextView);

        rootView.setBackgroundColor(Utilities.getPastelColour());

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

                int bgColor = Utilities.getPastelColour();
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
        applyRandomWordAnimation();
    }

    /**
     * Applies an animation on the random word TextView.
     */
    private void applyRandomWordAnimation() {
        if (getView() != null) {
            TextView randomWordTextView = (TextView) getView().findViewById(R.id.tv_word);
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
            animation.setFillAfter(true);
            randomWordTextView.setAnimation(animation);
        }
    }
}
