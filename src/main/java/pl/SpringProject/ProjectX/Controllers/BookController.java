package pl.SpringProject.ProjectX.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.SpringProject.ProjectX.Data.DataBook;
import pl.SpringProject.ProjectX.Repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Read
    @GetMapping
    public List<DataBook> getAllBooks() {
        return bookRepository.findAll();
    }
    //Create
    @PostMapping
    public ResponseEntity<DataBook> createBook(@RequestBody DataBook book){
        DataBook savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataBook> getBookById(@PathVariable Long id){
        Optional<DataBook> book = bookRepository.findById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<DataBook> updateBook(@PathVariable Long id, @RequestBody DataBook bookDetails){
        Optional<DataBook> bookData = bookRepository.findById(id);

        if (bookData.isPresent()){
            DataBook updatedBook = bookData.get();
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setAuthor(bookDetails.getAuthor());
            bookRepository.save(updatedBook);
            return new ResponseEntity<>(updatedBook,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id){
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}