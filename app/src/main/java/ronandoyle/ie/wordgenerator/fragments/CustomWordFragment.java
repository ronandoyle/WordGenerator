package ronandoyle.ie.wordgenerator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ronandoyle.ie.wordgenerator.R;
import ronandoyle.ie.wordgenerator.Utilities;

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
        view.findViewById(R.id.custom_word_view)
                .setBackgroundColor(Utilities.getPastelColour());

        EditText newInputWord = (EditText) view.findViewById(R.id.et_custom_word);

        return view;
    }
}
