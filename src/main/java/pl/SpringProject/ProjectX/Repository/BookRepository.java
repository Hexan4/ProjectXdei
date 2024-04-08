package pl.SpringProject.ProjectX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.SpringProject.ProjectX.Data.DataBook;

public interface BookRepository extends JpaRepository<DataBook, Long> {

}