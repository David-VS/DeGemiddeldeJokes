package be.ehb.debeterejokes.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.ehb.debeterejokes.R;
import be.ehb.debeterejokes.data.Joke;


public class DetailsFragment extends Fragment {

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance() {
        DetailsFragment fragment = new DetailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Joke jokeDetails = (Joke) getArguments().getSerializable("details");

        TextView setup = view.findViewById(R.id.tv_details_setup);
        TextView punchline = view.findViewById(R.id.tv_details_punchline);

        setup.setText(jokeDetails.getSetup());
        punchline.setText(jokeDetails.getPunchline());
    }
}