package com.example.jingtao;

import com.example.jingtao.autoimport.AutoImport;
import com.example.jingtao.autoimport.JS;
import com.example.jingtao.entity.Course;
import com.example.jingtao.entity.CoursePlus;
import com.example.jingtao.entity.Note;
import com.example.jingtao.entity.PostPlus;
import com.example.jingtao.mapper.CoursePlusMapper;
import com.example.jingtao.mapper.NoteMapper;
import com.example.jingtao.service.CourseService;
import com.example.jingtao.service.PostService;
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
    private PostService postService;

    @Test
    public void wasd() {
        //List<PostPlus> wasd = postService.getPagePostByOpenid("oUw7p5GBwO8DmwXj3YfeEl6uuq4s", 1, 10);
        List<PostPlus> wasd = postService.getFirstPagePostBySchool("山东大学", 1, 10);
        System.out.println(wasd);

        for (PostPlus postPlus : wasd) {
            System.out.println(postPlus);
        }
    }
}
