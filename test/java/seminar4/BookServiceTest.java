package seminar4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setup() {
        // вместо реальной БД подсталяем FAKE - класс InMemoryBookRepository()
        bookService = new BookService(new InMemoryBookRepository());
    }

    @Test
    void findBookById() {
        // Создаём mock-щбъект класса BookService
        BookService mockedBookService = Mockito.mock();

        // создаём контрольный экземпляр класса Book, с которым будем сравнивать
        // результат работы функции findBookById()
        Book bookControl = new Book("1", "Book1", "Author1");

        // создаём переменную содержащую значение параметра id для передачи в функцию findBookById()
        String param = "1";

        // пробуем вызвать метод findBookById() у mock-щбъекта и сохранить результат в
        // экземпляре класса Book
        // так как mock-щбъект не имеет реализацию метода findBookById(), то вернётся null
        Book book1 = mockedBookService.findBookById(param);

        // подтверждаем, что в предыдущем шаге был получен null
        assertThat(book1).isEqualTo(null);

        // изменяем поведение mock-щбъекта, теперь при вызове функции findBookById() будет
        // вызываться реальная функция findBookById() объекта BookService
        when(mockedBookService.findBookById(param)).thenReturn(bookService.findBookById(param));

        // сохраняем результат работы функции в переменную book2, для того чтобы сравнить результат
        // работы функции с контрольным значением bookControl, совпадение подтвердит корректноть работы функции
        Book book2 = mockedBookService.findBookById(param);

        // сравниваем результат выборки и контрольное значение
        assertThat(book2.compareTo(bookControl)).isEqualTo(0);

        // проверяем, что функция findBookById() во время работы данного теста была вызвана 2 раза
        verify(mockedBookService, times(2)).findBookById(param);
    }

    @Test
    void findAllBooks() {
        // Создаём заглушку типа SPY
        BookService mockBookService = Mockito.spy(bookService);

        // заглушка типа SPY вызывает реальные методы объекта
        // поэтому в список books мы получим всё содержимое InMemoryBookRepository
        List<Book> books = mockBookService.findAllBooks();

        // сравниваем размер поолученного списка с известным размером InMemoryBookRepository
        assertThat(books.size()).isEqualTo(2);
   }
}