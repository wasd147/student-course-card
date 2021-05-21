package com.example.jingtao.contrller;

import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * @api {POST} /note/sendMsg sendMsg
     * @apiVersion 2.0.0
     * @apiGroup NoteController
     * @apiName sendMsg
     * @apiDescription 这个接口用来发送消息
     * @apiParam (请求参数) {String} sender 发送者的openid
     * @apiParam (请求参数) {String} accepter 接受者的openid
     * @apiParam (请求参数) {String} msg 这是要发送的文字
     * @apiParamExample 请求参数示例
     * msg=nriWTF1qxM&sender=ss8M1&accepter=9WBADw
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data 没有返回数据 返回null
     * @apiSuccessExample 响应结果示例
     * {"msg":"7tvtivC","code":1252,"data":{}}
     */
    @RequestMapping("/sendMsg")
    ResultEntity sendMsg(@RequestParam("sender") String sender, @RequestParam("accepter") String accepter, @RequestParam("msg") String msg) {
        noteService.sendMsg(sender, accepter, msg);
        return ResultEntity.success("ok", null);
    }

    /**
     * @api {GET} /note/getNotes getNotes
     * @apiVersion 2.0.0
     * @apiGroup NoteController
     * @apiName getNotes
     * @apiDescription 返回该openid的所有纸条记录
     * @apiParam (请求参数) {String} openid 这个用户的openid
     * @apiParamExample 请求参数示例
     * openid=Mxu06m2N
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg 这是给前端的提示
     * @apiSuccess (响应结果) {Object} data 这里面放的是一个map map为key 纸条对方 value 本用户与key用户的纸条记录list集合
     * @apiSuccessExample 响应结果示例
     * 查询jingtao的纸条记录 返回的map中分别是 xinyi，asvcvyewvyv，wasd 和jingtao的纸条记录
     * 纸条记录是一个封装好的对象
     * sender是发送者openid
     * accepter是接受者openid
     * message 内容
     * time 发送时间 在数据库是datatime对象 你可以根据这个来排序
     * look 发送时默认为0 当接收方看到消息时 该值修改为1 代表对方已读
     * {
     *     "code": 1,
     *     "msg": "ok",
     *     "data": {
     *         "xinyi": [
     *             {
     *                 "sender": "xinyi",
     *                 "accepter": "jingtao",
     *                 "message": "vsdvhbiewvebajosvh",
     *                 "time": "2021-05-15T14:03:19.000+00:00",
     *                 "look": 0
     *             },
     *             {
     *                 "sender": "jingtao",
     *                 "accepter": "xinyi",
     *                 "message": "hello",
     *                 "time": "2021-05-15T05:12:44.000+00:00",
     *                 "look": 0
     *             },
     *             {
     *                 "sender": "jingtao",
     *                 "accepter": "xinyi",
     *                 "message": "wasd",
     *                 "time": "2021-05-15T05:49:36.000+00:00",
     *                 "look": 0
     *             }
     *         ],
     *         "asvcvyewvyv": [
     *             {
     *                 "sender": "asvcvyewvyv",
     *                 "accepter": "jingtao",
     *                 "message": "wevgvwibciq",
     *                 "time": "2021-05-15T05:49:36.000+00:00",
     *                 "look": 0
     *             }
     *         ],
     *         "wasd": [
     *             {
     *                 "sender": "jingtao",
     *                 "accepter": "wasd",
     *                 "message": "wasd",
     *                 "time": "2021-05-15T05:58:01.000+00:00",
     *                 "look": 0
     *             }
     *         ]
     *     }
     * }
     */
    @RequestMapping("/getNotes")
    ResultEntity getNotes(@RequestParam("openid") String openid) {
        Map notes = noteService.getNotes(openid);

        return ResultEntity.success("ok", notes);
    }
}
