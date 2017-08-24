package com.wylie.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wylie.entity.UserEntity;
import com.wylie.enums.UserSexEnum;
import com.wylie.mapper.UserMapper;
import com.wylie.services.UserService;


@Controller
public class ThymeleafController extends BasePageController{
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate redisTemplate;
    
    @RequestMapping("/login")
	public String login(Model model) throws InterruptedException {
    	model.addAttribute("greeting", "login");
		return "login";
	}
	
/*    @RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,Map<String, Object> map, Model model) throws InterruptedException {
    	String exception = (String) request.getAttribute("shiroLoginFailure");
    	 
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
               System.out.println("UnknownAccountException -- > 账号不存在：");
               msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
               System.out.println("IncorrectCredentialsException -- > 密码不正确：");
               msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
               System.out.println("kaptchaValidateFailed -- > 验证码错误");
               msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
               msg = "else >> "+exception;
               System.out.println("else -- >" + exception);
            }
        }
        map.put("greeting", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
	}*/
    
    @RequestMapping("/")
	public String hel(Locale locale, Model model) throws InterruptedException {
		model.addAttribute("greeting", "hi"+userService.getPort());
		return "index";
	}
    
    @RequestMapping("/index")
	public String hello(Locale locale, Model model) throws InterruptedException {
		model.addAttribute("greeting", "hi");
		stringRedisTemplate.opsForValue().set("aaa", "111");

        String a = stringRedisTemplate.opsForValue().get("aaa");
        UserEntity user=new UserEntity("aa@126.com", "aa", UserSexEnum.MAN);
        ValueOperations<String, UserEntity> operations=redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists2=redisTemplate.hasKey("com.neox");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        List<UserEntity> list2 = (List<UserEntity>) redisTemplate.opsForValue().get("allUser");
        String b = operations.get("com.neox").getUserName();
		return "index";
	}

    @RequestMapping("/changelanguage/{lang}")
    public String changeSessionLanauage(HttpServletRequest request,HttpServletResponse response,@PathVariable String lang){
              System.out.println(lang);
       LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
       if("zh".equals(lang)){
           localeResolver.setLocale(request, response, new Locale("zh", "CN"));
       }else if("en".equals(lang)){
           localeResolver.setLocale(request, response, new Locale("en", "US"));
       }
       return "redirect:/hi";
    }
}