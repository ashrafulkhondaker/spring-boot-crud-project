package com.example.cruddemo;

import org.junit.jupiter.api.Test;
import com.example.cruddemo.controller.BookController;
import com.example.cruddemo.model.Books;
import com.example.cruddemo.service.BookService;
import com.example.cruddemo.service.BookServiceImpl;
import org.hibernate.sql.ast.tree.expression.CaseSimpleExpression;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookServiceMock;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new BookController(bookServiceMock)).build();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        Books book1 = new Books(1, "Book 1", "Author 1", 100.00);
        Books book2 = new Books(2, "Book 2", "Author 2", 200.00);
        List<Books> bookList = Arrays.asList(book1, book2);

        when(bookServiceMock.getAllBooks()).thenReturn(bookList);

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Book 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author").value("Author 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Book 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].author").value("Author 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(200));
    }

    @Test
    public void testGetById() throws Exception {
        Books books = new Books(1,"Java EE", "Sam", 100.09);

        when(bookServiceMock.getById(1)).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1").contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Java EE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Sam"));
    }


}
