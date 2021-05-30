package com.example.jingtao;

import com.example.jingtao.autoimport.AutoImport;
import com.example.jingtao.autoimport.JS;
import com.example.jingtao.contrller.PostController;
import com.example.jingtao.entity.*;
import com.example.jingtao.mapper.CoursePlusMapper;
import com.example.jingtao.mapper.NoteMapper;
import com.example.jingtao.mapper.UserInfMapper;
import com.example.jingtao.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.sql.DataSource;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.*;
import java.util.*;
import java.util.Date;

@SpringBootTest
class JingtaoApplicationTests {
    @Autowired
    private SchoolNewsService schoolNewsService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserInfService userInfService;

    @Test
    public void wasd() {
        Map<UserInf, List<NotePlus>> map = noteService.getNotes("oUw7p5GBwO8DmwXj3YfeEl6uuq4s");
        for (UserInf userInf : map.keySet()) {
            for (NotePlus notePlus : map.get(userInf)) {
                System.out.println(notePlus);
            }
            System.out.println("--------------------------------------");
        }

    }

}
