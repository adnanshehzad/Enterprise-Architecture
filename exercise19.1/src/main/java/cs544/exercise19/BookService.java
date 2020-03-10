package cs544.exercise19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public void add(Book book) {
        bookDao.add(book);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public Book get(int id) {
        return bookDao.get(id);
    }

    public void update(int id, Book book) {
        bookDao.update(id,book);
    }

    public void delete(int bookId) {
        bookDao.delete(bookId);
    }
}
