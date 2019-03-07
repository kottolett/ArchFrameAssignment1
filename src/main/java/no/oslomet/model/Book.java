package no.oslomet.model;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

    private Long ISBN;
    private String title;
    private String releaseYear;
    private Author author;

    public Book() { }

    public Book(Long ISBN, String title, String releaseYear, Author author) {
        this.ISBN = ISBN;
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
    }

    @Id
    public Long getISBN() { return ISBN; }

    public void setISBN(Long ISBN) { this.ISBN = ISBN; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Author.class)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
