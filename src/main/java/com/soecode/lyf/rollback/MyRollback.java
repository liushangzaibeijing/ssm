package com.soecode.lyf.rollback;

public class MyRollback extends Throwable {

    public void doRollback(){
        System.out.println("事务回滚后的异常处理类");
    }
}
