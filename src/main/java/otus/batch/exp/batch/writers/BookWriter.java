package otus.batch.exp.batch.writers;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import otus.batch.exp.entity.h2.AuthorTo;
import otus.batch.exp.entity.h2.BookTo;
import otus.batch.exp.entity.h2.GenreTo;
import otus.batch.exp.repository.h2.AuthorsRepository;
import otus.batch.exp.repository.h2.BooksRepository;
import otus.batch.exp.repository.h2.GenresRepository;

import java.util.List;

@Component
public class BookWriter implements ItemWriter<BookTo> {

    private final AuthorsRepository authorsRepository;
    private final GenresRepository genresRepository;
    private final BooksRepository booksRepository;

    public BookWriter(AuthorsRepository authorsRepository, GenresRepository genresRepository, BooksRepository booksRepository) {
        this.authorsRepository = authorsRepository;
        this.genresRepository = genresRepository;
        this.booksRepository = booksRepository;
    }

    @Override
    @Transactional
    public void write(List<? extends BookTo> list) {
        for (BookTo bookTo : list) {
            AuthorTo authorTo = authorsRepository.save(bookTo.getAuthorTo());
            GenreTo genreTo = genresRepository.save(bookTo.getGenreTo());
            BookTo book = new BookTo(bookTo.getId(), bookTo.getName(), authorTo, genreTo);
            booksRepository.save(book);
        }
    }

}
