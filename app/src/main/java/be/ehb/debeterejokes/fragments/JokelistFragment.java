package be.ehb.debeterejokes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.debeterejokes.R;
import be.ehb.debeterejokes.data.Joke;
import be.ehb.debeterejokes.data.JokeViewModel;
import be.ehb.debeterejokes.fragments.adapters.JokeAdapter;

public class JokelistFragment extends Fragment {

    public JokelistFragment() {
    }

    public static JokelistFragment newInstance(){
        return new JokelistFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jokelist, container, false);

        RecyclerView rvJokes = view.findViewById(R.id.rv_jokes);
        JokeAdapter jokeAdapter = new JokeAdapter();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        JokeViewModel jokeViewModel = new ViewModelProvider(getActivity()).get(JokeViewModel.class);

        rvJokes.setAdapter(jokeAdapter);
        rvJokes.setLayoutManager(manager);

        jokeViewModel.getJokeLiveData().observe(getActivity(), new Observer<ArrayList<Joke>>() {
            @Override
            public void onChanged(ArrayList<Joke> jokes) {
                jokeAdapter.setItems(jokes);
            }
        });

        return view;
    }

}
