package com.example.jingtao.contrller;

import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.utils.OnInputQueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/OnInputQuery")
public class OnInputQueryController {
    @Autowired
    private OnInputQueryUtils onInputQueryUtils;

    /**
     * @api {GET} /OnInputQuery/querySchool querySchool
     * @apiVersion 1.0.0
     * @apiGroup OnInputQueryController
     * @apiName querySchool
     * @apiDescription 查询学校
     * @apiParam (请求参数) {String} school
     * @apiParamExample 请求参数示例
     * school=OGLtUpepYh
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"6Tao","code":3641,"data":{}}
     */
    @RequestMapping("/querySchool")
    ResultEntity querySchool(@RequestParam("school") String school) {
        if (school.equals("")) {
            return ResultEntity.error("school为空", null);
        }
        List<String> list = onInputQueryUtils.querySchool(school);
        return ResultEntity.success("ok", list);

    }

    /**
     * @api {GET} /OnInputQuery/queryCollege queryCollege
     * @apiVersion 1.0.0
     * @apiGroup OnInputQueryController
     * @apiName queryCollege
     * @apiDescription 查询学院
     * @apiParam (请求参数) {String} school 在查询学院时学校应该是完整的
     * @apiParam (请求参数) {String} college
     * @apiParamExample 请求参数示例
     * college=OupVjDl&school=rRUX
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"0C6cziYQf9","code":8622,"data":{}}
     */
    @RequestMapping("/queryCollege")
    ResultEntity queryCollege(@RequestParam("school") String school, @RequestParam("college") String college) {
        if (college.equals("")) {
            return ResultEntity.error("college为空", null);
        }
        List<String> list = onInputQueryUtils.queryCollege(school, college);
        return ResultEntity.success("ok", list);
    }

    /**
     * @api {GET} /OnInputQuery/queryMajor queryMajor
     * @apiVersion 1.0.0
     * @apiGroup OnInputQueryController
     * @apiName queryMajor
     * @apiDescription 查询专业
     * @apiParam (请求参数) {String} school 应该完整
     * @apiParam (请求参数) {String} college 应该完整
     * @apiParam (请求参数) {String} major
     * @apiParamExample 请求参数示例
     * college=fhEcVmh&major=YakPzVhM&school=SyA2wvc
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"Y9utsoAeGn","code":5481,"data":{}}
     */
    @RequestMapping("/queryMajor")
    ResultEntity queryMajor(@RequestParam("school") String school, @RequestParam("college") String college, @RequestParam("major") String major) {
        if (major.equals("")) {
            return ResultEntity.error("major为空", null);
        }
        List<String> list = onInputQueryUtils.queryMajor(school, college, major);
        return ResultEntity.success("ok", list);
    }
}
