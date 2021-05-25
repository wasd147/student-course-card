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
    public DataSource dataSource;

    @Test
    void contextLoads() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        String time = LocalDateTime.now().format(formatter);
//        //statement.execute("insert into time (id,timestamp) values (11," + time + ")");
//        System.out.println(time);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String sql = "select major" +
                    " from major" +
                    " where college='软件学院'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("major"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Autowired
    private NoteMapper noteMapper;

    @Test
    public void test() {

        System.out.println(new Date());
        noteMapper.insert(new Note("xinyi", "wasd", "wasd", new Date(), 0));
        //noteMapper.hasLook(new Note("jingtao", "xinyi", "wasd", new Date(), 0));
    }

    @Autowired
    private PostService postService;

    @Test
    public void test1() {
//        List<PostPlus> wasd = postService.getPostByOpenid("xinyi");
//        System.out.println(postService.getPostBySchool("山东大学"));
//        System.out.println(wasd);
        System.out.println(postService.getAllPost());
    }

    @Test
    public void wasd() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.subList(0, 1));
        System.out.println(list.subList(0, 9));
        System.out.println(list.subList(0, 10));
        System.out.println(list.subList(3, 5));

    }


    @Autowired
    private CourseService courseService;

    @Test
    public void qqqq() {
        //courseService.importCourseByOpenidAndStudentId("oNTNQ5EVBLG1qFO2QfNGEm6hcdrk","201900301184","911ABCabc+");
        //System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
//        System.out.println(Class.class.getClass().getResource("/").getPath());
        ScriptEngineManager manager = new ScriptEngineManager();
        //获取一个指定的名称的脚本引擎
        ScriptEngine engine = manager.getEngineByName("js");
        try {

            //获取当前类的所在目录的路径
            //String path = ExecuteScript.class.getResource("").getPath();
            //String path = "E:\\源码\\微信小程序开发\\java后台\\src\\main\\java\\com\\example\\jingtao\\autoimport\\";
            //String path = Class.class.getClass().getResource("/").getPath();
            // 获取classpath的绝对值路径，有中文需要解码路径，不然输出的是乱码的
            String basePath = null;

            try {
                basePath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource("").getPath(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // FileReader的参数为所要执行的js文件的路径
            engine.eval(new FileReader(basePath + "des.js"));
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                //从脚本引擎中返回一个给定接口的实现
                JS js = invocable.getInterface(JS.class);
                //执行指定的js方法
                //System.out.println(js.strEnc("20192216128620011011ke" + lt, "1", "2", "3"));//
                String rsa = js.strEnc("201900301184911ABCabc+", "1", "2", "3");
                System.out.println(rsa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    //private CourseService courseService;
    private CoursePlusMapper coursePlusMapper;
    @Test
    public void wwasd() {
        List<CoursePlus> list = coursePlusMapper.selectByOpenidAndWeeks("oUw7p5GBwO8DmwXj3YfeEl6uuq4s", "1");
        System.out.println(list);
        List<Course> courses = courseService.selectByOpenidAndWeeks("oUw7p5GBwO8DmwXj3YfeEl6uuq4s", "1");
        System.out.println(courses);
    }
}
