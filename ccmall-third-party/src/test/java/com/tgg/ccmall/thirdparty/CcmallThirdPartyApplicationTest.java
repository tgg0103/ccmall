package com.tgg.ccmall.thirdparty;

import com.aliyun.oss.OSSClient;
import com.tgg.ccmall.thirdparty.component.SmsComponent;
import com.tgg.ccmall.thirdparty.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanguogang
 * @create 2020-07-20-22:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CcmallThirdPartyApplicationTest {

    @Test
    public void contedtLoads(){

    }

    @Resource
    private OSSClient ossClient;
    @Autowired
    private SmsComponent smsComponent;
    @Test
    public void testSendCode(){
        smsComponent.sendSmsCode("13317303233","888888");
    }

    @Test
    public void sendSms(){
        String host = "https://smssend.shumaidata.com";
        String path = "/sms/send";
        String method = "POST";
        String appcode = "7566647a0f1246beb58a0dbdbc8fac30";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("receive", "13317303233");
        querys.put("tag", "6789");
        querys.put("templateId", "MF640EBE0E");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            System.out.println("00000000000000000000000");
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testUpload() throws FileNotFoundException {
        String bucketName = "ccmall-tgg";
        String objectName = "hh.JPG";
        InputStream inputStream = new FileInputStream("F:\\照片\\DSC03340.JPG");
        ossClient.putObject(bucketName, objectName, inputStream);
        ossClient.shutdown();
        System.out.println("上传完成。。。。");
    }
}
