package com.atguigu.gulimall.product;

//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * OSS+SpringCloud使用步骤：
 * 1、引入oss-starter
 * 2、配置key，endpoint相关信息即可
 * 3、使用OSSClient进行相关操作
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

//    @Autowired
//    OSSClient ossClient;

    @Test
    public void testFindPath(){
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("完整路径：{}", Arrays.asList(catelogPath));
    }

    @Test
    public void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("华为");


        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功....");

//        brandService.updateById(brandEntity);


//        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
//        list.forEach((item) -> {
//            System.out.println(item);
//        });

    }

    /**
     * 这是最原始的上传方式，项目中不用。
     * 后来，统一放到第三方服务的微服务中，这里全部移除。
     */
//    @Test
//    public void testUploadOSS(){
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//        String accessKeyId = "LTAI4G2Mwo4nNWZwiBeiaM4B";
//        String accessKeySecret = "eZ5Qwzlb3Cuk1P0qo3U72XKmLKfFyL";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        String fileName = "C:\\Users\\siegfried\\Pictures\\Saved Pictures\\123.jpg";
//        // 上传文件流。
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(fileName);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ossClient.putObject("siegfried-mall", "img01.jpg", inputStream);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//        System.out.println("上传完成...");
//    }

//    @Test
//    public void testUploadWithStarter(){
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("C:\\Users\\siegfried\\Pictures\\Saved Pictures\\234.jpg");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ossClient.putObject("siegfried-mall", "img02.jpg", inputStream);
//        // 关闭OSSClient。
//        ossClient.shutdown();
//        System.out.println("上传完成...");
//    }

}
