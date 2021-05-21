package com.example.jingtao.service;

import com.example.jingtao.entity.Post;
import com.example.jingtao.entity.PostImage;
import com.example.jingtao.entity.PostPlus;
import com.example.jingtao.mapper.PostImageMapper;
import com.example.jingtao.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostImageMapper postImageMapper;

    public void addAPost(Post post) {
        postMapper.insert(post);
    }

    public int addAPostImage(PostImage postImage) {
        int insert = postImageMapper.insert(postImage);
        return insert;
    }

    public void deleteAPostById(String postId) {
        postMapper.deleteByPrimaryKey(postId);
    }

    public int deletePostImageById(String postId) {
        int i = postImageMapper.deletePostImageByPostId(postId);
        return i;
    }

    public List<PostPlus> getPostByOpenid(String openid) {
        List<Post> postByOpenid = postMapper.getPostByOpenid(openid);
        System.out.println(postByOpenid);
        List<PostPlus> postPlusList = new ArrayList<>();
        for (Post post : postByOpenid) {
            //为每个post匹配他的图片
            List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
            //返回这个图片集合 将该集合处理后挂载到post上
            postPlusList.add(post.toPostPlus(postImages));
        }
        //挂载完毕
        return postPlusList;
    }

    public List<PostPlus> getPostBySchool(String school) {
        List<Post> postBySchool = postMapper.getPostBySchool(school);
        List<PostPlus> postPlusList = new ArrayList<>();
        for (Post post : postBySchool) {
            //为每个post匹配他的图片
            List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
            //返回这个图片集合 将该集合处理后挂载到post上
            postPlusList.add(post.toPostPlus(postImages));
        }
        //挂载完毕
        return postPlusList;
    }

    public List<PostPlus> getAllPost() {
        List<Post> postList = postMapper.getAllPost();
        List<PostPlus> postPlusList = new ArrayList<>();
        for (Post post : postList) {
            //为每个post匹配他的图片
            List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
            //返回这个图片集合 将该集合处理后挂载到post上
            postPlusList.add(post.toPostPlus(postImages));
        }
        //挂载完毕
        return postPlusList;
    }

    public PostImage getImg(String postId, int imageId) {
        PostImage postImage = postImageMapper.selectByPostIdAndImageId(postId, imageId);
        return postImage;
    }
}

