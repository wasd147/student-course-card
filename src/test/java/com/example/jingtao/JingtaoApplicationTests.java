package com.example.jingtao;

import com.example.jingtao.autoimport.AutoImport;
import com.example.jingtao.autoimport.JS;
import com.example.jingtao.contrller.PostController;
import com.example.jingtao.entity.*;
import com.example.jingtao.mapper.CoursePlusMapper;
import com.example.jingtao.mapper.NoteMapper;
import com.example.jingtao.service.CourseService;
import com.example.jingtao.service.PostService;
import com.example.jingtao.service.SchoolNewsService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class JingtaoApplicationTests {
    @Autowired
    private SchoolNewsService schoolNewsService;


    @Test
    public void wasd() {

    }
}
