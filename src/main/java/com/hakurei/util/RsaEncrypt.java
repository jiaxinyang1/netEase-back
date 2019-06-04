package com.hakurei.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @ClassName RsaEncrypt
 * @Description TODO
 * @Author hakurei
 * @Date 2019/2/2
 * @Version 1.0
 */
@Component
public class RsaEncrypt {


    public static String rsaEncrypt(String text){
        String modulus ="00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
        StringBuilder src = new StringBuilder(text).reverse();
        StringBuilder sb =new StringBuilder();

        for (int i=0;i<src.length();i++){
            sb.append(Integer.toHexString((int)src.charAt(i)));
        }
        BigInteger bg1 =new BigInteger(sb.toString(),16);
        BigInteger temp =bg1.modPow(new BigInteger("65537"),new BigInteger(modulus,16));
        String res =temp.toString(16);
        while (res.startsWith("0")){
            res =res.substring(1);
        }
        return res;
    }
}
