package test.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author liyh2333@163.com
 * @package test.java8
 * @date 2020/4/24 15:07
 * 数据源
 * empid  deptid    salary
 * 1	    10		5500.00
 * 2	    20		4800.00
 * 3	    40		14500.00
 * 4		40		44500.00
 * 5		50		6500.00
 * 6		50		7500.00
 * 7		10		4500.00
 * 8		40		6500.00
 * 9		20		1900.00
 *
 */
public class Test3 {

    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1,10,5500));
        emp.add(new Employee(2,20,4800));
        emp.add(new Employee(3,40,14500));
        emp.add(new Employee(4,40,44500));
        emp.add(new Employee(5,50,6500));
        emp.add(new Employee(6,50,7500));
        emp.add(new Employee(7,10,4500));
        emp.add(new Employee(8,40,6500));
        emp.add(new Employee(9,20,1900));
        // 使用分组，以deptId进行分组
        Map<Integer, List<Employee>> map = emp.stream().collect(Collectors.groupingBy(Employee::getDeptId));
        // 通过TreeMap进行key的排序
        Map<Integer, List<Employee>> newMap = new TreeMap<>();
        for (Map.Entry<Integer, List<Employee>> entry : map.entrySet()) {
            List<Employee> value = entry.getValue();
            // 进行集合内薪资rank排序
            Collections.sort(value, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return Double.compare(o2.getSalary(), o1.getSalary());
                }
            });
            int rank = 0;
            for(Employee item : value){
                rank++;
                item.setRank(rank);
            }
            newMap.put(entry.getKey(),value);
        }

        for (Map.Entry<Integer, List<Employee>> entry : newMap.entrySet()) {
            List<Employee> value = entry.getValue();
            value.forEach(System.out::println);
        }

    }

}

class Employee{
    int empId;
    int deptId;
    double salary;
    int rank;

    public Employee(){}

    public Employee(int empId, int deptId, double salary) {
        this.empId = empId;
        this.deptId = deptId;
        this.salary = salary;
        this.rank = 0;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", deptId=" + deptId +
                ", salary=" + salary +
                ", rank=" + rank +
                '}';
    }
}