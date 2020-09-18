package DTO;

import entities.Jokes;
import java.util.ArrayList;
import java.util.List;

public class JokesDTO {

    private List<JokeDTO> all = new ArrayList();

    public JokesDTO(List<Jokes> jokesList) {
        for (Jokes j : jokesList) {
            all.add(new JokeDTO(j));
        }
    }

    public List<JokeDTO> getAll() {
        return all;
    }
}
