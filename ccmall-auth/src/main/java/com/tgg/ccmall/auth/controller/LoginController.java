package com.tgg.ccmall.auth.controller;

import com.tgg.ccmall.auth.feign.ThirdPartFeignService;
import com.tgg.ccmall.auth.vo.UserRegistVo;
import com.tgg.common.constant.AuthConstant;
import com.tgg.common.exception.BizCodeEnume;
import com.tgg.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author tanguogang
 * @create 2020-08-05-15:04
 */
@Controller
public class LoginController {

    @Autowired
    ThirdPartFeignService thirdPartFeignService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @GetMapping("/sms/sendcode")
    public R sendCode(@RequestParam("phone") String phone){

        String redisCode = redisTemplate.opsForValue().get(AuthConstant.SMS_CODE_CHCHE_PREFIX + phone);
        if(!StringUtils.isEmpty(redisCode)){
            long l = Long.parseLong(redisCode.split("_")[1]);
            if(System.currentTimeMillis() - l < 60000){
                //60秒内不能再发
                return R.error(BizCodeEnume.SMS_CODE_EXCEPTION.getCode(),BizCodeEnume.SMS_CODE_EXCEPTION.getMsg());
            }
        }

        //1.接口防刷
        String code = UUID.randomUUID().toString().substring(0,5) + "_" + System.currentTimeMillis();

        //2.验证码的再次校验，redis。存key phone value-code
        redisTemplate.opsForValue().set(AuthConstant.SMS_CODE_CHCHE_PREFIX + phone,code,10, TimeUnit.MINUTES);
        thirdPartFeignService.sendCode(phone,redisCode.split("_")[0]);
        return R.ok();
    }


    /**
     * //TODO 重定向携带数据，利用session原理。将数据放在session中，
     * 只要跳到下一个页面取出数据以后，session里面的数据就会删掉
     *
     * //TODO 分布式下session问题
     * RedirectAttributes redirectAttributes:模拟重定向携带数据
     * @param vo
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, BindingResult result,
                         RedirectAttributes redirectAttributes){
        if(result.hasErrors()){

            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

            //model.addAttribute("errors",errors);
            redirectAttributes.addFlashAttribute("errors",errors);
            //校验出错，转发到注册页
            return "redirect:http://auth.ccmall.com/reg.html";
        }

        //
        //注册成功回到首页，回到登录页

        return "redirect:/login.html";
    }
}
