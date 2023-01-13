package com.wang.web.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 创建基于httpclient的http请求工具类
 */
@Slf4j
public class HttpClient {
    public static JSONObject HttpGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        return new JSONObject(Boolean.parseBoolean(result));
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     * @param param
     * @return
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            System.out.println(urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定URL发送POST方法的请求
     *
     * @param url
     * @param param
     * @return
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("content-type", "application/json");
            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());
            //发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            //定义BufferedReader流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * post请求并得到返回结果
     *
     * @param requestUrl
     * @param requestMethod
     * @param output
     * @return
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String output) {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            if (null != output) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("UTF-8"));
                outputStream.close();
            }
            //从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

//    /**
//     * 医保接口请求
//     *
//     * @param url   地址
//     * @param json  数据
//     * @param cmdId 命令字id
//     * @return
//     */
//    public static String YBRequest(String url, JSONObject json, String cmdId) {
//        try {
//            String urlStr = "https://czyss.88fda.com:10072/gw/hco" + url;
////            String urlStr = "http://192.168.31.117:8092" + url;
//            log.info("医保请求地址:" + urlStr);
//            String bizid = "weixin";
//            String nonce = WXPayUtil.generateNonceStr();
//            JSONObject result = new JSONObject();
//            result.put("nonce", nonce);//随机字符串
//            result.put("bizid", bizid);//业务方id
//            result.put("cmdid", cmdId);//命令字id
//            result.put("channelNo", "MccuJVBGtImy1d");
//            result.put("reqStr", json.toString());
//
//            String sign = SignatureUtil.generatorSignStr(result);
//            log.info("加密签名:" + sign);
//            result.put("sign", sign);//签名
//
//            log.info("医保请求入参:" + result.toString());
//            String res = sendPost(urlStr, result.toString());
//            log.info("医保请求出参:" + res);
//            if (StringUtils.isBlank(res)) {
//                return null;
//            }
//            return res;
//        } catch (Exception e) {
//            log.error("统筹异常," + e.getMessage());
//            return null;
//        }
//    }

    public static void main(String[] args) throws Exception {
        String secureKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCDLyXQ8NopG2XflfWAuPdu6BBzWvbFj23vk3jfWXqjL9qqvOIY4zxyZgmv9lhtBVMcjAcMThD59PE4TbLu7uEsEYyn1WkhQSCWJloanZ/d9Of2WaiJw0zDws07zhxUgHo+l+sr6+sPlpoi6s7HZXRWZZyoRvbaQBpEi8QCe9blaLvzvJFtw/Zwkw6CkSpGHHfAd0Li/z+mjGnNdC6skosXS6g1I03/3P4xZIQDzHJTFLavgMukNIs+oce86GCK3QD0PqDqKGjmrmnXg/sd741WBGW1nCJbKK3hJTE3R4TdckucttFupmanUVcYTaoG8hFqAVRpSvcOleV4KlKAxM2hAgMBAAECggEATlX2MAnTTJ7Gu7gRrTdG0hyTzj6wg5K9pEWc9Uq6d/4YhsJaBWCUdP/HoyLo9NksIyze/JMVgh2peeS0CAfvwGAObR58M9ZvPhpSzff4QhN//NTXVsSf73pBEghnVHKQDRas4UJ00I8vJdCvf9RunzT4Umhl+jgzN2F6v7zxu3Vu+HnodYPJHziwHdFM83UCTfEk5WK2JEja35hDXJRgt7Vi86qQSjutM+PP7SoPlw9adiZ7xwOUoKxgC6ZIZWA3QSvrrTuPzCpaas6pgQeWhGX5KdJsBQ/vgzL3d48elN7b9ybooJUwSm4al/MTocPn3o2LvFVcNSm+7V7UpZXDUQKBgQDEiMa5ej7k/xvdB5ocyTjIg2DtimO0pWFoDTn8yt3XdgILyfNALFTk0Lo6M5Y0iigynmSUUHcDEBB4Qr9H05yzxtQ85vIsq+pPFlENbN6LHsXYE7zU8SlyKu2PXOuMuLf7y6gPNS1sOKEuL0tS8fEgIF0VPUN+HI/9R3/ciGOhjQKBgQCq4HV0a5EqaXQcK+b5rOQQw/t2ThkYp0FzFdP1a4Q4klA/C6p791b9UvlMGl2ucOpcPuTtnVy1Jxw/EIOJ2JbIL9/Agf2FR6HRISeziJgFUrVvHiShO68LVjmNEugFYimLODRGgK8hGErg1Fp2gG/lBPkiJfieqqSaKa5hCOuVZQKBgGGuTX8QWEQ+211vEtTt2jAmxD0sBERb0l8B++k99ybIu1mapTEnF4ami3iz/Rrd8/68pObmW1CFYnozSpjrfz4HO6ONcZ5sT8fBIsXWb4Gb6N9tZ/Q6bMwWs/4GQ/isMp2OalgsqQfZ2Zp33Ss7nwnFrB4LVglPLu3G5LD6hPJdAoGAB4OrZp08WwMcKgj8NUqXFO2pZ0Bz9hOU2zzAf3Bk9h/pC3y12JG975HwiJo4OG2awMe7RX/ADe9UXKmbPzqZFuCUFGEjBvNpeEre9hQxqzpB5EsNDVIUlokKKtwD/AifDxI/qkIKcYgh8tUjzUZEpWuckRXeYwvaBTWEB5xez8kCgYAv853hDOsnSNhcSkmRpkNHSdB1OVdkFTe4IehX0N7b5jRFUzdU/rLW50B80/rq5PqGeyBhLS6j6vxUVwFK8SRMUL5Fx/EW9iomwZf0oOKCbCFaYUqwFtYUELEsMR3sDj2gHoRW+FLM049hTDmpfmGcCn0z8Rmn4NdK9ynx7KN5sA==";
//        System.out.println(generatorSignKey("fas", "asd", secureKey));
        JSONObject json = new JSONObject();
        json.put("user_card_type", "1");//证件类型,1:身份证
        json.put("user_card_no", "123123");//证件号
        json.put("user_name", "asd");//姓名
//        System.out.println(HttpClient.YBRequest("/mi/info/cardquery", json, "cardquery"));
    }

}
