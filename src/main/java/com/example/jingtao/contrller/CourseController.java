package com.example.jingtao.contrller;

import com.alibaba.fastjson.JSON;
import com.example.jingtao.entity.Course;
import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * @api {POST} /course/importCourse importCourse
     * @apiVersion 5.0.0
     * @apiGroup CourseController
     * @apiName importCourse
     * @apiDescription 自动导入本学期课表 目前仅支持山东大学 请期待后续更新
     * @apiParam (请求参数) {String} openid
     * @apiParam (请求参数) {String} username 学生账号
     * @apiParam (请求参数) {String} password 密码
     * @apiParamExample 请求参数示例
     * password=cHf9Xb&openid=Q7hxK6n4U&username=gRF
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data 没有返回值
     * @apiSuccessExample 响应结果示例
     * {"msg":"FzxEUmBB","code":4080,"data":{}}
     */
    @RequestMapping("/importCourse")
    public ResultEntity importCourse(@RequestParam("openid") String openid, @RequestParam("username") String username, @RequestParam("password") String password) {
        courseService.importCourseByOpenidAndStudentId(openid, username, password);
        return ResultEntity.success("导入课表成功", null);
    }

    /**
     * @api {POST} /course/addCourse addCourse
     * @apiVersion 1.0.0
     * @apiGroup CourseController
     * @apiName addCourse
     * @apiDescription 添加一个课程
     * @apiParam (请求参数) {String} course course是一个由course对象转化的json字符串
     * @apiParamExample {json} Request-Example:
     * 先封装好一个course对象
     * var course = {
     * "openid": "oNTNQ5EVBLG1qFO2QfNGEm6hcdrk",
     * "courseName": "java",    课程名称 String
     * "classroom": "四区205",   教室 String
     * "weeks": [1,3,5,9, 12, 13, 14, 15, 16, 18],  上课周次 int数组
     * "day": 3, 周几上课 int
     * "jieshu": 4,  上课节数 上午8:00-10:00为第一节 一天五节课以此类推
     * "teacher": "陈景涛"  任课老师
     * }
     * 请求的时候应该是这样:
     * {
     * "course": JSON.stringify(course)
     * }
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"U","code":4919,"data":{}}
     */
    @RequestMapping("/addCourse")
    ResultEntity addCourse(@RequestParam("course") String course_) {
        Course course = JSON.parseObject(course_, Course.class);
        int[] weeks = course.getWeeks();
        for (int i = 0; i < weeks.length; i++) {
            Course res_course = courseService.selectByOpenidAndTime(course.getOpenid(), String.valueOf(weeks[i]), course.getDay(), course.getJieshu());
            if (res_course != null) {
                return ResultEntity.error("与现有课程冲突", res_course);
            }

        }
        int i = courseService.addCourse(course);
        if (i == 1) {
            return ResultEntity.success("ok", i);

        } else {
            return ResultEntity.error("error", (-1));
        }
    }

    /**
     * @api {POST} /course/deleteACourse deleteACourse
     * @apiVersion 1.0.0
     * @apiGroup CourseController
     * @apiName deleteACourse
     * @apiDescription 删除一节课 因为课程表没有主键 所以删除的时候必须保证每个字段都要相等
     * @apiParam (请求参数) {String} course course对象的json字符串
     * @apiParamExample {json} 请求参数示例
     * 先封装好一个course对象
     * var course = {
     * "openid": "oNTNQ5EVBLG1qFO2QfNGEm6hcdrk",
     * "courseName": "java",    课程名称 String
     * "classroom": "四区205",   教室 String
     * "weeks": [1,3,5,9, 12, 13, 14, 15, 16, 18],  上课周次 int数组
     * "day": 3, 周几上课 int
     * "jieshu": 4,  上课节数 上午8:00-10:00为第一节 一天五节课以此类推
     * "teacher": "陈景涛"  任课老师
     * }
     * 请求的时候应该是这样:
     * {
     * "course": JSON.stringify(course)
     * }
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"p0xc2AIN","code":8678,"data":{}}
     */
    @RequestMapping("/deleteACourse")
    ResultEntity deleteACourse(@RequestParam("course") String course_) {
        Course course = JSON.parseObject(course_, Course.class);
        System.out.println(course);
        int i = courseService.deleteACourse(course);
        if (i == 1) {
            return ResultEntity.success("ok", i);

        } else {
            return ResultEntity.error("error", (-1));
        }
    }

    /**
     * @api {POST} /course/deleteAllCourseByOpenid deleteAllCourseByOpenid
     * @apiVersion 1.0.0
     * @apiGroup CourseController
     * @apiName deleteAllCourseByOpenid
     * @apiDescription 清空课表 如果用户改变用户信息应该调用这个接口清空原有课表
     * @apiParam (请求参数) {String} openid openid唯一标识
     * @apiParamExample 请求参数示例
     * openid=O
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"o","code":119,"data":{}}
     */
    @RequestMapping("/deleteAllCourseByOpenid")
    ResultEntity deleteAllCourseByOpenid(@RequestParam("openid") String openid) {
        int i = courseService.deleteAllCourseByOpenid(openid);
        if (i == 1) {
            return ResultEntity.success("ok", i);

        } else {
            return ResultEntity.error("error", (-1));
        }

    }

    /**
     * @api {POST} /course/selectByOpenidAndWeeks selectByOpenidAndWeeks
     * @apiVersion 1.0.0
     * @apiGroup CourseController
     * @apiName selectByOpenidAndWeeks
     * @apiDescription 根据openid和周次来获取本周的课表
     * @apiParam (请求参数) {String} openid
     * @apiParam (请求参数) {String} week 第几周
     * @apiParamExample 请求参数示例
     * week=VZ&openid=L
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"OdaH","code":8126,"data":{}}
     */
    @RequestMapping("/selectByOpenidAndWeeks")
    ResultEntity selectByOpenidAndWeeks(@RequestParam("openid") String openid, @RequestParam("week") String week) {
        List<Course> courses = courseService.selectByOpenidAndWeeks(openid, week);
        if (courses != null) {
            return ResultEntity.success("ok", courses);
        } else {
            return ResultEntity.error("null", courses);
        }

    }
}
