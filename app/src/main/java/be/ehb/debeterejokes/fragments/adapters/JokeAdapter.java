package be.ehb.debeterejokes.fragments.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.debeterejokes.R;
import be.ehb.debeterejokes.data.Joke;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    class JokeViewHolder extends RecyclerView.ViewHolder{

        final TextView tvSetup, tvPunchLine;
        final CardView row;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_row_setup);
            tvPunchLine = itemView.findViewById(R.id.tv_row_punchline);
            row = itemView.findViewById(R.id.row_container);

            row.setOnClickListener((View v) -> {
                Joke currentJoke = items.get(getAdapterPosition());
                Bundle data = new Bundle();
                data.putSerializable("details", currentJoke);

                Navigation.findNavController(itemView).navigate(R.id.action_jokelistFragment_to_detailsFragment, data);
            });
        }
    }

    ArrayList<Joke> items;

    public JokeAdapter() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Joke> getItems() {
        return items;
    }

    public void setItems(ArrayList<Joke> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_joke, parent, false);
       return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke currentItem = items.get(position);
        holder.tvSetup.setText(currentItem.getSetup());
        holder.tvPunchLine.setText(currentItem.getPunchline());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
