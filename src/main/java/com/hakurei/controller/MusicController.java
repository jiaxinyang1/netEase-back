package com.hakurei.controller;

import com.hakurei.service.NetEaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName MusicController
 * @Description TODO
 * @Author hakurei
 * @Date 2019/1/28
 * @Version 1.0
 */
@Controller
@RequestMapping("music")
public class MusicController {

    @Autowired
    NetEaseService netEaseService;



    @RequestMapping("/detail")
    @ResponseBody
    public String  getDetail(@RequestBody Map<String,String> params){
        String par =params.get("params");
        return  netEaseService.getMusicDetail("params="+par);


    }
    @RequestMapping("/suggest")
    @ResponseBody
    public String getSuggest(@RequestBody Map<String ,String> params){
        String par =params.get("params");
        return  netEaseService.getSuggest("params="+par);
    }
    @RequestMapping("/playListDetail")
    @ResponseBody
    public String getPlayListDetail(@RequestBody Map<String ,String> params){
        String par =params.get("params");
        return  netEaseService.getPlayListDetail("params="+par);
    }

    @RequestMapping("/allPlayList")
    @ResponseBody
    public  String getPlayLists(@RequestBody Map<String ,String> params){
        String par =params.get("params");
        return  netEaseService.getPlayLists("params="+par);
    }
    @RequestMapping("/test")
    @ResponseBody
    public  String test(){
        String par ="455";
        System.out.println("asdasd");
        return  netEaseService.getPlayLists("params="+par);
    }
}
