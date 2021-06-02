package com.example.jingtao.mapper;

import com.example.jingtao.entity.Note;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoteMapper {
    void insert(Note note);

    List<Note> getNotesBySender(String sender);

    List<Note> getNotesByAccepter(String accepter);

    void hasLook(Note note);

    List<Note> getNoteBySenderAndAccepter(String sender, String accepter);
}
