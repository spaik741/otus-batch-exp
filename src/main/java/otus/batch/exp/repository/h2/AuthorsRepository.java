package otus.batch.exp.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.batch.exp.entity.h2.AuthorTo;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<AuthorTo, Long> {

    @Override
    List<AuthorTo> findAll();




}
