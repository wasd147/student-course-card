package com.example.jingtao.contrller;

import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.entity.User;
import com.example.jingtao.entity.UserInf;
import com.example.jingtao.entity.UserPlus;
import com.example.jingtao.service.UserInfService;
import com.example.jingtao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfService userInfService;

    /**
     * @api {POST} /user/addAUser addAUser
     * @apiVersion 1.0.0
     * @apiGroup UserController
     * @apiName addAUser
     * @apiDescription 添加一个用户
     * @apiParam (请求参数) {String} openid openid给我 这是唯一标识用户的主键
     * @apiParam (请求参数) {String} school 学校
     * @apiParam (请求参数) {String} college 学院
     * @apiParam (请求参数) {String} major 专业
     * @apiParam (请求参数) {Number} grade 年级
     * @apiParam (请求参数) {String} banji 班级 class是关键字 所以用拼音了
     * @apiParamExample 请求参数示例
     * college=fdV2fP&major=wi5Db4O&school=Te0j&openid=L28gN&grade=6293&banji=88l
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"nSP0","code":2192,"data":{}}
     */
    @RequestMapping("/addAUser")
    ResultEntity addAUser(User user) {
        int i = userService.addAUser(user);
        if (i == 1) {
            return ResultEntity.success("添加用户成功", null);
        } else {
            return ResultEntity.error("添加用户失败", user);
        }
    }

    /**
     * @api {POST} /user/updateUser updateUser
     * @apiVersion 1.0.0
     * @apiGroup UserController
     * @apiName updateUser
     * @apiDescription 更新一个用户
     * @apiParam (请求参数) {String} openid openid
     * @apiParam (请求参数) {String} school 学校
     * @apiParam (请求参数) {String} college 学院
     * @apiParam (请求参数) {String} major 专业
     * @apiParam (请求参数) {Number} grade 年级
     * @apiParam (请求参数) {String} banji 班级
     * @apiParamExample 请求参数示例
     * college=nEnb0l8oaS&major=wPgxYW&school=My&openid=AzKJMlFW&grade=4591&banji=XbM
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"zr8xKba","code":4082,"data":{}}
     */
    @RequestMapping("/updateUser")
    ResultEntity updateUser(User user) {
        int i = userService.updateUser(user);
        if (i == 1) {
            return ResultEntity.success("更新用户成功", null);
        } else {
            return ResultEntity.error("更新用户失败", user);
        }
    }

    /**
     * @api {POST} /user/getUser getUser
     * @apiVersion 6.0.0
     * @apiGroup UserController
     * @apiName getUser
     * @apiDescription 根据openid获取用户信息 返回结果封装了一层 对象携带头像和昵称
     * @apiParam (请求参数) {String} openid 你存在微信里的openid
     * @apiParamExample 请求参数示例
     * openid=0Szk
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"wGaG5S6E","code":9797,"data":{}}
     */
    @RequestMapping("/getUser")
    ResultEntity getUser(String openid) {
        User user = userService.getUser(openid);
        UserInf userInf = userInfService.selectByOpenid(new UserInf(user.getOpenid(), null, null));
        if (user == null) {
            return ResultEntity.error("用户不存在", null);
        } else {
            return ResultEntity.success("查询成功", user.toUserPlus(userInf));
        }
    }

    /**
     * @api {POST} /user/selectByBanji selectByBanji
     * @apiVersion 6.0.0
     * @apiGroup UserController
     * @apiName selectByBanji
     * @apiDescription 返回你的同班同学信息 然后你可以去蹭他们选的课 返回结果封装了一层 对象携带头像和昵称
     * @apiParam (请求参数) {String} school 学校
     * @apiParam (请求参数) {String} college 学院
     * @apiParam (请求参数) {String} major 专业
     * @apiParam (请求参数) {String} grade 年级
     * @apiParam (请求参数) {String} banji 班级
     * @apiParamExample 请求参数示例
     * college=kAKfyeKoG&major=8F698WZ5&school=tB15T&grade=q&banji=pifj
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"jfH","code":2196,"data":{}}
     */
    @RequestMapping("/selectByBanji")
    ResultEntity selectByBanji(@RequestParam("school") String school, @RequestParam("college") String college, @RequestParam("major") String major, @RequestParam("grade") String grade, @RequestParam("banji") String banji) {
        List<User> users = userService.selectByBanji(school, college, major, Integer.parseInt(grade), banji);
        if (users.isEmpty()) {
            return ResultEntity.success("结果为空", users);
        } else {
//            return ResultEntity.success("ok", users);
            List<UserPlus> userPlusList = new ArrayList<>();
            for (User user : users) {
                UserInf userInf = userInfService.selectByOpenid(new UserInf(user.getOpenid(), null, null));
                userPlusList.add(user.toUserPlus(userInf));
            }
            return ResultEntity.success("ok", userPlusList);
        }

    }

    /**
     * @api {POST} /user/selectByGrade selectByGrade
     * @apiVersion 6.0.0
     * @apiGroup UserController
     * @apiName selectByGrade
     * @apiDescription 返回你的同年级同学信息 用来看他们的选课 蹭课 返回结果封装了一层 对象携带头像和昵称
     * @apiParam (请求参数) {String} school 学校
     * @apiParam (请求参数) {String} college 学院
     * @apiParam (请求参数) {String} major 专业
     * @apiParam (请求参数) {String} grade 年级
     * @apiParamExample 请求参数示例
     * college=wNr0k1QlT5&major=j08wL2zisa&school=UigO&grade=4168
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"RY","code":7171,"data":{}}
     */
    @RequestMapping("/selectByGrade")
    ResultEntity selectByGrade(@RequestParam("school") String school, @RequestParam("college") String college, @RequestParam("major") String major, @RequestParam("grade") String grade) {
        List<User> users = userService.selectByGrade(school, college, major, Integer.parseInt(grade));
        if (users.isEmpty()) {
            return ResultEntity.success("结果为空", users);
        } else {
            List<UserPlus> userPlusList = new ArrayList<>();
            for (User user : users) {
                UserInf userInf = userInfService.selectByOpenid(new UserInf(user.getOpenid(), null, null));
                userPlusList.add(user.toUserPlus(userInf));
            }
            return ResultEntity.success("ok", userPlusList);
        }
    }
}
