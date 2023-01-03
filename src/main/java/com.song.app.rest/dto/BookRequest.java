package com.song.app.rest.dto;

import com.song.app.rest.Models.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookRequest {

    private Book book;
}
