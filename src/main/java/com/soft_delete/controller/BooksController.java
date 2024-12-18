package com.soft_delete.controller;


import com.soft_delete.entity.Books;
import com.soft_delete.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BooksController {

    @Autowired
    private BooksService booksService;


    @PostMapping("/create")
    public Books createOne(@RequestBody Books books){
        return booksService.create(books);
    }

    @GetMapping("/books")
    public List<Books> getAllBooks(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted){
        return booksService.booksList(isDeleted);
    }

    @DeleteMapping("/delete/{id}")
    public void removeOne(@PathVariable("id") String id){
        booksService.deleteOne(id);
    }

}
