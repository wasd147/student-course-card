package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private String sender;
    private String accepter;
    private String message;
    private Date time;
    private int look;
}