package com.example.demo.test.controller;

import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "用户接口描述")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;


    @ApiOperation(value = "查询全部", notes = "无条件查询全部用户")
    @ApiImplicitParam(name = "name", value = "名称", paramType = "query ", dataType = "String" )
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> fibdAll(/*@RequestParam(name = "name") String name*/){
        List<User> list = userServiceImpl.findAll("");
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }

    @ApiOperation(value = "查询全部", notes = "无条件查询全部用户")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public List<User> findAllPage(@RequestParam(name = "na") String na,
                                  @RequestParam(name = "page") int page,
                                  @RequestParam(name = "size") int size){
        Pageable pageable = PageRequest.of(page, size);
        List<User> list = userServiceImpl.listPage(na, pageable);
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("size:"+list.size());
        return list;
    }

    @ApiOperation(value = "测试接收参数", notes = "测试接收参数")
    @ApiImplicitParam(name = "test", value = "body", paramType = "query ", dataType = "String" )
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public void test(@RequestBody List<User> userList){
        for (int i = 0; i <userList.size() ; i++) {
            System.out.println(userList.get(i));
            String param = userList.get(i).getMsg().toString();
            System.out.println("param = " + param);
            
            String array = userList.get(i).getArray().toString();
            System.out.println("array = " + array);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }
        System.out.println("end");

        String s = "";
        StringUtils.isBlank("");
        StringUtils.isEmpty("");
    }
}
