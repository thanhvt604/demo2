package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Books {
    @Id
    @Column
    private int bookId;
    @Column
    private String bookName;

    @Column
    private String author;
    @Column
    private int price;



}
