package com.tingyu.sparkmall;

import com.tingyu.sparkmall.entity.MemberEntity;
import com.tingyu.sparkmall.entity.MemberLevelEntity;
import com.tingyu.sparkmall.service.MemberLevelService;
import com.tingyu.sparkmall.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest(classes = {SparkmallMemberApplication.class})
class SparkmallMemberApplicationTests {

    @Autowired
    MemberService memberService;


    @Autowired
    MemberLevelService memberLevelService;

    @Test
    void contextLoads() {

    }

    @Test
    void testInsertMemberLevle(){
        MemberLevelEntity memberLevelEntity = new MemberLevelEntity();

        memberLevelEntity.setCode(2000);
        memberLevelEntity.setDescription("青铜");
        memberLevelEntity.setCreateTime(new Date());
        memberLevelEntity.setUpdateTime(new Date());
        boolean save = memberLevelService.save(memberLevelEntity);
        log.info("保存成功：【{}】",save);

    }
}
