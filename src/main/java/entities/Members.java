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
@NamedQuery(name = "Members.deleteAllMembers", query = "DELETE FROM Members"),
@NamedQuery(name = "Members.getAllMembers", query = "SELECT m FROM Members m")
})
public class Members implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;
    private String name;
    private String favoriteTvshows;
    private String email;
    private String test;
    public Members(String name, String favoriteTvshows, String email) {
        this.name = name;
        this.favoriteTvshows = favoriteTvshows;
        this.email = email;
    }

    public Members() {
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    // TODO, delete this class, or rename to an Entity class that makes sense for what you are about to do
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteTvshows() {
        return favoriteTvshows;
    }

    public void setFavoriteTvshows(String favoriteTvshows) {
        this.favoriteTvshows = favoriteTvshows;
    }

    
      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
