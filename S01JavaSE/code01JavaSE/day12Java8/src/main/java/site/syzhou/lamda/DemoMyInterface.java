package site.syzhou.lamda;

public class DemoMyInterface {
    // 使用自定义的函数式接口作为方法参数
    public static void interfaceAsArgs(MyInterface myInterface) {
        myInterface.show();
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        interfaceAsArgs(myInterface);
        interfaceAsArgs(new MyInterface() {
            @Override
            public void show() {
                System.out.println("匿名内部类作参数");
            }
        });
        interfaceAsArgs(() -> {
            System.out.println("Lamda");
        });
    }
}
