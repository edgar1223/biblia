package com.edgar.biblia4.o.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="verses")
public class libromodels {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private int bookId;
	
	private int chapter;
	private int verse;
	private String text;
	
	public libromodels() {}
	public libromodels(int book_id, int chapter, int verse, String text) {
		this.bookId = book_id;
		this.chapter = chapter;
		this.verse = verse;
		this.text = text;
	}


	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}


	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	/**
	 * @return the chapter
	 */
	public int getChapter() {
		return chapter;
	}

	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	/**
	 * @return the verse
	 */
	public int getVerse() {
		return verse;
	}

	/**
	 * @param verse the verse to set
	 */
	public void setVerse(int verse) {
		this.verse = verse;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}
