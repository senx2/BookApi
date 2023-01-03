package com.song.app.rest.Repo;

import com.song.app.rest.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(
            value="SELECT b.isbn, b.genre, b.price, b.title, b.year " +
                    "FROM books b INNER JOIN book_authors a on b.isbn = a.isbn " +
                    "WHERE (a.name = :name AND a.birthday = :birthday) " +
                    "OR b.title = :title",
            nativeQuery = true)
    List<Book> findByAuthorsOrTitle(@Param("name") String name, @Param("birthday") String birthday,
                                    @Param("title") String title);
}
