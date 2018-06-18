package com.cx.bank.manager;

import com.cx.bank.model.Money;

/**
 * Created by Administrator on 2018/6/12.
 */
public class ManagerImpl {

    /**
     * 系统业务：
     *      1.银行金额的查询
     *      2.用户存款
     *      3.用户取款
     */
    private Money instance = null; //存款类型的依赖

    public ManagerImpl(){

        //依赖构造方式注入
        this.instance = Money.getInstance();
    }

    /**
     * 实现系统的存款的查询
     * @return 如果余额小于0返回-1,否则返回存款余额
     */
    public double seleMoney(){

        //如果余额小于0，设置当前状态为不安全，方法返回-1。
        if(this.instance.getMoney() < 0){

            this.instance.setSafa(false);
            return -1;
        }else
            //安全这返回余额
            return this.instance.getMoney();

    }

    /**
     * 实现存款业务
     * @param money
     * @return 首先判断money为安全，否则返回-1.如果存储的金额小于等于0返回-1，否则存储成功返回成功的数额
     */
    public double saveMoney(double money){

        if(!this.instance.isSafa())
            return -1;

        if(money <= 0)
            return -1;

        this.instance.setMoney(this.instance.getMoney()+money);
        return this.instance.getMoney();
    }

    /**
     * 实现取款业务
     * @return 如果money实例不安全返回-1，否则返回获取的金额。判断获取的金额是否为负，范鸥-1，否则返回金额
     */
    public double getMoney(double money){

        if(!this.instance.isSafa())
            return -1;

        if(money <= 0 || money > this.seleMoney())
            return -1;

        double temp = this.instance.getMoney();
        this.instance.setMoney(temp-money);

        return temp;
    }


}
