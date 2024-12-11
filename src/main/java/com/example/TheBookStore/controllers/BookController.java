package com.example.TheBookStore.controllers;


import com.example.TheBookStore.models.Book;
import com.example.TheBookStore.models.Publisher;
import com.example.TheBookStore.repositories.AuthorRepository;
import com.example.TheBookStore.repositories.BookRepository;
import com.example.TheBookStore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "books/form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book, @RequestParam Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid publisher ID: " + publisherId));


        book.setPublisher(publisher);


        bookRepository.save(book);

        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).orElse(null));
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "books/form";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book, @RequestParam Long publisherId) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));


        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setGenre(book.getGenre());
        existingBook.setPrice(book.getPrice());
        existingBook.setStockQuantity(book.getStockQuantity());


        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid publisher ID: " + publisherId));
        existingBook.setPublisher(publisher);


        bookRepository.save(existingBook);

        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
