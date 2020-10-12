package site.newvalue;

public class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包子铺正在做包子" + bz.pi + bz.xian);
                if (count % 2 == 0) {
                    // 冰皮  五仁
                    bz.pi = "冰皮";
                    bz.xian = "五仁";
                } else {
                    // 薄皮  牛肉大葱
                    bz.pi = "薄皮";
                    bz.xian = "牛肉大葱";
                }
                count++;
                bz.flag = true;
                bz.notify();
            }

        }
    }
}
