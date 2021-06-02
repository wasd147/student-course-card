package com.example.jingtao.contrller;

import com.example.jingtao.entity.Contacter;
import com.example.jingtao.entity.NotePlus;
import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
     * @api {POST} /note/getContacter getContacter
     * @apiVersion 9.0.0
     * @apiGroup NoteController
     * @apiName getContacter
     * @apiDescription 用户获取联系人列表  并判断是否有新消息
     * @apiParam (请求参数) {String} openid
     * @apiParamExample 请求参数示例
     * openid=8wQwAPbQ
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {String} response.openid 联系人openid
     * @apiSuccess (响应结果) {String} response.nickname 联系人昵称
     * @apiSuccess (响应结果) {String} response.headImg 联系人头像
     * @apiSuccess (响应结果) {Number} response.note 该联系人是否发来了新消息   0为存在新消息，需要提醒用户查看   1为没有
     * @apiSuccessExample 响应结果示例
     * [{"note":405,"headImg":"i","openid":"EFNAlgyn","nickname":"IewaH565"}]
     */
    @RequestMapping("/getContacter")
    List<Contacter> getContacter(@RequestParam("openid") String openid) {
        List<Contacter> contacter = noteService.getContacter(openid);
        return contacter;
    }

    /**
     * @api {POST} /note/getNotes getNotes
     * @apiVersion 9.0.0
     * @apiGroup NoteController
     * @apiName getNotes
     * @apiDescription 得到你与这个联系人的聊天记录
     * @apiParam (请求参数) {String} myOpenid 本用户的openid
     * @apiParam (请求参数) {String} otherOpenid 联系人的openid
     * @apiParamExample 请求参数示例
     * otherOpenid=t3SbbacodQ&myOpenid=tmWc
     * @apiSuccess (响应结果) {Array} response
     * @apiSuccess (响应结果) {Object} response.sender 发送者对象
     * @apiSuccess (响应结果) {String} response.sender.openid
     * @apiSuccess (响应结果) {String} response.sender.nickname
     * @apiSuccess (响应结果) {String} response.sender.headImg
     * @apiSuccess (响应结果) {Object} response.accepter 接受者对象
     * @apiSuccess (响应结果) {String} response.accepter.openid
     * @apiSuccess (响应结果) {String} response.accepter.nickname
     * @apiSuccess (响应结果) {String} response.accepter.headImg
     * @apiSuccess (响应结果) {String} response.message 消息内容
     * @apiSuccess (响应结果) {String} response.time 发送消息 的时间
     * @apiSuccess (响应结果) {Number} response.look 该消息是否已被接受者读到   已读为1  未读为0
     * @apiSuccessExample 响应结果示例
     * [{"sender":{"headImg":"4Spr","openid":"NOB8tLM","nickname":"RW7M"},"accepter":{"headImg":"Ot","openid":"Bz","nickname":"6"},"time":"l","message":"iv9uvCG28E","look":5952}]
     */
    @RequestMapping("/getNotes")
    List<NotePlus> getNotes(@RequestParam("myOpenid") String myOpenid, @RequestParam("otherOpenid") String otherOpenid) {
        List<NotePlus> notes = noteService.getNotes(myOpenid, otherOpenid);
        return notes;
    }
}
