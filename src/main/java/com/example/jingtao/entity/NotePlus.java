package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotePlus {
    private UserInf sender;
    private UserInf accepter;
    private String message;
    private String time;
    private int look;
}
