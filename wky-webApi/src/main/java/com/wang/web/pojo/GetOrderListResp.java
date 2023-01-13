package com.wang.web.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wang.web.utils.XstreamUtil;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**@author tanzibin
 * 描述:住院批量查询
 */
@Data
@ToString(callSuper = true)
public class GetOrderListResp extends Response{

    @XStreamAlias("result")
    private List<getOrderList> result1;

    @Data
    @XStreamAlias("item")
    public  static  class getOrderList{
        private String branchCode;
        @XStreamAlias("patName1")
        private String patName;
        private String patSex;
        private String patIdentificationId;
        private String patHisId;
        private String deptName;
        private String doctorName;
        private String transactionType;
        private String hisOrdNum;
        private String psOrdNum;
        private String agtOrdNum;
        private String agtCode;
        private String payTime;
        private String bizType;
        private String payChannel;
        private String payMode;
        private String payAmount;
        private String accountAmount;
        private String medicareAmount;
        private String insuranceAmount;
        private String totalAmount;
        private String ssFeeNo;
        private String ssBillNo;
        private String isInsurance;

    }

    public static void main(String[] args) {
        String str = "<response>\n" +
                "    <resultCode>0</resultCode>\n" +
                "    <resultMessage></resultMessage>\n" +
                "    <result>\n" +
                "        <item>\n" +
                "            <branchCode></branchCode>\n" +
                "            <patName1>黄俊</patName1>\n" +
                "            <patSex>M</patSex>\n" +
                "            <patIdentificationId>45212319991019311X</patIdentificationId>\n" +
                "            <patHisId>624247</patHisId>\n" +
                "            <deptName>内科诊室</deptName>\n" +
                "            <doctorName>梁蓓</doctorName>\n" +
                "            <transactionType>P</transactionType>\n" +
                "            <hisOrdNum>624247</hisOrdNum>\n" +
                "            <psOrdNum>HZZYDTGH2020122800021TEST</psOrdNum>\n" +
                "            <agtOrdNum>4200000805202012283625605523</agtOrdNum>\n" +
                "            <agtCode></agtCode>\n" +
                "            <payTime>2020/12/28 17:44:00</payTime>\n" +
                "            <bizType>01</bizType>\n" +
                "            <payChannel>05</payChannel>\n" +
                "            <payMode>01</payMode>\n" +
                "            <payAmount>500.00</payAmount>\n" +
                "            <accountAmount>500.00</accountAmount>\n" +
                "            <medicareAmount>0</medicareAmount>\n" +
                "            <insuranceAmount>0</insuranceAmount>\n" +
                "            <totalAmount>500.00</totalAmount>\n" +
                "            <ssFeeNo></ssFeeNo>\n" +
                "            <ssBillNo></ssBillNo>\n" +
                "            <isInsurance>0</isInsurance>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <branchCode></branchCode>\n" +
                "            <patName1>张胜男</patName1>\n" +
                "            <patSex>M</patSex>\n" +
                "            <patIdentificationId>440825199309198977</patIdentificationId>\n" +
                "            <patHisId>624248</patHisId>\n" +
                "            <deptName>内科诊室</deptName>\n" +
                "            <doctorName>梁蓓</doctorName>\n" +
                "            <transactionType>P</transactionType>\n" +
                "            <hisOrdNum>624248</hisOrdNum>\n" +
                "            <psOrdNum>HZZYDTGH2020122800022TEST</psOrdNum>\n" +
                "            <agtOrdNum>4200000806202012289888190879</agtOrdNum>\n" +
                "            <agtCode></agtCode>\n" +
                "            <payTime>2020/12/28 18:05:00</payTime>\n" +
                "            <bizType>01</bizType>\n" +
                "            <payChannel>05</payChannel>\n" +
                "            <payMode>01</payMode>\n" +
                "            <payAmount>5.00</payAmount>\n" +
                "            <accountAmount>5.00</accountAmount>\n" +
                "            <medicareAmount>0</medicareAmount>\n" +
                "            <insuranceAmount>0</insuranceAmount>\n" +
                "            <totalAmount>5.00</totalAmount>\n" +
                "            <ssFeeNo></ssFeeNo>\n" +
                "            <ssBillNo></ssBillNo>\n" +
                "            <isInsurance>0</isInsurance>\n" +
                "        </item></result></response>";
        GetOrderListResp getZyRegQueryResp = XstreamUtil.toBean(GetOrderListResp.class, str,"response");
        System.out.println(getZyRegQueryResp);
//          GetOrderListResp getZyRegQueryResp = (GetOrderListResp) XstreamUtil.simpleXmlToObject(str,GetOrderListResp.class);
//          System.out.println(getZyRegQueryResp);
    }
}
