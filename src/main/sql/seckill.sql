-- ��ɱִ�д洢����
DELIMITER $$ -- console ; ת��Ϊ$$
-- ����洢����
-- ���� in : ����   out:���
-- row_count() ������һ���޸����͵�sql Ӱ�������
-- row_count() 0:δ�޸�����   >0:�޸ĵ�����   <0:sql����/δִ���޸�sql
CREATE PROCEDURE `seckill`.`execute_seckill`
  (IN  v_seckill_id BIGINT,IN  v_phone BIGINT,
    IN v_kill_time TIMESTAMP,OUT r_result INT)
  BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION ;
    INSERT IGNORE INTO success_killed
    (seckill_id, user_phone,create_time)
      VALUES (v_seckill_id,v_phone,v_kill_time);
    select row_count() into insert_count;
    if(insert_count=0) THEN
      ROLLBACK ;
      set r_result=-1;
    ELSEIF (insert_count<0)THEN
      ROLLBACK ;
      set r_result=-2;
    ELSE
      UPDATE seckill
        SET number=number-1
      WHERE seckill_id=v_seckill_id
      AND end_time>v_kill_time
      and start_time<v_kill_time
      and number>0;
    select row_count() into insert_count;
      if(insert_count=0) THEN
        ROLLBACK ;
        SET r_result=0;
      ELSEIF (insert_count<0)THEN
        ROLLBACK ;
        set r_result=-2;
      ELSE
        COMMIT ;
        SET r_result=1;
      END IF;
    END IF;
  END;
-- �洢���̽���
DELIMITER ;
set @r_result=-3;
CALL execute_seckill(1003,17091032170,now(),@r_result);
-- �洢����
-- 1:�洢�����Ż�:�����м������е�ʱ��
-- 2:��Ҫ���������洢����
-- 3:�򵥵��߼�����Ӧ�ô洢����
-- 4:QPS һ����ɱ�� 6000/qps
/*
 �鿴procedure
 show create procedure execute_seckill;
 ɾ��procedure
 drop procedure execute_seckill;
 ����procedure
 call execute_seckill(xxxxxxxx);
  */

