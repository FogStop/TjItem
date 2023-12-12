package cn.fog.tj.controller;

import cn.fog.tj.entity.Book;
import cn.fog.tj.entity.JsonResult;
import cn.fog.tj.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public JsonResult getAll(){
//        System.out.println(111);
        List<Book> list = bookService.list();
        return JsonResult.ok(list);
    }
}
