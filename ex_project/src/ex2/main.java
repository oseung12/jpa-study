package ex2;

public class main {

    public static void main(String[] args) {

        // 피보나치 수열을 출력한다.
        // An = An-1 + An-2
        // 1 1 2 3 5 8 13 21 34 ....
        // 배열, for 을 사용하여 구현한다.


        int[] arr = new int[100];

        // 1. 배열 사용
        // An = An-1 + An-2; n>=3
        //a1 = 1, a2 = 1
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i < 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(arr[i] + " ");
        }


        // 2.이전항의 숫자를 기억하고 출력한다.
        // An
        // An = An-1 + An-2; n>=3
        // a1 = 1, a2 = 1
        System.out.println();

        int prevPrevNum = 1; //An-2 a의 첫번째 항의 값을 1로 초기화
        int prevNum = 1; //An-1      a의 두번째 항의 값을 1로 초기화

        System.out.print(prevPrevNum + " ");
        System.out.println();
        System.out.println(prevNum + " ");

        for (int i = 3; i < 10; i++) {
            int nNum = prevPrevNum + prevNum;  // 현재 n번째 항을 구할때 이전이전의 항값과 이전항의 값을 더하여 출력
            System.out.println(nNum + " ");


            prevPrevNum = prevNum;  // 이전이전항의 숫자는 이전항의 값으로 갱신하고
            prevNum = nNum;         // 이전 숫자는 현재의 값으로 갱신한다.
        }

    }
}


