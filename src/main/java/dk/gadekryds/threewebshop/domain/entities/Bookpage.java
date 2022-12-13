package dk.gadekryds.threewebshop.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bookpage")
public class Bookpage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
