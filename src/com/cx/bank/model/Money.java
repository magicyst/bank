package com.cx.bank.model;

/**
 * 单例类Money,模拟银行的存款类型
 * Created by Administrator on 2018/6/12.
 */


public class Money {

    private double money = 100;  //钱的数量
    private boolean safa = true; //是否安全,如果money小于0则false,否则安全

    private static Money instance= null; //单例

    private Money() {} //私有构造方法,单例模式


    /**
     * 单例获取方式
     * @return 返回Money实例
     */
    public static Money getInstance(){

        //如果已经有money实例则返回实例，否则new一个实例返回
        if(instance == null)
            return new Money();

        return instance;
    }


    /*
     * 下面是geter and seter方法
     *
     */
    public double getMoney() {
        return money;
    }


    public void setMoney(double money) {
        this.money = money;
    }


    public boolean isSafa() {

        if(this.money < 0)
            this.safa = false;

        return safa;
    }


    public void setSafa(boolean safa) {
        this.safa = safa;
    }


}
