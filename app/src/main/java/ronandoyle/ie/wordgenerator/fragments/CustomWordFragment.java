package ronandoyle.ie.wordgenerator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        final EditText newInputWord = (EditText) view.findViewById(R.id.et_custom_word);

        final Button displayNewWordButton = (Button) view.findViewById(R.id.btn_get_word);

        final TextView customWord = (TextView) view.findViewById(R.id.tv_custom_word);

        displayNewWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customWord.setVisibility(View.VISIBLE);
                Utilities.setCustomTypeface(getActivity(), customWord);
                customWord.setText(newInputWord.getText());

                newInputWord.setVisibility(View.GONE);
                displayNewWordButton.setVisibility(View.GONE);
            }
        });

        return view;
    }
}
