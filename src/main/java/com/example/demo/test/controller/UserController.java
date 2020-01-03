package com.example.demo.test.controller;

import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "用户接口描述")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


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

    /**
     *
     * @param test
     * @return
     */
    public String getValue(@RequestParam(name = "test") String test){
        return null;
    }


    @ApiOperation(value="对象的部分属性重新转换为集合", notes = "")
    @RequestMapping(value = "/objectToCollection", method = RequestMethod.GET)
    @ResponseBody
    public List<String> objectToCollection() throws Exception{
       List<String> lis = userServiceImpl.testColl();
        List<String> duplicateElements  = getDuplicateElements(lis);
        System.out.println("duplicateElements:" + duplicateElements);
//       JSONObject json = new JSONObject();
//       json.put("list","test");
//        if(lis.size() > 0){
//            throw new Exception(json.toString());
//        }
       return lis;
    }


    public static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream() // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());  // 转化为 List
    }
}
