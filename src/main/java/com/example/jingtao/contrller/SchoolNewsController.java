package com.example.jingtao.contrller;

import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.entity.SchoolNews;
import com.example.jingtao.mapper.SchoolNewsMapper;
import com.example.jingtao.service.SchoolNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@RestController
@RequestMapping("/news")
public class SchoolNewsController {
    @Autowired
    private SchoolNewsService schoolNewsService;
    @Autowired
    private SchoolNewsMapper schoolNewsMapper;

    /**
     * @api {POST} /news/addASchoolNews addASchoolNews
     * @apiVersion 3.0.0
     * @apiGroup SchoolNewsController
     * @apiName addASchoolNews
     * @apiDescription 添加一个校园新闻、头条 用户页面不做这个 这个由web端管理员发布
     * @apiParam (请求参数) {String} title 新闻题目
     * @apiParam (请求参数) {String} content 内容
     * @apiParam (请求参数) {Object} file 图片
     * @apiParamExample {json}请求参数示例
     *<form action="http://localhost:8080/news/addASchoolNews" enctype="multipart/form-data" method="post">
     *         <input type="text" name="title" placeholder="title">
     *         <input type="text" name="content" placeholder="content">
     *         <input type="file" name="file"> html通过这个来加载本地图片资源
     *         <input type="submit" value="上传">
     *     </form>
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data null
     * @apiSuccessExample 响应结果示例
     * {"msg":"8","code":4474,"data":{}}
     */
    @RequestMapping("/addASchoolNews")
    ResultEntity addASchoolNews(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("file") MultipartFile file) {
        byte[] img = null;
        try {
            img = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SchoolNews schoolNews = new SchoolNews(title, content, new Date(), img);
        schoolNewsService.addASchoolNews(schoolNews);
        return ResultEntity.success("ok", null);
    }

    /**
     * @api {GET} /news/deleteSchoolNewsByTitle deleteSchoolNewsByTitle
     * @apiVersion 3.0.0
     * @apiGroup SchoolNewsController
     * @apiName deleteSchoolNewsByTitle
     * @apiDescription 根据title来删除一条新闻 用户页面不做这个 这个由web端管理员来操作
     * @apiParam (请求参数) {String} title 新闻的title
     * @apiParamExample 请求参数示例
     * title=EJEp2wQ
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data null
     * @apiSuccessExample 响应结果示例
     * {"msg":"68fBVEaKw","code":328,"data":{}}
     */
    @RequestMapping("/deleteSchoolNewsByTitle")
    ResultEntity deleteSchoolNewsByTitle(@RequestParam("title") String title) {
        schoolNewsService.deleteSchoolNewsByTitle(title);
        return ResultEntity.success("ok", null);

    }

    /**
     * @api {GET} /news/getAllSchoolNews getAllSchoolNews
     * @apiVersion 3.0.0
     * @apiGroup SchoolNewsController
     * @apiName getAllSchoolNews
     * @apiDescription 获得校园新闻、头条记录 没有请求参数
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data data里放的是一个新闻的数组
     * @apiSuccessExample 响应结果示例
     * {
     * "code": 1,
     * "msg": "ok",
     * "data": [
     * {
     * "title": "山东大学第二届运动会",
     * "content": "egerbhsvcbwbvuvwqwquiowebvubewv",
     * "img_src": "/news/getImg?title=山东大学第二届运动会",  //img_src是为了方便前端获取图片资源设置的图片资源访问路径
     * "time": "2021-05-16T04:17:24.000+00:00"   //发布的时间 可以根据这个来排序
     * },
     * {
     * "title": "软件学院山大地玮杯",
     * "content": "全国无是凤求凰微积分ifVB差几年内物权法是重庆楼盘为你欧服报卡不好   不犯法请问 静悄悄好亲切额 无诶饥饿吧菊 企鹅群文件就去发额编辑器就无法发",
     * "img_src": "/news/getImg?title=软件学院山大地玮杯",
     * "time": "2021-05-16T04:19:22.000+00:00"
     * }
     * ]
     * }
     */
    @RequestMapping("/getAllSchoolNews")
    ResultEntity getAllSchoolNews() {
        return ResultEntity.success("ok", schoolNewsService.getAllSchoolNews());
    }

    /**
     * @api {GET} /news/getImg getImg
     * @apiVersion 3.0.0
     * @apiGroup SchoolNewsController
     * @apiName getImg
     * @apiDescription 你根据这个接口来获取图片资源
     * @apiParam (请求参数) {String} title
     * @apiParamExample {json}请求参数示例
     * <img src= img_src /> 直接让src等于我发给你的img_src字段 即可加载图片资源
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * null
     */
    @RequestMapping("/getImg")
    void getImg(HttpServletResponse response, @RequestParam("title") String title) {
        SchoolNews schoolNews = schoolNewsMapper.selectByPrimaryKey(title);
        byte[] img = schoolNews.getImg();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputSream = null;
        try {
            outputSream = response.getOutputStream();

            outputSream.write(img);
            outputSream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
