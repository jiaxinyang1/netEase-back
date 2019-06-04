package com.hakurei.service;
import com.hakurei.util.RsaEncrypt;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName NetEaseService
 * @Description TODO 这个服务负责从网易云的API获取数据
 * @Author hakurei
 * @Date 2019/1/28
 * @Version 1.0
 */
@Service
public class NetEaseService {

    //login
    // https://music.163.com/weapi/login?csrf_token=

    /**
     * @Author hakurei
     * @Description //TODO  云搜索
     * @Date 12:19 2019/2/6
     * @Param [params]
     * @return java.lang.String
     **/
    public String getSuggest(String params){
        String url ="https://music.163.com/weapi/cloudsearch/get/web?csrf_token=";
        return getParams(params,url);
    }

    /**
     * @Author hakurei
     * @Description //TODO 获取歌曲详细数据
     * @Date 12:19 2019/2/6
     * @Param [params]
     * @return java.lang.String
     **/
    public String getMusicDetail(String params)  {
        String url ="http://music.163.com/weapi/song/enhance/player/url?csrf_token=";
        return getParams(params,url);

    }
    /**
     * @Author hakurei
     * @Description //TODO 获取歌单歌曲信息
     * @Date 12:19 2019/2/6
     * @Param [params]
     * @return java.lang.String
     **/
    public String getPlayListDetail(String params){
        String url ="https://music.163.com/weapi/v3/playlist/detail?csrf_token=";
        return getParams(params,url);
    }

    /**
     * @Author hakurei
     * @Description //TODO 获取所有歌单的信息
     * @Date 17:01 2019/2/6
     * @Param [params]
     * @return java.lang.String
     **/
    public String getPlayLists(String params){
        String url ="https://music.163.com/weapi/user/playlist?csrf_token=";
        return  getParams(params,url);
    }
    
    /**
     * @Author hakurei
     * @Description //TODO 打包参数访问api
     * @Date 12:20 2019/2/6
     * @Param [params, url]
     * @return java.lang.String
     **/
    private String getParams(String params,String url) {
        String  secKey = "be88887d941ea4b7";
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        String requestBody =params+"&encSecKey="+ RsaEncrypt.rsaEncrypt(secKey);
        System.out.println(RsaEncrypt.rsaEncrypt(secKey));
        Response response=null;
        OkHttpClient httpClient = new OkHttpClient();
        Request request = null;
        try {
            request = new Request.Builder().url(url).post(RequestBody.create(mediaType,requestBody.getBytes("utf-8"))).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            response =httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.isSuccessful()){

            try {
                byte[] b = response.body().bytes();
                return new String(b,"utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }




}
