
package DTO;

import entities.Jokes;

public class JokeDTO {
    
    private Long id;
    private String setup;
    private String punchline;

    public JokeDTO(Jokes j) {
        this.id = j.getID();
        this.setup = j.getSetup();
        this.punchline = j.getPunchline();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
