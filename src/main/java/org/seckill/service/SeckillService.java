package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**ҵ��ӿ�:վ��ʹ����(����Ա)�ĽǶ���ƽӿ�
 * ��������:1.�����������ȣ����������Ҫ�ǳ����2.������ҪԽ����Խ��
 * 3.��������(return ����һ��Ҫ�Ѻ�/����return�쳣������������쳣)
 * 2018-01-21 Created by liwanping
 */

public interface SeckillService {

    /**
     * ��ѯ������ɱ��¼
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * ��ȡ������ɱ��¼
     * @param SecKillId
     * @return
     */
    Seckill getById(long SecKillId);

    /**
     * �����ɱ�ӿڵ�ַ
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * ִ����ɱ����
     * ����֪ʹ�÷������׳��쳣 ͨ���쳣��֪spring�Ƿ��ύ����
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException,SeckillCloseException,RepeatKillException;
    /**
     * ִ����ɱ����
     * ����֪ʹ�÷������׳��쳣 ����Ǵ洢�������������쳣
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) ;

}
