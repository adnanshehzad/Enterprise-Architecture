package cs544.exercise19;

import cs544.sample.Car;
import cs544.sample.NoSuchResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @RequestMapping(value="/books", method=RequestMethod.POST )
    public String add(Book book) {
        bookService.add(book);
        return "redirect:/books";
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "bookDetail";
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
    public String update(Book book, @PathVariable int id) {
        bookService.update(id, book); // book.id already set by binding
        return "redirect:/books";
    }

    @RequestMapping(value="/books/delete", method=RequestMethod.POST)
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }


    @ExceptionHandler(value= NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }
}
