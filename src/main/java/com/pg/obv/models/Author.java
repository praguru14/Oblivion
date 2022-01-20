package com.pg.obv.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    public Author() {
    }

    public Author(int authorId, String fName, String lName) {
        this.authorId = authorId;
        this.fName = fName;
        this.lName = lName;
    }

    private String fName;
    private String lName;

    @OneToOne(mappedBy = "author")
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;

}
