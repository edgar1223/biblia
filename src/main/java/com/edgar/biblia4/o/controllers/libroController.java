package com.edgar.biblia4.o.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.biblia4.o.models.libromodels;
import com.edgar.biblia4.o.services.libroService;



@RestController
@RequestMapping("/biblia")
public class libroController {
	@Autowired
	libroService libroSer;
	
    @GetMapping("/todos")
	public List<libromodels> obtenerlibros(){
		return  libroSer.obtenerlibro();
	}
	   @GetMapping("/books/{bookId}/{chapter}/{verse}")
	    public ResponseEntity<libromodels> obtenerVersiculo(
	            @PathVariable int bookId,
	            @PathVariable int chapter,
	            @PathVariable int verse) {
	        
	    	  Optional<libromodels> versiculo = libroSer.obtenerVersiculo(bookId, chapter, verse);

	          return versiculo
	                  .map(ResponseEntity::ok)
	                  .orElse(ResponseEntity.notFound().build());
	    }
	    @GetMapping("/capitulo/{bookId}/{chapter}")
	    public ResponseEntity<List<libromodels>> obtenerCap(
	            @PathVariable int bookId,
	            @PathVariable int chapter) throws ClassNotFoundException {
	        
	    	List<libromodels> versiculo = libroSer.obtenercapitulo(bookId, chapter);
	          return ResponseEntity.ok(versiculo);
	    }
	    @GetMapping("/books/{bookId}/{chapter}/{startVerse}/{endVerse}")
	    public ResponseEntity<List<libromodels>> obtenerRangoVersiculos(
	            @PathVariable int bookId,
	            @PathVariable int chapter,
	            @PathVariable int startVerse,
	            @PathVariable int endVerse) throws ClassNotFoundException {

	        List<libromodels> versiculos = libroSer.obtenerRangoVersiculos(bookId, chapter, startVerse, endVerse);

	        return ResponseEntity.ok(versiculos);
	    }
	    @GetMapping("/numchapter/{bookId}")
	    public ResponseEntity<Integer> obteneNumcap(
	            @PathVariable int bookId
	            ) throws ClassNotFoundException {

	       int  versiculos = libroSer.obtenerNumeroCapitulos(bookId);

	        return ResponseEntity.ok(versiculos);
	    }
	    @GetMapping("/books/rango/{bookId}/{startchapter}/{endchapter}")
	    public ResponseEntity<List<libromodels>> obtenerRangocapitlos(
	            @PathVariable int bookId,
	            @PathVariable int startchapter,
	            @PathVariable int endchapter
	            ) throws ClassNotFoundException {

	        List<libromodels> versiculos = libroSer.obtenerRangoCapitulos(bookId, startchapter, endchapter);

	        return ResponseEntity.ok(versiculos);
	    }
	    @GetMapping("/book/{bookId}")
	    public ResponseEntity<List<libromodels>> obtenercapitlos(
	            @PathVariable int bookId
	            
	            ) throws ClassNotFoundException {

	        List<libromodels> versiculos = libroSer.obtenerCapitulo(bookId);

	        return ResponseEntity.ok(versiculos);
	    }
	    
	    @GetMapping("/book/buscar/{frase}")
	    public ResponseEntity<List<libromodels>> buscarVersiculosConPalabra(
	            @PathVariable String frase
	            
	            ) throws ClassNotFoundException {

	        List<libromodels> versiculos = libroSer.buscarVersiculosConPalabra(frase);

	        return ResponseEntity.ok(versiculos);
	    }
}