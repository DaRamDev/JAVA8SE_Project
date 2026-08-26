package chapter5.oop.good.copy;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
    	
    	Employee emp1 = new MereClerk("철수", 100);
    	Employee emp2 = new MereClerk("영희", 200);
    	
    	Employee emp3 = new Manager("길동", 300, "인사부");
    	System.out.println(emp3.getName());
    	System.out.println(emp3.getSalary());
    	
    	Manager mgr = (Manager)emp3;
    	System.out.println(mgr.getDeptName());
    	
    	
        Manager emp4 = new Manager("둘리", 200, "개발부" );
        System.out.println(emp4.getName());
        System.out.println(emp4.getDeptName());
        System.out.println(emp4.getDeptName());
    	
        
        Employee[] emps = new Employee[3];
        emps[0] = new MereClerk("철수", 100);
        emps[1] = new MereClerk("영희", 200);
        emps[2] = new Manager("길동", 300, "인사부");
        
        for(Employee emp: emps) {
        	System.out.println("현재 월급입니다. ");
        	
        	if(emp instanceof Manager) {
        		System.out.println("부서명 = "+ ((Manager)emp).getDeptName());
        	}
            System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");
            
            emp.manageSalary(10);
            
            System.out.println("올린 후의 월급입니다.");
            System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");

        }
 
   }
}

