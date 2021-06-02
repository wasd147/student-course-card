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
    private NoteService noteService;

    @Test
    public void test() {

        List<UserInf> list = new ArrayList<>();
        list.add(new UserInf("wasd", "wasd", "wasd"));
        System.out.println(list.contains(new UserInf("wasd", "wasd", "wasd")));

        list.remove(new UserInf("wasd", "wasd", "wasd"));
        System.out.println(list);
        System.out.println("++++++++++++++++++++");
        List<String> stringList = new ArrayList<>();
        stringList.add("wasd");
        System.out.println(list.contains("wasd"));
        stringList.remove("wasd");
        System.out.println(stringList);
        System.out.println("++++++++++++++");
        Map<UserInf, Object> map = new HashMap<>();
        map.put(new UserInf("wasd", "wasd", "wasd"), "asbbsdbv");
        System.out.println(map.containsKey(new UserInf("wasd", "wasd", "wasd")));
        map.remove(new UserInf("wasd", "wasd", "wasd"));
        System.out.println(map);
        System.out.println(new UserInf("wasd", "wasd", "wasd").equals(new UserInf("wasd", "wasd", "wasd")));
        System.out.println(new UserInf("wasd", "wasd", "wasd") == new UserInf("wasd", "wasd", "wasd"));

    }

    @Test
    public void test1() {
        List<Contacter> xinyi = noteService.getContacter("oUw7p5GBwO8DmwXj3YfeEl6uuq4s");
        System.out.println("+++++++++++++++++++++");
        List<NotePlus> wasd = noteService.getNotes("oUw7p5GBwO8DmwXj3YfeEl6uuq4s", xinyi.get(1).getOpenid());
        for (int i = 0; i < wasd.size(); i++) {
            System.out.println(wasd.get(i));
        }

    }

}
