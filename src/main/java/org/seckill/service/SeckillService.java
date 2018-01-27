package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**业务接口:站在使用者(程序员)的角度设计接口
 * 三个方面:1.方法定义粒度，方法定义的要非常清楚2.参数，要越简练越好
 * 3.返回类型(return 类型一定要友好/或者return异常，我们允许的异常)
 * 2018-01-21 Created by liwanping
 */

public interface SeckillService {

    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 获取单个秒杀记录
     * @param SecKillId
     * @return
     */
    Seckill getById(long SecKillId);

    /**
     * 输出秒杀接口地址
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * 并告知使用方可能抛出异常
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException,SeckillCloseException,RepeatKillException;
}
