package com.tingyu.sparkmall;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingyu.sparkmall.entity.MemberEntity;
import com.tingyu.sparkmall.service.MemberService;
import com.tingyu.sparkmall.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author essionshy
 * @Create 2020/6/17 22:34
 * @Version renren-fast
 */
@Slf4j
@SpringBootTest(classes = {SparkmallMemberApplication.class})
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void testSave(){
        log.debug("保存会员开始...");
        MemberEntity member = new MemberEntity();
        member.setUsername("tom");
        member.setCreateTime(DateUtils.now());
        member.setCreateTime(DateUtils.now());
        memberService.save(member);
        log.debug("保存会员完成...");
    }

    @Test
    void testUpdateById(){
        log.debug("更新会员开始...");
        MemberEntity member = memberService.getById(1272856497092661254L);
        member.setDeleteStatus(0);
        memberService.updateById(member);
        log.debug("更新会员完成...");
    }

    @Test
    void testUpdateByBatch(){
        log.debug("批量更新删除状态开始...");
        QueryWrapper<MemberEntity> updateWrapper=new QueryWrapper<>();
        updateWrapper.eq("delete_status",null);
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setDeleteStatus(0);
        memberService.update(memberEntity,updateWrapper);
        log.debug("批量更新删除状态完成...");
    }
}
