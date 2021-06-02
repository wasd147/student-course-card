package com.example.jingtao.service;

import com.example.jingtao.entity.Contacter;
import com.example.jingtao.entity.Note;
import com.example.jingtao.entity.NotePlus;
import com.example.jingtao.entity.UserInf;
import com.example.jingtao.mapper.NoteMapper;
import com.example.jingtao.utils.OrderByTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserInfService userInfService;

    public void sendMsg(String sender, String accepter, String msg) {
        noteMapper.insert(new Note(sender, accepter, msg, new Date(), 0));

    }

    public List<NotePlus> getNotes(String myself, String theOther) {
        List<Note> notesByAccepter = noteMapper.getNoteBySenderAndAccepter(theOther, myself);
        List<Note> notesBySender = noteMapper.getNoteBySenderAndAccepter(myself, theOther);
        Map<String, List<Note>> map = new HashMap<>();

        if (notesByAccepter != null) {
            for (Note note : notesByAccepter) {
                if (!map.containsKey(note.getSender())) {
                    map.put(note.getSender(), new ArrayList<>());
                }
                map.get(note.getSender()).add(note);
            }
        }
        for (String s : map.keySet()) {
            hasLook(map.get(s));
        }
        if (notesBySender != null) {
            for (Note note : notesBySender) {
                if (!map.containsKey(note.getAccepter())) {
                    map.put(note.getAccepter(), new ArrayList<>());
                }
                map.get(note.getAccepter()).add(note);

            }
        }
        Map<UserInf, List<NotePlus>> map1 = toPlus(map);
        List<NotePlus> list = new ArrayList<>();
        if (!map1.isEmpty()) {
            for (Object o : map1.keySet()) {
                list = map1.get(o);
            }
        }

        return list;
    }

    public void hasLook(List<Note> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            noteMapper.hasLook(arrayList.get(i));
        }
    }

    public Map<UserInf, List<NotePlus>> toPlus(Map<String, List<Note>> map) {
        if (map == null | map.size() == 0) {
            return null;
        }
        for (String s : map.keySet()) {
            List<Note> orderNote = OrderByTimeUtils.orderNote(map.get(s));
            map.put(s, orderNote);
        }
        //排序完成 开始封装数据
        Map<UserInf, List<NotePlus>> mapPlus = new HashMap<>();
//        UserInfService userInfService = new UserInfService();
        for (String s : map.keySet()) {
            List<NotePlus> notePluses = Note.toNotePlus(map.get(s));
            mapPlus.put(userInfService.selectByOpenid(new UserInf(s, null, null)), notePluses);

        }
        return mapPlus;

    }

    public List<Contacter> getContacter(String openid) {
        List<Note> notesByAccepter = noteMapper.getNotesByAccepter(openid);
        List<Note> notesBySender = noteMapper.getNotesBySender(openid);
        List<Contacter> contacterList = new ArrayList<>();//++++
        Map<String, Contacter> map = new HashMap<>();
        for (int i = 0; i < notesByAccepter.size(); i++) {
            if (!map.containsKey(notesByAccepter.get(i).getSender())) {
                map.put(notesByAccepter.get(i).getSender(), new Contacter(notesByAccepter.get(i).getSender(), notesByAccepter.get(i).getLook()));

            } else {
                if (notesByAccepter.get(i).getLook() == 0) {
                    map.put(notesByAccepter.get(i).getSender(), new Contacter(notesByAccepter.get(i).getSender(), notesByAccepter.get(i).getLook()));
                }
            }

        }
        for (int i = 0; i < notesBySender.size(); i++) {
            if (!map.containsKey(notesBySender.get(i).getAccepter())) {
                map.put(notesBySender.get(i).getAccepter(), new Contacter(notesBySender.get(i).getAccepter(), 1));
            }
        }
        if (!map.isEmpty()) {
            for (String s : map.keySet()) {
                contacterList.add(map.get(s));
            }
        }
        return contacterList;
    }
}

