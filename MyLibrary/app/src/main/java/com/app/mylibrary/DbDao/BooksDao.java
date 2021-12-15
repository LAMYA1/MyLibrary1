package com.app.mylibrary.DbDao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.app.mylibrary.Modle.Books;

import java.util.List;

@Dao
public interface BooksDao {

    @Insert(entity = Books.class, onConflict = OnConflictStrategy.REPLACE)
    long addNewBooks(Books books);

    @Query("SELECT DISTINCT * FROM books")
    List<Books> getAllBooks();

    @Query("delete from books")
    void deleteAllBooks();

}
