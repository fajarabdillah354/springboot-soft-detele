package com.soft_delete.service;

import com.soft_delete.entity.Books;
import com.soft_delete.repository.BooksRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private EntityManager entityManager;

    //create books
    public Books create(Books books){
        return booksRepository.save(books);
    }

    public List<Books> booksList(boolean isDeleted){
//        return booksRepository.findAll();
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("deletedFilter").setParameter("isDeleted", isDeleted);
        List<Books> books = booksRepository.findAll();
        session.disableFilter("deletedFilter");
        return books;

    }

    public void deleteOne(String id){
        booksRepository.deleteById(id);
    }


}
