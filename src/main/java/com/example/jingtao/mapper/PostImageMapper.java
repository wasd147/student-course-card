package com.example.jingtao.mapper;

import com.example.jingtao.entity.PostImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostImageMapper {
    int insert(PostImage postImage);

    int deletePostImageByPostId(String postId);

    List<PostImage> selectByPostId(String postId);

    PostImage selectByPostIdAndImageId(String postId, int imageId);
}
