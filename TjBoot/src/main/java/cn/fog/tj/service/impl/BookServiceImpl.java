package cn.fog.tj.service.impl;

import cn.fog.tj.entity.Book;
import cn.fog.tj.mapper.BookMapper;
import cn.fog.tj.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
}
