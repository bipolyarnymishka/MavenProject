package HomeWork_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Egor",
                Arrays.asList(new Course("Mathematics"),
                        new Course("English"),
                        new Course("Astronomia"))));
        studentList.add(new Student("Eva",
                Arrays.asList(new Course("Mathematics"),
                        new Course("Informatica"))));
        studentList.add(new Student("Lena",
                Arrays.asList(new Course("English"),
                        new Course("Astronomia"))));
        studentList.add(new Student("Roman",
                Arrays.asList(new Course("English"),
                        new Course("Mathematics"),
                        new Course("Informatica"))));

        System.out.println(studentList.stream()
                .map(s -> s.getAllCourses())
                .flatMap(c -> c.stream())
                .map(n -> n.getName())
                .distinct()
                .collect(Collectors.toList())
        );

        System.out.println(studentList.stream()
                .sorted((c1, c2) -> c2.getAllCourses().size() - c1.getAllCourses().size())
                .limit(3)
                .map(s -> s.getName())
                .collect(Collectors.toList())
        );

        System.out.println(studentList.stream()
                .filter(s -> s.getAllCourses().contains(new Course("English")))
                .map(s -> s.getName())
                .collect(Collectors.toList())
        );
    }
}
