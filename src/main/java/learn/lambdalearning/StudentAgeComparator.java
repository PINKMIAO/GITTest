package learn.lambdalearning;

import java.util.Comparator;

/**
 * @author Baven
 * @date 2021/11/24 8:46
 */
public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
