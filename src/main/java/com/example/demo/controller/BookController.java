package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Book;
import com.example.demo.entity.MyBookList;
import com.example.demo.service.BookService;
import com.example.demo.service.MyBookListService;

@Controller
public class BookController {
@Autowired
private BookService service;
@Autowired
private MyBookListService myBookService;
@GetMapping("/home")
public String home()
{
	return "Home";
}

@GetMapping("/book_register")
public String bookRegister()
{
	return "bookRegister";
}
@GetMapping("/available_books")
public ModelAndView getAllBook()
{
	List<Book>list=service.getAllBook();
	return new ModelAndView("bookList","book",list);
}
@GetMapping("/delete")
public ModelAndView getAlldata()
{
	List<Book>list=service.getAlldata();
	return new ModelAndView("delete","book",list);
}
@PostMapping("/save")
public String addBook(@ModelAttribute Book b)
{
	service.save(b);
	return "redirect:/available_books";
}

@GetMapping("/my_books")
public String getMyBooks(Model model)
{
	List<MyBookList>list=myBookService.getAllMyBooks();
	model.addAttribute("book", list);
	return "myBooks";
}
@RequestMapping("/mylist/{id}")
public String getMyList(@PathVariable("id")int id) {
	Book b=service.getBookById(id);
	MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getRating(),b.getLink());
	myBookService.saveMyBooks(mb);
	return "redirect:/my_books";
	}
@RequestMapping("/editBook/{id}")
public String editBook(@PathVariable("id") int id,Model model)
{
	Book b=service.getBookById(id);
	model.addAttribute("book",b);
	return "bookEdit";
}

@RequestMapping("/deleteBook/{id}")
public String deleteBook(@PathVariable("id")int id)
{
	service.deleteById(id);
	return "redirect:/available_books";
}

@GetMapping("/AboutUs")
public String About()
{
	return "aboutus";
}

}

