package com.edgar.biblia4.o.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgar.biblia4.o.models.libromodels;


@Repository
public interface libroRepositorio extends CrudRepository<libromodels, Integer> {
	Optional<libromodels> findByBookIdAndChapterAndVerse(int bookId, int chapter, int verse);
	Optional<libromodels> findByBookIdAndChapter(int bookId, int chapter);
    List<libromodels> findByBookIdAndChapterAndVerseBetween(int bookId, int chapter, int startVerse, int endVerse);
	 
}

