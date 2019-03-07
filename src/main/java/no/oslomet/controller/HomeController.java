package no.oslomet.controller;

import no.oslomet.model.Author;
import no.oslomet.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SessionFactory sessionFactory;

    @GetMapping({"/", "/list"})
    @Transactional
    public String list(Model model){
        List<Author> authors = getAllAuthors();
        List<Book> books = getAllBooks();
        model.addAttribute("authors", authors);
        model.addAttribute("books", books);
        return "list";
    }

    @RequestMapping("/addAuthor")
    @Transactional
    public String addAuthor(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "addAuthor";
    }

    @RequestMapping("/addBook")
    @Transactional
    public String addBook(Model model){
        Book book = new Book();
        List<Author> authors = getAllAuthors();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        return "addBook";
    }

    @PostMapping("/saveAuthor")
    @Transactional
    public String saveAuthor(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName,
                       @RequestParam("nationality") String nationality){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setNationality(nationality);
        saveAuthor(author);
        return "redirect:/list";
    }

    @PostMapping("/saveBook")
    @Transactional
    public String saveBook(@RequestParam("ISBN") Long ISBN,
                       @RequestParam("title") String title,
                       @RequestParam("releaseYear") String releaseYear,
                       @RequestParam("author") Long authorId){
        Book book = new Book();
        book.setISBN(ISBN);
        book.setTitle(title);
        book.setReleaseYear(releaseYear);
        book.setAuthor(getAuthorById(authorId));
        saveBook(book);
        return "redirect:/list";
    }

    @GetMapping("/editBook/{isbn}")
    @Transactional
    public String editBook(@PathVariable("isbn") String isbnParam, Model model){
        Long isbn = Long.parseLong(isbnParam);
        Book book = getBookByISBN(isbn);
        List<Author> authors = getAllAuthors();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        return "addBook";
    }

    @GetMapping("/deleteBook/{isbn}")
    @Transactional
    public String deleteBook(@PathVariable("isbn") String isbnParam) {
        Book book = getBookByISBN(Long.parseLong(isbnParam));
        deleteBook(book);
        return "redirect:/list";
    }


    // Hibernate CRUD Methods

    public void saveAuthor(Author author){
        sessionFactory.getCurrentSession().saveOrUpdate(author);
    }

    public List<Author> getAllAuthors(){
        return  sessionFactory.getCurrentSession().
                createCriteria(Author.class).list();
    }

    public Author getAuthorById(Long id){
        return sessionFactory.getCurrentSession().find(Author.class, id);
    }

    public void saveBook(Book book){
        sessionFactory.getCurrentSession().saveOrUpdate(book);
    }

    public List<Book> getAllBooks(){
        return  sessionFactory.getCurrentSession().
                createCriteria(Book.class).list();
    }

    public void deleteBook(Book book){
        sessionFactory.getCurrentSession().delete(book);
    }

    public Book getBookByISBN(Long ISBN){
        return sessionFactory.getCurrentSession().find(Book.class, ISBN);
    }
}
