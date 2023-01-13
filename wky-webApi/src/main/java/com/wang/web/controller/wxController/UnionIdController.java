package com.wang.web.controller.wxController;

import com.wang.web.utils.WxEeventType;
import com.wang.web.utils.WxMessageType;
import com.wang.web.pojo.wxbean.WxServiceMsgDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 9:47
 * @描述:
 */
@RestController
public class UnionIdController {
    @RequestMapping(value = "onFollowCallback",method = {RequestMethod.POST, RequestMethod.GET})
    public String getUnionId(@RequestParam(value = "signature", required = false) String signature,
                @RequestParam(value = "timestamp", required = false) String timestamp,
                @RequestParam(value = "echostr", required = false) String echostr,
                @RequestBody(required = false) WxServiceMsgDto wxServiceMsgDto) {
            if (StringUtils.isNotEmpty(echostr)) {
                // 用于微信校验接口存在性，必须返回echostr
                return echostr;
            }
            // 只处理订阅与取消订阅消息
            if (null != wxServiceMsgDto && StringUtils.isNotEmpty(wxServiceMsgDto.getMsgType()) &&
                    StringUtils.isNotEmpty(wxServiceMsgDto.getEvent())) {
                String msgType = wxServiceMsgDto.getMsgType();
                String event = wxServiceMsgDto.getEvent();
                boolean isSubcribe = WxMessageType.EVENT.getCode().equals(msgType) &&
                        (WxEeventType.SUBSCRIBE.getCode().equals(event)
                                || WxEeventType.UNSUBSCRIBE.getCode().equals(event));
                if (isSubcribe) {
                    WxEeventType wxEeventType = WxEeventType.SUBSCRIBE.getCode().equals(event) ? WxEeventType.SUBSCRIBE : WxEeventType.UNSUBSCRIBE;
//                    wxService.onFollowCallback(wxServiceMsgDto, wxEeventType);
                }
            }
        return "";
    }
}
