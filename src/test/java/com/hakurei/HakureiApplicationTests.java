package com.hakurei;

import com.hakurei.service.NetEaseService;
import com.hakurei.util.RsaEncrypt;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HakureiApplicationTests {

    @Autowired
    NetEaseService netEaseService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testRsa(){
        String res ="be7e5ba35f95dc2c219b649a94eb88a232ffc77816559bd55d3937d9d2b0afa5af97880e6bc722cbce861ed541d8cb26c71eee317096e60ea5ad1e0b2b08f16a4c0d59101a3b9f70d851202d9393ba9981d13a9e97bb8d909ed0fb26db07db6149ca91ac8d5e0203a92d76ecbb06a3f21cc1b2a84fedae2b6778789b2a2be068";
        TestCase.assertEquals(res,RsaEncrypt.rsaEncrypt("be88887ea4b7"));

    }


}

