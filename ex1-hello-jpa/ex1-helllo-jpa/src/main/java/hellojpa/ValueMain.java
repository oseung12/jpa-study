package hellojpa;

public class ValueMain {

    public static void main(String[] args) {

        int a = 10;
        int b = a;  // b에 a값을 복사한다.

        a = 20;

        System.out.println("a = " + a); // a = 20
        System.out.println("b = " + b); // b = 10  // 값은 서고 공유되지 않는다.


        Integer c = new Integer(10);
        Integer d = c;  // 값이 복제되는 것이 아닌 주소값(참조값)만 넘어간다.

        c.setValue(20);

        System.out.println("c = " + c); // a = 20
        System.out.println("d = " + d); // b = 20  // 레퍼런스가 넘어가서 같은 인스턴스를 공유한다.


    }
}
