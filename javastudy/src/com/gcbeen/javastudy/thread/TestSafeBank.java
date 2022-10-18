package com.gcbeen.javastudy.thread;

// 安全的取钱 同步块
public class TestSafeBank {

    public static void main(String[] args) {
        SafeAccount account = new SafeAccount(100, "养老基金");
        SafeDrawing drawing = new SafeDrawing(account, 60, "夸克");
        SafeDrawing same = new SafeDrawing(account, 60, "same");
        drawing.start();
        same.start();
    }

}


class SafeAccount {
    int money;  // 余额
    String cardName;    // 卡名

    public SafeAccount(int money, String cardName) {
        this.money = money;
        this.cardName = cardName;
    }
}

class SafeDrawing extends Thread {
    SafeAccount account;    // 账户
    int drawingMoney;   // 取余额
    int nowMoney;   // 个人手里的钱

    public SafeDrawing(SafeAccount account, int drawingMoney, String name) {
        // super(name) =  父类构造方法(name)
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    // 取钱
    @Override
    public void run() {
        // 锁的对象就是变量的量,需要增删改查的对象
        synchronized (account) {
            // 判断是否有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "余额不足,不能进行取钱");
                return;
            }
            try {
                Thread.sleep(1000); // 放大问题的发生性
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 卡内金额 = 余额 - 个人手里的钱
            account.money = account.money - drawingMoney;
            // 个人手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.cardName + "余额为:" + account.money);
            // this.getName()==Thread.currentThread().getName()
            System.out.println(this.getName() + "手里的钱:" + nowMoney);
        }
    }
}
