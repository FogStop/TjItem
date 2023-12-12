package cn.fog.tj.entity;

import lombok.Data;

@Data
public class Book {

    private Integer id;
    private String name;
    private Integer card;
    private String author;
    private Integer num;
    private String press;
    private String type;
    private String times;
}
