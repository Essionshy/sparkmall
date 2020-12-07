package com.tingyu.sparkmall.member;


import com.tingyu.sparkmall.member.entity.MemberLevelEntity;
import com.tingyu.sparkmall.member.service.MemberLevelService;
import com.tingyu.sparkmall.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void testInsertMemberLevle() {
        MemberLevelEntity memberLevelEntity = new MemberLevelEntity();

        memberLevelEntity.setCode("2000");
        memberLevelEntity.setDescription("青铜");

        boolean save = memberLevelService.save(memberLevelEntity);
        log.info("保存成功：【{}】", save);

    }
}
