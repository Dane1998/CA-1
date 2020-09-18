package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Jokes.deleteAllJokes", query = "DELETE FROM Jokes"),
@NamedQuery(name = "Jokes.getAllJokes", query = "SELECT j FROM Jokes j"),
//TODO skal fikses skal kunne kun tage fat i en joke
@NamedQuery(name = "Jokes.getOneJokes", query = "SELECT j.id as id, j.punchline as punchline FROM Jokes j WHERE j.id = :id")

})
public class Jokes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String setup;
    private String punchline;

    public Jokes (String punchline, String setup) {
        this.setup = setup;
        this.punchline = punchline;
    }

    public Jokes() {
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    // TODO, delete this class, or rename to an Entity class that makes sense for what you are about to do
    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

}
