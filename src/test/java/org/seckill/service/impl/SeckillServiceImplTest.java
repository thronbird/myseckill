package org.seckill.service.impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by codingBoy on 16/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})

public class SeckillServiceImplTest {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills=seckillService.getSeckillList();
        System.out.println(seckills);

    }

    @Test
    public void getById() throws Exception {

        long seckillId=1000;
        Seckill seckill=seckillService.getById(seckillId);
        System.out.println(seckill);
    }

    @Test(expected=RepeatKillException.class)
    //完整逻辑代码测试，注意可重复执行
    public void testSeckillLogic() throws Exception {
        logger.info("开始");
        long seckillId=1000;
        Date date=new Date();
        logger.info(String.valueOf(date.getTime()));
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed())
        {
            logger.info("exposer=",exposer);

            long userPhone=13476191876L;
            String md5=exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                logger.info("result=",seckillExecution);
            }catch (RepeatKillException e)
            {
                logger.error(e.getMessage());
                throw e;
            }catch (SeckillCloseException e1)
            {
                logger.error(e1.getMessage());
                throw e1;
            }
        }else {
            //秒杀未开启
            logger.info("exposer=",exposer);
        }
    }

    @Test
    public void executeSeckill() throws Exception {

        long seckillId=1000;
        String md5="bf204e2683e7452aa7db1a50b5713bae";


    }

}