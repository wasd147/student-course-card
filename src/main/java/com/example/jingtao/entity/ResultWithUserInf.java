package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultWithUserInf {
    private Object data;
    private UserInf userInf;

}
