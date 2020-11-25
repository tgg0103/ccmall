package com.tgg.ccmall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tgg.ccmall.product.entity.BrandEntity;
import com.tgg.ccmall.product.service.BrandService;
import com.tgg.ccmall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author tanguogang
 * @create 2020-07-16-21:55
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CcmallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    /*@Autowired
    private OSSClient ossClient;*/

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void redisson(){
        System.out.println(redissonClient);
    }

    @Test
    public void testStringRedisTemplate(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello","world" + UUID.randomUUID().toString());
        String hello = ops.get("hello");
        System.out.println(hello);

    }

    @Test
    public void testFindPath(){
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("完整路径：{}" + Arrays.asList(catelogPath));
    }

    @Test
    public void testUpload() throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        //String endpoint = "oss-cn-shanghai.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        //String accessKeyId = "LTAI4GJctNnLnYM1KhQYZhct";
        //String accessKeySecret = "Lm4Os1zNC5fWkaPVS1TWgRy15zv17O";
        String bucketName = "ccmall-tgg";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "dd.JPG";

        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        InputStream inputStream = new FileInputStream("F:\\照片\\DSC03340.JPG");
        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        //String content = "F:\\照片\\DSC03330.JPG";
        //ossClient.putObject(bucketName, objectName, inputStream);

        // 关闭OSSClient。
        //ossClient.shutdown();
        System.out.println("上传完成。。。。");
    }

    @Test
    public void contextLoads(){

        /*BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功。。。。。。。。。");*/

        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach((item) ->{
            System.out.println(item);
        });

    }

    @Test
    public void test(){

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
