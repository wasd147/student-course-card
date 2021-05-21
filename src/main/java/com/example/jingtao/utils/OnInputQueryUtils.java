package com.example.jingtao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OnInputQueryUtils {
    @Autowired
    private DataSource dataSource;

    public List<String> querySchool(String s) {
        //s必须是一个字符串 不能为空 不然会查出所有结果
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        String sql = "select distinct school" +
                " from major" +
                " where school like" +
                " '%" + s + "%'";
        // System.out.println(sql);
        try {
            Connection connection = dataSource.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, s);
//
//             resultSet = preparedStatement.executeQuery();
            resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getString("school"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<String> queryCollege(String school, String college) {
        //college必须是一个字符串 不能为空 不然会查出所有结果
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        String sql = "select distinct college" +
                " from major" +
                " where college like" +
                " '%" + college + "%'" +
                " and school= '" + school + "'";
        //System.out.println(sql);
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getString("college"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<String> queryMajor(String school, String college, String major) {
        //major必须是一个字符串 不能为空 不然会查出所有结果
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        String sql = "select distinct major" +
                " from major" +
                " where major like" +
                " '%" + major + "%'" +
                " and school= '" + school + "'" +
                " and college='" + college + "'";
        System.out.println(sql);
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getString("major"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
