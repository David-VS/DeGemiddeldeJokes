package be.ehb.debeterejokes.data;

import java.io.Serializable;

public class Joke implements Serializable {
    String setup, punchline;

    public Joke(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }
}
