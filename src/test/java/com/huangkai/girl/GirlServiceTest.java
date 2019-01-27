package com.huangkai.girl;

import com.huangkai.girl.domain.Girl;
import com.huangkai.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)// 表示将在测试环境里面跑
@SpringBootTest//表示将启动整个工程
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(23);
        Assert.assertEquals(new Integer(23), girl.getAge());
    }
}
