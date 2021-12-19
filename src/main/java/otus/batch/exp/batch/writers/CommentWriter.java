package otus.batch.exp.batch.writers;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import otus.batch.exp.entity.h2.CommentTo;
import otus.batch.exp.repository.h2.CommentsRepository;

import java.util.List;

@Component
public class CommentWriter implements ItemWriter<CommentTo> {


    private final CommentsRepository commentsRepository;

    public CommentWriter(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    @Transactional
    public void write(List<? extends CommentTo> list) {
        for (CommentTo comment : list) {
            commentsRepository.save(comment);
        }
    }
}
