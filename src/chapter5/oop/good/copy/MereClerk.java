package chapter5.oop.good.copy;
/* 평사원 클래스 */
public class MereClerk extends Employee {

    public MereClerk (String name, double salary) {
        super(name, salary);
    }
   @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}
