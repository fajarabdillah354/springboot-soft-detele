package com.soft_delete.repository;

import com.soft_delete.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, String> {


}
