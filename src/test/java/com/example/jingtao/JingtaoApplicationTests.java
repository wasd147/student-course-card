package com.example.jingtao;

import com.example.jingtao.autoimport.AutoImport;
import com.example.jingtao.entity.Note;
import com.example.jingtao.entity.PostPlus;
import com.example.jingtao.mapper.NoteMapper;
import com.example.jingtao.service.CourseService;
import com.example.jingtao.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
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
        courseService.importCourseByOpenidAndStudentId("oNTNQ5EVBLG1qFO2QfNGEm6hcdrk","201900301184","911ABCabc+");
    }
}
