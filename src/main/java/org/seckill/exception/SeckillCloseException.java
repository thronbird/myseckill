package org.seckill.exception;

/**��ɱ�ر��쳣
 * 2018-01-21 Created by liwanping
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
