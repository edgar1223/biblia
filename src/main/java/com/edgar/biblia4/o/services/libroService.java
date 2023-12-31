package com.edgar.biblia4.o.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.biblia4.o.models.libromodels;
import com.edgar.biblia4.o.repositorio.LibroDAO;
import com.edgar.biblia4.o.repositorio.libroRepositorio;



@Service
public class libroService {
	  @Autowired
	  libroRepositorio libroRepo;
	  @Autowired
	  LibroDAO libroDAO;
	  public List<libromodels> obtenerlibro(){
		
		  return (List<libromodels>) libroRepo.findAll();		  
	  }
	  public Optional<libromodels> obtenerVersiculo(int bookId, int chapter, int verse) {
		    return libroRepo.findByBookIdAndChapterAndVerse(bookId, chapter, verse);
		}
	  public Optional<libromodels> obtenercapitulo(int bookId, int chapter) {
		    return libroRepo.findByBookIdAndChapter(bookId, chapter);
		}
	  public List<libromodels> obtenerRangoVersiculos(int bookId, int chapter, int startVerse, int endVerse) throws ClassNotFoundException {
	        return libroDAO.obtenerRangoVersiculos(bookId, chapter, startVerse, endVerse);
	    }
}
