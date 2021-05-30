package com.example.jingtao.entity;

import com.example.jingtao.mapper.UserInfMapper;
import com.example.jingtao.service.UserInfService;
import com.example.jingtao.service.UserService;
import com.example.jingtao.utils.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private String sender;
    private String accepter;
    private String message;
    private Date time;
    private int look;


    public NotePlus toNotePlus() {
//        UserInfService userInfService = new UserInfService();
        UserInfService userInfService = BeanUtils.userInfService;
        UserInf senderUserInf = userInfService.selectByOpenid(new UserInf(this.sender, null, null));
        UserInf accepterUserInf = userInfService.selectByOpenid(new UserInf(this.accepter, null, null));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format(this.time);
        NotePlus notePlus = new NotePlus(senderUserInf, accepterUserInf, this.message, formatTime, look);
        return notePlus;

    }

    public static List<NotePlus> toNotePlus(List<Note> list) {
        ArrayList<NotePlus> notePluses = new ArrayList<>();
        for (Note note : list) {
            notePluses.add(note.toNotePlus());
        }
        return notePluses;
    }
}