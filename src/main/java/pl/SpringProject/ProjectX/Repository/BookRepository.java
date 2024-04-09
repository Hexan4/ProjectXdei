package pl.SpringProject.ProjectX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.SpringProject.ProjectX.Data.DataBook;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<DataBook, Long> {
    @Override
    List<DataBook> findAll();

    @Override
    Optional<DataBook> findById(Long aLong);

    @Override
    <S extends DataBook> List<S> saveAll(Iterable<S> entities);

    @Override
    void deleteById(Long aLong);

}