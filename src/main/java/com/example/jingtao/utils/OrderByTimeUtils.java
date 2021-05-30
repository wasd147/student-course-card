package com.example.jingtao.utils;

import com.example.jingtao.entity.Note;
import com.example.jingtao.entity.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderByTimeUtils {
    public static List<Post> order(List<Post> list) {
        //将一个post集合按照时间从大到小排序
        int len = list.size();
        List<Post> resPost = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Post post = list.get(0);
            int max = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getTime().after(post.getTime())) {
                    max = j;
                    post = list.get(j);
                }
            }
            resPost.add(post);
            list.remove(max);
        }
        return resPost;
    }

    public static List<Note> orderNote(List<Note> list) {
        //将一个note集合按照时间从大到小排序
        int len = list.size();
        List<Note> resNote = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Note note = list.get(0);
            int max = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getTime().before(note.getTime())) {
                    max = j;
                    note = list.get(j);
                }
            }
            resNote.add(note);
            list.remove(max);
        }
        return resNote;
    }
}
