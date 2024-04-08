package pl.SpringProject.ProjectX.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.SpringProject.ProjectX.Data.DataBook;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<DataBook> getAllBooks() {
        List<DataBook> books = new ArrayList<>();
        books.add(new DataBook(1L, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        books.add(new DataBook(2L, "1984", "George Orwell"));
        return books;
    }
}
