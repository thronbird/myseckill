package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**��װ��ɱ����
 * 2018-01-21 Created by liwanping
 */
public class SeckillExecution {

    private long seckillId;

    //��ɱ���״̬
    private int state;

    //״̬��ʶ
    private String stateInfo;

    //��ɱ�ɹ�����
    private SuccessKilled successKilled;


    public SeckillExecution(long seckillId,SeckillStatEnum seckillStatEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state=seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum) {
        this.seckillId = seckillId;
        this.state=seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }


}
