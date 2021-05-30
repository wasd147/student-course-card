package com.example.jingtao.utils;

import com.example.jingtao.entity.Token;
import com.example.jingtao.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class TokenUtils {

    public static TokenMapper tokenMapper;

    @Autowired
    public void setTokenMapper(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    public static int testToken(String token) {
        // System.out.println(tokenMapper == null);
        Token resToken = tokenMapper.selectByPrimaryKey(token);
        // System.out.println(resToken);
        //为空
        if (resToken == null) {
            return 0;
        } else {
            //得到token
            String creatTime = resToken.getCreatTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date createDate = null;
            try {
                createDate = format.parse(creatTime);
                // System.out.println(createDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date nowDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(createDate);
            calendar.add(Calendar.DAY_OF_YEAR, 1);//1tian
            Date createDatePlus = calendar.getTime();
            if ((createDatePlus.compareTo(nowDate)) == (1)) {
                //更新token时间
                resToken.setCreatTime(format.format(new Date()));
                tokenMapper.updateByPrimaryKey(resToken);
                return 1;


            } else {
                return (-1);
            }

        }
    }

    public static int deleteOutToken(String token) {
        int i = tokenMapper.deleteByPrimaryKey(token);
        return i;

    }
}
