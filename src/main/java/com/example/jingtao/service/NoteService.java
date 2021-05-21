package com.example.jingtao.service;

import com.example.jingtao.entity.Note;
import com.example.jingtao.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NoteService {
    @Autowired
    private NoteMapper noteMapper;

    public void sendMsg(String sender, String accepter, String msg) {
        noteMapper.insert(new Note(sender, accepter, msg, new Date(), 0));

    }

    public Map getNotes(String openid) {
        List<Note> notesBySender = noteMapper.getNotesBySender(openid);
        List<Note> notesByAccepter = noteMapper.getNotesByAccepter(openid);
        Map<String, ArrayList<Note>> map = new HashMap<>();

        for (Note note : notesByAccepter) {
            if (!map.containsKey(note.getSender())) {
                map.put(note.getSender(), new ArrayList<>());
            }
            map.get(note.getSender()).add(note);
        }
        for (String s : map.keySet()) {
            hasLook(map.get(s));
        }
        for (Note note : notesBySender) {
            if (!map.containsKey(note.getAccepter())) {
                map.put(note.getAccepter(), new ArrayList<>());
            }
            map.get(note.getAccepter()).add(note);

        }

        return map;
    }

    public void hasLook(ArrayList<Note> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            noteMapper.hasLook(arrayList.get(i));
        }
    }
}
