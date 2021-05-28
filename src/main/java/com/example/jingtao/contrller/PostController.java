package com.example.jingtao.contrller;

import com.example.jingtao.entity.Post;
import com.example.jingtao.entity.PostImage;
import com.example.jingtao.entity.PostPlus;
import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.mapper.PostImageMapper;
import com.example.jingtao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * @api {POST} /post/addAPost addAPost
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName addAPost
     * @apiDescription 发布一个新帖子
     * @apiParam (请求参数) {String} openid
     * @apiParam (请求参数) {String} school 学校
     * @apiParam (请求参数) {String} content 内容
     * @apiParamExample 请求参数示例
     * school=mlz&openid=jSRbxj&content=LEJDsqppd
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data data里会有一个字符串postId 你在回调方法里用这个上传图片
     * @apiSuccessExample 响应结果示例
     * {"msg":"oj3","code":5116,"data":{}}
     */
    @RequestMapping("/addAPost")
    ResultEntity addAPost(@RequestParam("openid") String openid, @RequestParam("school") String school, @RequestParam("content") String content) {
        String postId = UUID.randomUUID().toString();

        Post post = new Post(postId, openid, school, content, new Date());
        postService.addAPost(post);
        return ResultEntity.success("利用这个唯一的postID上传图片", postId);

    }

    /**
     * @api {POST} /post/addAPostImage addAPostImage
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName addAPostImage
     * @apiDescription 一次只能上传一张图片，你在前端循环调用upload方法，每张图片要指定一个顺序，从零开始
     * @apiParam (请求参数) {Object} file 你的图片文件
     * @apiParam (请求参数) {String} postId 发给你的postId
     * @apiParam (请求参数) {Number} imageId 图片的顺序0.1.2.3这样
     * @apiParamExample 请求参数示例
     * file=null&imageId=1021&postId=p
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"N","code":6209,"data":{}}
     */
    @RequestMapping("/addAPostImage")
    ResultEntity addAPostImage(@RequestParam("file") MultipartFile file, @RequestParam("postId") String postId, @RequestParam("imageId") int imageId) {
        System.out.println(imageId);
        byte[] image = null;
        try {
            image = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = postService.addAPostImage(new PostImage(postId, imageId, image));
        if (i == 1) {
            return ResultEntity.success("ok", null);
        } else {
            return ResultEntity.error("上传失败", null);
        }

    }

    /**
     * @api {GET} /post/deleteAPostByPostId deleteAPostByPostId
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName deleteAPostByPostId
     * @apiDescription 通过postId来删除一条post记录
     * @apiParam (请求参数) {String} postId
     * @apiParamExample 请求参数示例
     * postId=oV6kn67sy
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"bzpCRYvZk","code":6406,"data":{}}
     */
    @RequestMapping("/deleteAPostByPostId")
    ResultEntity deleteAPostByPostId(@RequestParam("postId") String postId) {
        postService.deleteAPostById(postId);
        postService.deletePostImageById(postId);
        return ResultEntity.success("ok", null);
    }

    /**
     * @api {GET} /post/getPostByOpenid getPostByOpenid
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getPostByOpenid
     * @apiDescription 通过openid来获取该用户发布的全部帖子
     * @apiParam (请求参数) {String} openid
     * @apiParamExample 请求参数示例
     * openid=05J
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.postId 每条帖子的唯一标识
     * @apiSuccess (响应结果) {String} response.openid 用户的openid
     * @apiSuccess (响应结果) {String} response.school 用的学校
     * @apiSuccess (响应结果) {String} response.content 每条帖子的内容
     * @apiSuccess (响应结果) {Number} response.time 帖子的发布时间
     * @apiSuccess (响应结果) {Array} response.arraylist 这个是帖子的图片加载路径数组
     * @apiSuccessExample 响应结果示例
     * [{"school":"Fck4VA0fJ","openid":"ughWyHW3VK","postId":"siLD0","time":1819098654762,"arraylist":["nqkNYTl7v"],"content":"L7aQmbIbNL"}]
     */
    @RequestMapping("/getPostByOpenid")
    List<PostPlus> getPostByOpenid(@RequestParam("openid") String openid) {
        List<PostPlus> postByOpenid = postService.getPostByOpenid(openid);
        return postByOpenid;

    }

    /**
     * @api {GET} /post/getPostByOpenidLimit getPostByOpenidLimit
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getPostByOpenidLimit
     * @apiDescription 指定要返回的帖子条数 你可以每次刷新或者下拉调用 通过num数值达到动态刷新的效果
     * @apiParam (请求参数) {String} openid
     * @apiParam (请求参数) {Number} num 要返回的条子条数
     * @apiParamExample 请求参数示例
     * openid=BnhiXGGIf&num=6381
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.postId
     * @apiSuccess (响应结果) {String} response.openid
     * @apiSuccess (响应结果) {String} response.school
     * @apiSuccess (响应结果) {String} response.content
     * @apiSuccess (响应结果) {Number} response.time
     * @apiSuccess (响应结果) {Array} response.arraylist
     * @apiSuccessExample 响应结果示例
     * [{"school":"p","openid":"5Qe6Y","postId":"j0","time":1062002455722,"arraylist":["y5ova"],"content":"qZKG"}]
     */
    @RequestMapping("/getPostByOpenidLimit")
    List<PostPlus> getPostByOpenidLimit(@RequestParam("openid") String openid, @RequestParam("num") int num) {

        List<PostPlus> postByOpenid = postService.getPostByOpenid(openid);
        if (num > postByOpenid.size()) {
            return postByOpenid;
        } else {
            return postByOpenid.subList(0, num);
        }

    }

    /**
     * @api {GET} /post/getPostBySchool getPostBySchool
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getPostBySchool
     * @apiDescription 获取一个学校的所有帖子
     * @apiParam (请求参数) {String} school
     * @apiParamExample 请求参数示例
     * school=4
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.postId
     * @apiSuccess (响应结果) {String} response.openid
     * @apiSuccess (响应结果) {String} response.school
     * @apiSuccess (响应结果) {String} response.content
     * @apiSuccess (响应结果) {Number} response.time
     * @apiSuccess (响应结果) {Array} response.arraylist
     * @apiSuccessExample 响应结果示例
     * [{"school":"2BO64L","openid":"tk91V1","postId":"Rsn","time":545597965185,"arraylist":["lix0"],"content":"t"}]
     */
    @RequestMapping("/getPostBySchool")
    List<PostPlus> getPostBySchool(@RequestParam("school") String school) {
        List<PostPlus> postBySchool = postService.getPostBySchool(school);
        return postBySchool;
    }

    /**
     * @api {GET} /post/getPostBySchoolLimit getPostBySchoolLimit
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getPostBySchoolLimit
     * @apiDescription 获取一个学校指定数量的帖子 可动态刷新
     * @apiParam (请求参数) {String} school
     * @apiParam (请求参数) {Number} num 要返回的数目
     * @apiParamExample 请求参数示例
     * school=N1&num=5745
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.postId
     * @apiSuccess (响应结果) {String} response.openid
     * @apiSuccess (响应结果) {String} response.school
     * @apiSuccess (响应结果) {String} response.content
     * @apiSuccess (响应结果) {Number} response.time
     * @apiSuccess (响应结果) {Array} response.arraylist
     * @apiSuccessExample 响应结果示例
     * [{"school":"DiT92","openid":"8CiWQ7o","postId":"1sAhkTdm","time":1902403681338,"arraylist":["im8Nu4tY"],"content":"l"}]
     */
    @RequestMapping("/getPostBySchoolLimit")
    List<PostPlus> getPostBySchoolLimit(@RequestParam("school") String school, @RequestParam("num") int num) {
        List<PostPlus> postBySchool = postService.getPostBySchool(school);
        if (num > postBySchool.size()) {
            return postBySchool;
        } else {
            return postBySchool.subList(0, num);
        }
    }

    /**
     * @api {GET} /post/getAllPost getAllPost
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getAllPost
     * @apiDescription 获取所有用户的所有帖子
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.postId
     * @apiSuccess (响应结果) {String} response.openid
     * @apiSuccess (响应结果) {String} response.school
     * @apiSuccess (响应结果) {String} response.content
     * @apiSuccess (响应结果) {Number} response.time
     * @apiSuccess (响应结果) {Array} response.arraylist
     * @apiSuccessExample 响应结果示例
     * [{"school":"xb4xcBI","openid":"LSuUuVgKEz","postId":"bFjU","time":3072972334286,"arraylist":["NJVL7NG"],"content":"XeXX5VuN1"}]
     */
    @RequestMapping("/getAllPost")
    List<PostPlus> getAllPost() {
        return postService.getAllPost();
    }

    /**
     * @api {GET} /post/getAllPostLimit getAllPostLimit
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getAllPostLimit
     * @apiDescription 获取所有用户的指定数目的帖子
     * @apiParam (请求参数) {Number} num
     * @apiParamExample 请求参数示例
     * num=9650
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.postId
     * @apiSuccess (响应结果) {String} response.openid
     * @apiSuccess (响应结果) {String} response.school
     * @apiSuccess (响应结果) {String} response.content
     * @apiSuccess (响应结果) {Number} response.time
     * @apiSuccess (响应结果) {Array} response.arraylist
     * @apiSuccessExample 响应结果示例
     * [{"school":"fwQLE7ODeE","openid":"yDG","postId":"4LGw5qYT","time":1425295824718,"arraylist":["feP8redS"],"content":"5X"}]
     */
    @RequestMapping("/getAllPostLimit")
    List<PostPlus> getAllPostLimit(@RequestParam("num") int num) {
        List<PostPlus> allPost = postService.getAllPost();
        if (num > allPost.size()) {
            return allPost;
        } else {
            return allPost.subList(0, num);
        }
    }


    /**
     * @api {POST} /post/getImg getImg
     * @apiVersion 4.0.0
     * @apiGroup PostController
     * @apiName getImg
     * @apiDescription 获取帖子的图片资源  已经在返回数据的数组里封装好了 直接等于src就可
     * @apiParam (请求参数) {String} postId
     * @apiParam (请求参数) {Number} imageId
     * @apiParamExample 请求参数示例
     * imageId=8309&postId=ku
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * null
     */
    @RequestMapping("/getImg")
    void getImg(@RequestParam("postId") String postId, @RequestParam("imageId") int imageId, HttpServletResponse response) {
        System.out.println(postId + " " + imageId);
        PostImage img = postService.getImg(postId, imageId);
        byte[] image = img.getImage();

        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputSream = null;
        try {
            outputSream = response.getOutputStream();

            outputSream.write(image);
            outputSream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
