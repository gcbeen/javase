package com.gcbeen.javastudy.thread;

public class TestStaticProxy {

    public static void main(String[] args) {
        WeddingCompany company = new WeddingCompany(new You());
        company.happyMary();
    }
}

// 结婚
interface Marry{
    void happyMary();
}

// 真实角色：你去结婚
class You implements Marry{
    @Override
    public void happyMary() {
        System.out.println(" gcbeen 结婚了……");
    }
}

// 代理角色:婚庆公司帮你结婚
class WeddingCompany implements Marry{
    private Marry target;   // 代理--->真实目标角色，帮谁结婚

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void happyMary() {
        before();
        this.target.happyMary();
        after();
    }

    private void before(){
        System.out.println("结婚前，布置现场！");
    }

    private void after(){
        System.out.println("结婚后，收尾款！");
    }

}
