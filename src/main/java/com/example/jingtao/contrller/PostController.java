package com.example.jingtao.contrller;

import com.example.jingtao.entity.*;
import com.example.jingtao.mapper.PostImageMapper;
import com.example.jingtao.service.PostService;
import com.example.jingtao.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserInfService userInfService;

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
     * @apiVersion 7.0.0
     * @apiGroup PostController
     * @apiName getPostByOpenid
     * @apiDescription 通过openid来获取该用户发布的全部帖子
     * @apiParam (请求参数) {String} openid
     * @apiParamExample 请求参数示例
     * openid=Hi
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {Object} response.data data里放的是一条post
     * @apiSuccess (响应结果) {Object} response.userInf 补全的对应userinfo信息
     * @apiSuccess (响应结果) {String} response.userInf.openid
     * @apiSuccess (响应结果) {String} response.userInf.nickname
     * @apiSuccess (响应结果) {String} response.userInf.headImg
     * @apiSuccessExample 响应结果示例
     * [{"data":{},"userInf":{"headImg":"AIHX","openid":"qkP","nickname":"ZDoMd"}}]
     */
    @RequestMapping("/getPostByOpenid")
    List<ResultWithUserInf> getPostByOpenid(@RequestParam("openid") String openid) {
        List<PostPlus> postByOpenid = postService.getPostByOpenid(openid);
        UserInf userInf = userInfService.selectByOpenid(new UserInf(openid, null, null));
        List<ResultWithUserInf> list = new ArrayList<>();
        for (PostPlus postPlus : postByOpenid) {
            list.add(new ResultWithUserInf(postPlus, userInf));
        }
        System.out.println(list);
        return list;

    }

    /**
     * @api {GET} /post/getPagePostByOpenid getPagePostByOpenid
     * @apiVersion 7.0.0
     * @apiGroup PostController
     * @apiName getPagePostByOpenid
     * @apiDescription 根据openid分页查询
     * @apiParam (请求参数) {String} openid
     * @apiParam (请求参数) {String} page 第几页
     * @apiParam (请求参数) {String} num 每页有多少数目
     * @apiParamExample 请求参数示例
     * openid=Ntbm&num=hNxFua&page=KgeSiJXOS
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {Object} response.data
     * @apiSuccess (响应结果) {Object} response.userInf
     * @apiSuccess (响应结果) {String} response.userInf.openid This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid
     * @apiSuccess (响应结果) {String} response.userInf.nickname This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname
     * @apiSuccess (响应结果) {String} response.userInf.headImg This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img
     * @apiSuccessExample 响应结果示例
     * [{"data":{},"userInf":{"headImg":"f","openid":"7EBbOt","nickname":"Ive9"}}]
     */
    @RequestMapping("/getPagePostByOpenid")
    List<ResultWithUserInf> getPagePostByOpenid(@RequestParam("openid") String openid, @RequestParam("page") String page, @RequestParam("num") String num) {
        List<PostPlus> pagePostByOpenid = postService.getPagePostByOpenid(openid, Integer.parseInt(page), Integer.parseInt(num));
        UserInf userInf = userInfService.selectByOpenid(new UserInf(openid, null, null));
        List<ResultWithUserInf> list = new ArrayList<>();
        for (PostPlus postPlus : pagePostByOpenid) {
            list.add(new ResultWithUserInf(postPlus, userInf));
        }
        return list;
    }

    /**
     * @api {GET} /post/getFirstPagePostBySchool getFirstPagePostBySchool
     * @apiVersion 7.0.0
     * @apiGroup PostController
     * @apiName getFirstPagePostBySchool
     * @apiDescription 根据学校分页查询帖子 获得第一页 会返回给你time 此后每次请求带上time
     * @apiParam (请求参数) {String} school
     * @apiParam (请求参数) {String} page
     * @apiParam (请求参数) {String} num
     * @apiParamExample 请求参数示例
     * school=mP6c&num=AvfzYKcts&page=Fn46Il6S
     * @apiSuccess (响应结果) {Object} response 返回的是一个map集合 一个字段time是时间 一个字段postlist是返回帖子列表
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping("/getFirstPagePostBySchool")
    Map<String, Object> getFirstPagePostBySchool(@RequestParam("school") String school, @RequestParam("page") String page, @RequestParam("num") String num) {
        page = "1";
        Date now = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time= LocalDateTime.now().format(format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);


        List<PostPlus> firstPagePostBySchool = postService.getFirstPagePostBySchool(school, Integer.parseInt(page), Integer.parseInt(num));
        List<ResultWithUserInf> list = new ArrayList<>();
        for (PostPlus postPlus : firstPagePostBySchool) {
            UserInf userInf = userInfService.selectByOpenid(new UserInf(postPlus.getOpenid(), null, null));
            list.add(new ResultWithUserInf(postPlus, userInf));
        }


        Map<String, Object> map = new HashMap<>();
        map.put("time", time);
        map.put("postlist", list);
        return map;
    }

    /**
     * @api {POST} /post/getPagePostBySchool getPagePostBySchool
     * @apiVersion 7.0.0
     * @apiGroup PostController
     * @apiName getPagePostBySchool
     * @apiDescription 根据学校分页查询 第2 3 4....页
     * @apiParam (请求参数) {String} school
     * @apiParam (请求参数) {String} page
     * @apiParam (请求参数) {String} num
     * @apiParam (请求参数) {String} time 查询第一页发给你的time
     * @apiParamExample 请求参数示例
     * school=jkw1QV&num=AQc3twMBJ&page=bcdv5oP&time=W
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {Object} response.data
     * @apiSuccess (响应结果) {Object} response.userInf
     * @apiSuccess (响应结果) {String} response.userInf.openid This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid
     * @apiSuccess (响应结果) {String} response.userInf.nickname This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname
     * @apiSuccess (响应结果) {String} response.userInf.headImg This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img
     * @apiSuccessExample 响应结果示例
     * [{"data":{},"userInf":{"headImg":"JAdUl","openid":"Moh2Y","nickname":"PftjU0xcr"}}]
     */
    @RequestMapping("/getPagePostBySchool")
    List<ResultWithUserInf> getPagePostBySchool(@RequestParam("school") String school, @RequestParam("page") String page, @RequestParam("num") String num, @RequestParam("time") String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<PostPlus> pagePostBySchool = postService.getPagePostBySchool(school, Integer.parseInt(page), Integer.parseInt(num), date);
        List<ResultWithUserInf> list = new ArrayList<>();
        for (PostPlus postPlus : pagePostBySchool) {
            UserInf userInf = userInfService.selectByOpenid(new UserInf(postPlus.getOpenid(), null, null));
            list.add(new ResultWithUserInf(postPlus, userInf));
        }

        return list;

    }

    /**
     * @api {GET} /post/getAllFistPagePost getAllFistPagePost
     * @apiVersion 7.0.0
     * @apiGroup PostController
     * @apiName getAllFistPagePost
     * @apiDescription 在所有帖子里 查询第一页
     * @apiParam (请求参数) {String} page
     * @apiParam (请求参数) {String} num
     * @apiParamExample 请求参数示例
     * num=F5FaLm6o&page=PsPyW1
     * @apiSuccess (响应结果) {Object} response 同根据学校查询第一页
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping("/getAllFistPagePost")
    Map<String, Object> getAllFistPagePost(@RequestParam("page") String page, @RequestParam("num") String num) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);

        page = "1";
        List<PostPlus> allFistPagePost = postService.getAllFistPagePost(Integer.parseInt(page), Integer.parseInt(num));
        List<ResultWithUserInf> list = new ArrayList<>();
        for (PostPlus postPlus : allFistPagePost) {
            UserInf userInf = userInfService.selectByOpenid(new UserInf(postPlus.getOpenid(), null, null));
            list.add(new ResultWithUserInf(postPlus, userInf));
        }


        Map<String, Object> map = new HashMap<>();
        map.put("time", time);
        map.put("postlist", list);
        return map;

    }

    /**
     * @api {GET} /post/getAllPagePost getAllPagePost
     * @apiVersion 7.0.0
     * @apiGroup PostController
     * @apiName getAllPagePost
     * @apiDescription 查询所有帖子的第2 3 4 5.....页
     * @apiParam (请求参数) {String} page
     * @apiParam (请求参数) {String} num
     * @apiParam (请求参数) {String} time 第一次查询时返回给你的时间
     * @apiParamExample 请求参数示例
     * num=ONqoIXjNlw&page=A&time=uPmL6Ge
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {Object} response.data
     * @apiSuccess (响应结果) {Object} response.userInf
     * @apiSuccess (响应结果) {String} response.userInf.openid This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid
     * @apiSuccess (响应结果) {String} response.userInf.nickname This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname
     * @apiSuccess (响应结果) {String} response.userInf.headImg This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img
     * @apiSuccessExample 响应结果示例
     * [{"data":{},"userInf":{"headImg":"nk","openid":"aX80hBIr","nickname":"PB3sC5"}}]
     */
    @RequestMapping("/getAllPagePost")
    List<ResultWithUserInf> getAllPagePost(@RequestParam("page") String page, @RequestParam("num") String num, @RequestParam("time") String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<PostPlus> allPagePost = postService.getAllPagePost(Integer.parseInt(page), Integer.parseInt(num), date);

        List<ResultWithUserInf> list = new ArrayList<>();
        for (PostPlus postPlus : allPagePost) {
            UserInf userInf = userInfService.selectByOpenid(new UserInf(postPlus.getOpenid(), null, null));
            list.add(new ResultWithUserInf(postPlus, userInf));
        }
        return list;
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
       // System.out.println(postId + " " + imageId);
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
