package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends LibraryPrototype {
    private String name;
    private Set<Book> listBooks = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getListBooks() {
        return listBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @Override           <-- generated by Alt+Insert
     * <p>
     * return "Library{" +
     * "name='" + name + '\'' +
     * ", books=" + books +
     * '}';
     */

    @Override
    public String toString() {
        String s = "Library [" + name + "]\n";
        for (Book book : listBooks) {
            s = s + book.toString() + "\n";
        }
        return s;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.listBooks = new HashSet<>();
        for (Book book : listBooks) {
            Book clonedBook = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
            listBooks.add(clonedBook);
        }
        return clonedLibrary;
    }
}
