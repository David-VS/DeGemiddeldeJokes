package be.ehb.debeterejokes.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import be.ehb.debeterejokes.R;
import be.ehb.debeterejokes.data.Joke;
import be.ehb.debeterejokes.data.JokeViewModel;


public class NewJokeFragment extends Fragment {


    public NewJokeFragment() {
        // Required empty public constructor
    }

    public static NewJokeFragment newInstance() {
        NewJokeFragment fragment = new NewJokeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_joke, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JokeViewModel jokeViewModel = new ViewModelProvider(getActivity()).get(JokeViewModel.class);

        EditText setup = view.findViewById(R.id.et_new_setup);
        EditText punchline = view.findViewById(R.id.et_new_punchline);
        Button submit = view.findViewById(R.id.btn_new_submit);

        submit.setOnClickListener((View v) -> {
            String setupTxt = setup.getText().toString();
            String punchlineTxt = punchline.getText().toString();

            Joke newJoke = new Joke(setupTxt, punchlineTxt);
            jokeViewModel.addJoke(newJoke);

            Navigation.findNavController(view).navigateUp();
        });
    }
}