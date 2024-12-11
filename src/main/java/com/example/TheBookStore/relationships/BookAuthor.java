package com.example.TheBookStore.relationships;

import com.example.TheBookStore.models.Author;
import com.example.TheBookStore.models.Book;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "books_have_authors")
@IdClass(BookAuthor.BookAuthorId.class)
public class BookAuthor {

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Composite Key Class
    public static class BookAuthorId implements Serializable {
        private Long author;
        private Long book;

        public BookAuthorId() {}

        public BookAuthorId(Long author, Long book) {
            this.author = author;
            this.book = book;
        }

        public Long getAuthor() {
            return author;
        }

        public void setAuthor(Long author) {
            this.author = author;
        }

        public Long getBook() {
            return book;
        }

        public void setBook(Long book) {
            this.book = book;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BookAuthorId that = (BookAuthorId) o;
            return Objects.equals(author, that.author) &&
                    Objects.equals(book, that.book);
        }

        @Override
        public int hashCode() {
            return Objects.hash(author, book);
        }
    }
}
