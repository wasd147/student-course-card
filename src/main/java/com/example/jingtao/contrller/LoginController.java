package com.example.jingtao.contrller;

import com.alibaba.fastjson.JSON;
import com.example.jingtao.entity.ResultEntity;
import com.example.jingtao.entity.Token;
import com.example.jingtao.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TokenMapper tokenMapper;


    /**
     * @api {POST} /login login
     * @apiVersion 1.0.0
     * @apiGroup LoginController
     * @apiName login
     * @apiDescription 这个接口用来登录 返回用户的openid token 保存
     * @apiParam (请求参数) {String} code 你调用完wx.login把这个code发给我
     * @apiParamExample 请求参数示例
     * code=OgLU
     * @apiSuccess (响应结果) {Number} code 1为成功 -1为失败 0为需要登录
     * @apiSuccess (响应结果) {String} msg 给你的提示信息
     * @apiSuccess (响应结果) {Object} data 返回的数据都封装在这个对象里
     * @apiSuccessExample 响应结果示例
     * {"msg":"6SdzECs","code":9757,"data":{}}
     */
    @RequestMapping("/login")
    ResultEntity login(@RequestParam("code") String code) {
        System.out.println(code);


        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appid", "wx1309577b6931b6cf");
        paramMap.put("secret", "1f6b01eaf73c72e2da1d6f578f6f8b01");
        paramMap.put("code", code);

        String result = this.restTemplate.getForObject(url, String.class, paramMap);

        Map<String, String> map = JSON.parseObject(result, HashMap.class);

        String openid = map.get("openid");
        String session_key = map.get("session_key");
        UUID uuid = UUID.randomUUID();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);

        tokenMapper.insert(new Token(uuid.toString(), session_key, openid, time));


        Map<String, String> map1 = new HashMap<>();
        map1.put("token", uuid.toString());
        map1.put("openid", openid);

        return ResultEntity.success("success", map1);
        //return "hello";

    }
}
