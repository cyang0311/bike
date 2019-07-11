package com.example.bike.Controller;

import com.example.bike.Entity.User;
import com.example.bike.Service.UserService;
import com.example.bike.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired//按类型注入
    private UserService userService;

    @RequestMapping("/user/getCode")
    @ResponseBody
    public boolean genVerfyCode(String countryCode,String phoneNum) {
        System.out.println(phoneNum);
        boolean flag = userService.senMsg(countryCode,phoneNum);
        return flag;
    }
    @RequestMapping("/user/verify")
    @ResponseBody
    public boolean verify(String phoneNum, String verifyCode){
        return userService.verify(phoneNum,verifyCode);
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public boolean reg(@RequestBody User user){//wx提交参数为json类型，@RequestBody将json数据set到实体类中
        boolean flag = true;
        try {
            //调用service，保存用户信息
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;

    }

    @RequestMapping("/user/deposit")
    @ResponseBody
    public boolean deposit(@RequestBody User user){
        boolean flag = true;
        try {
            userService.update(user);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return  flag;
    }

    @RequestMapping
    @ResponseBody
    public boolean identify(@RequestBody User user){
        boolean flag = true;
        try {
            userService.update(user);
        } catch (Exception e) {
            flag = false;;
            e.printStackTrace();
        }
        return flag;
    }
}
