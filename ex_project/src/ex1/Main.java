package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 학생 이름 저장 및 조회

        Student st1 = new Student("김길동", "1680");
        Student st2 = new Student("이수지", "1682");
        Student st3 = new Student("고동석", "1785");

        ArrayList <Student>list = new ArrayList<Student>();

        list.add(st1);
        list.add(st2);
        list.add(st3);

        for(Student stu : list) {
            //for each문 (컬렉션구성 변수의 자료형과 변수 이름 : 컬렉션 참조형 변수)
            System.out.println(stu.getName());
            System.out.println(stu.getNo());
        }

            Scanner scan = new Scanner(System.in); //사용자로부터 키 입력을 받는다.

            while (true) {
                System.out.println("계속 검색을 하고싶으시면 Y, 종료하고 싶으시면 N을 입력해주세요");
                String input = scan.next();  // 문자열을 입력받는다.

                if (input.equals("y")) {  // input의 값이 Y인 경우 ** 문자열을 받기 때문에 equals를 사용한다.
                    System.out.println("검색을 시작합니다.");
                    String name = scan.next();
                    boolean flag = false; // flag변수는 스위치 변수로 상태를 기록하고 처리 흐름을 제어하기 위한 변수처리 흐름을 제어할때 사용한다. ** boolean형 변수
                                          // false로 초기화를 한다.

                    for (Student stu : list) {
                        if (stu.getName().equals(name)) {  //만약 인스턴스 getName과 사용자 입력받은 값이 같으면
                            System.out.println("해당하는 학생의 학번은 : " + stu.getNo());
                            flag = true; // 학생의 이름이 한번이라도 있을 경우 true로 변경한다.
                        }
                    }

                    if (!flag) { // flag가 flase 인경우
                        System.out.println("해당하는 학생 이름이 없습니다.");
                    }
                }
                else if (input.equals("n")) {  //input의 값이 N인 경우
                    break;
                }
            }

            System.out.println("프로그램이 종료되었습니다.");
        }
    }