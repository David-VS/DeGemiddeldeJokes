package be.ehb.debeterejokes.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class JokeViewModel extends AndroidViewModel {

    MutableLiveData<ArrayList<Joke>> jokeLiveData;

    public JokeViewModel(@NonNull Application application) {
        super(application);
        jokeLiveData = new MutableLiveData<>();
        setupJokes();
    }

    //Zou in 't echt uw api of db call zijn.
    private void setupJokes() {
        ArrayList<Joke> jokes = new ArrayList<>();
        jokes.add(new Joke("het is blauw en het weegt niet veel", "lichtblauw"));
        jokes.add(new Joke("het is groen en het weegt niet veel", "lichtgroen"));
        jokes.add(new Joke("het is geel en het weegt niet veel", "lichtgeel"));
        jokes.add(new Joke("het is wit en het staat in de hoek", "een gestrafte frigo"));
        jokes.add(new Joke("het is wit en het ontploft", "een boemkool"));
        jokes.add(new Joke("het is oranje en als het regent verdwijnt het", "de mannen van de gemeente"));
        jokes.add(new Joke("het is grijs en als het in uw oog vliegt zijt ge dood", "een vliegtuig"));
        jokeLiveData.setValue(jokes);
    }

    public void addJoke(Joke newJoke){
        ArrayList<Joke> jokes = jokeLiveData.getValue();
        jokes.add(newJoke);
        jokeLiveData.setValue(jokes);
    }

    public MutableLiveData<ArrayList<Joke>> getJokeLiveData() {
        return jokeLiveData;
    }
}
