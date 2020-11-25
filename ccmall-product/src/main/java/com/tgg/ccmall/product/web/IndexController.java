package com.tgg.ccmall.product.web;

import com.tgg.ccmall.product.entity.CategoryEntity;
import com.tgg.ccmall.product.service.CategoryService;
import com.tgg.ccmall.product.vo.Catelog2Vo;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author tanguogang
 * @create 2020-07-28-16:51
 */
@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){
        //查出所有一级分类
        List<CategoryEntity> categoryEntities = categoryService.getLevel1Categorys();

        model.addAttribute("categorys",categoryEntities);
        return "index";
    }

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catelog2Vo>> getCatalogJson(){
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        RLock lock = redissonClient.getLock("my-lock");
        //加锁
        lock.lock();
        try {
            System.out.println("加锁成功，执行业务：" + Thread.currentThread().getId());
            Thread.sleep(30000);
        }catch (Exception e){

        }finally {
            //解锁
            System.out.println("释放锁：" + Thread.currentThread().getId());
            lock.unlock();
        }
        return "hello";
    }
}
