package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student(20240001, "김민수", "컴퓨터공학", 3);
        System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");

        System.out.println("5학년으로 변경");
        try {
            student.setGrade(5);
        } catch (InvalidGradeException e) {
            // 예외 메시지 출력: "학년은 1~4 사이의 값이어야 합니다."
            System.out.println(e.getMessage());
        }
    }
}