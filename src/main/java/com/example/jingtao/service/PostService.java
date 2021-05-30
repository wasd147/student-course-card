package com.example.jingtao.service;

import com.example.jingtao.entity.Post;
import com.example.jingtao.entity.PostImage;
import com.example.jingtao.entity.PostPlus;
import com.example.jingtao.mapper.PostImageMapper;
import com.example.jingtao.mapper.PostMapper;
import com.example.jingtao.utils.OrderByTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
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

    public List<PostPlus> getPagePostByOpenid(String openid, int page, int num) {
        List<Post> postByOpenid = postMapper.getPostByOpenid(openid);
        List<Post> order = OrderByTimeUtils.order(postByOpenid);
        System.out.println("order:" + order);
        int b_index = (page - 1) * num;
        int e_index = page * num-1;
        List<Post> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index+1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        System.out.println("res_post:" + res_post);
        //处理完毕 开始挂载图片
        List<PostPlus> postPlusList = new ArrayList<>();
        if (res_post!=null) {
            for (Post post : res_post) {
                //为每个post匹配他的图片
                List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
                //返回这个图片集合 将该集合处理后挂载到post上
                postPlusList.add(post.toPostPlus(postImages));
            }
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

    public List<PostPlus> getFirstPagePostBySchool(String school, int page, int num) {
        page = 1;
        List<Post> postBySchool = postMapper.getPostBySchool(school);
        List<Post> order = OrderByTimeUtils.order(postBySchool);
        System.out.println("order:" + order);
        int b_index = (page - 1) * num;
        int e_index = page * num-1;
        List<Post> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index+1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        System.out.println("res_post:" + res_post);
        //处理完毕 开始挂载图片
        List<PostPlus> postPlusList = new ArrayList<>();
        if (res_post!=null) {
            for (Post post : res_post) {
                //为每个post匹配他的图片
                List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
                //返回这个图片集合 将该集合处理后挂载到post上
                postPlusList.add(post.toPostPlus(postImages));
            }
        }
        //挂载完毕
        return postPlusList;
    }

    public List<PostPlus> getPagePostBySchool(String school, int page, int num, Date time) {
        List<Post> postBySchool = postMapper.getPostBySchool(school);
        for (int i = 0; i < postBySchool.size(); i++) {
            if (postBySchool.get(i).getTime().after(time)) {
                postBySchool.remove(i);
            }
        }
        List<Post> order = OrderByTimeUtils.order(postBySchool);
        System.out.println("order:" + order);
        int b_index = (page - 1) * num;
        int e_index = page * num-1;
        List<Post> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index+1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        System.out.println("res_post:" + res_post);
        //处理完毕 开始挂载图片
        List<PostPlus> postPlusList = new ArrayList<>();
        if (res_post!=null) {
            for (Post post : res_post) {
                //为每个post匹配他的图片
                List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
                //返回这个图片集合 将该集合处理后挂载到post上
                postPlusList.add(post.toPostPlus(postImages));
            }
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

    public List<PostPlus> getAllFistPagePost(int page, int num) {
        page = 1;
        List<Post> allPost = postMapper.getAllPost();
        List<Post> order = OrderByTimeUtils.order(allPost);
        System.out.println("order:" + order);
        int b_index = (page - 1) * num;
        int e_index = page * num-1;
        List<Post> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index+1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        System.out.println("res_post:" + res_post);
        //处理完毕 开始挂载图片
        List<PostPlus> postPlusList = new ArrayList<>();
        if (res_post!=null) {
            for (Post post : res_post) {
                //为每个post匹配他的图片
                List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
                //返回这个图片集合 将该集合处理后挂载到post上
                postPlusList.add(post.toPostPlus(postImages));
            }
        }
        //挂载完毕
        return postPlusList;
    }

    public List<PostPlus> getAllPagePost(int page, int num, Date time) {
        List<Post> allPost = postMapper.getAllPost();
        for (int i = 0; i < allPost.size(); i++) {
            if (allPost.get(i).getTime().after(time)) {
                allPost.remove(i);
            }
        }
        List<Post> order = OrderByTimeUtils.order(allPost);
        System.out.println("order:" + order);
        int b_index = (page - 1) * num;
        int e_index = page * num-1;
        List<Post> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index+1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        System.out.println("res_post:" + res_post);
        //处理完毕 开始挂载图片
        List<PostPlus> postPlusList = new ArrayList<>();
        if (res_post!=null) {
            for (Post post : res_post) {
                //为每个post匹配他的图片
                List<PostImage> postImages = postImageMapper.selectByPostId(post.getPostId());
                //返回这个图片集合 将该集合处理后挂载到post上
                postPlusList.add(post.toPostPlus(postImages));
            }
        }
        //挂载完毕
        return postPlusList;
    }

    public PostImage getImg(String postId, int imageId) {
        PostImage postImage = postImageMapper.selectByPostIdAndImageId(postId, imageId);
        return postImage;
    }
}

