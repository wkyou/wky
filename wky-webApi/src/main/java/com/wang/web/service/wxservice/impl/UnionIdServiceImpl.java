package com.wang.web.service.wxservice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wang.web.utils.HttpClient;
import com.wang.web.pojo.User;
import com.wang.web.pojo.wxbean.WxServiceUnionIdDto;
import com.wang.web.service.wxservice.UnionIdService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 9:32
 * @描述:
 */
@Service
public class UnionIdServiceImpl implements UnionIdService {
    @Override
    public void getUnionId() {
        ArrayList<String> fwhOpenIds = new ArrayList<>();
        JSONObject result = new JSONObject();
        ArrayList<HashMap<String, String>> listUser = new ArrayList<>();
        String url="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
        for (String openid :fwhOpenIds){
            HashMap<String, String> user = new HashMap<>();
            user.put("openid",openid);
            user.put("lang","zh_CN");
            listUser.add(user);
        }
        result.put("list_user",listUser);
        String responseData = HttpClient.sendPost(url, result.toJSONString());
        WxServiceUnionIdDto wxServiceUnionIdDto = JSON.parseObject(responseData, WxServiceUnionIdDto.class);
        if (wxServiceUnionIdDto.getUserInfoList().size()>0){
            for (WxServiceUnionIdDto.UserInfo userInfo: wxServiceUnionIdDto.getUserInfoList()){

            }
        }

    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("小明");
        System.out.println(JSONObject.toJSONString(user));
    }
}
