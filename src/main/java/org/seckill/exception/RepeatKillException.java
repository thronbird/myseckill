package org.seckill.exception;

/**�ظ���ɱ�쳣 �������쳣
 * 2018-01-21 Created by liwanping
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
