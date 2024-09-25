package M4_Sesion13.modules;

import M4_Sesion13.utils.ReadConsole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private List<Course> listOfCourses = new ArrayList<>();
    private List<Student> listOfStudents = new ArrayList<>();
    List<Student> studentsOfCourse = new ArrayList<>();
    Map<String, Map<Course, List<Student>>> courseAssignmentsCollection = new HashMap<>();
    int k = 1;

    public void getListOfCourses() {
        int index = 0;
        for (Course course : listOfCourses) {
            System.out.println((index + 1) + " - " + listOfCourses.get(index).getName() + " ID: " + listOfCourses.get(index).getId() + " - " + listOfCourses.get(index).getDescription());
            index++;
        }
    }

    public void getListOfCoursesStream() {
        listOfCourses.stream().forEach(System.out::println);
    }

    public void getListOfStudents() {
        int index = 0;
        for (Student student : listOfStudents) {
            System.out.println((index + 1) + " - " + listOfStudents.get(index).getName() + " Rut: " + listOfStudents.get(index).getRut() + " - Born date: " + listOfStudents.get(index).getBornData());
            index++;
        }
    }

    public void setListOfCourses(String newCourse, String newID, String newDescription) {
        listOfCourses.add(new Course(newCourse, newID, newDescription));
        String nameCA = "courseAssignments" + k;
        courseAssignmentsCollection.put(nameCA, new HashMap<>());
        k++;
        System.out.println("Course created successfully");
    }

    public void setListOfStudents(String newStudent, String newRUT, LocalDate newBornDate) {
        listOfStudents.add(new Student(newStudent, newRUT, newBornDate));
        System.out.println("Student created successfully");
    }

    public void auxiliaryData() {

        listOfCourses.add(new Course("Inglés", "ING1", "Curso completo desde nivel básico hasta avanzado de inglés. 80 horas"));
        listOfCourses.add(new Course("Comunicación Efectiva", "COAF1", "Fundamentos de la comunicación efectiva para el fortalecimiento de las relaciones interpersonales en espacios de trabajo. 100 horas"));
        listOfCourses.add(new Course("Excel Avanzado", "EXC2", "Fórmulas, listas y plantillas en Excel. 50 horas"));
        listOfCourses.add(new Course("Word Básico", "WOR1", "Uso de elementos básicos en Word. Creación de Curriculum Vitae. 20 horas"));

        listOfStudents.add(new Student("Jaime Cerca", "15569258-6", LocalDate.of(1984, 8, 30)));
        listOfStudents.add(new Student("Teresita Perez", "17269128-3", LocalDate.of(1990, 5, 5)));
        listOfStudents.add(new Student("Patricio Meneses", "10425125-6", LocalDate.of(1970, 6, 21)));
    }

    public void asignationCourse(int selectedIdCourse, int selectedRutStudent, String assignmentName) {

        Course detectedCourse = listOfCourses.get(selectedIdCourse - 1);
        Student detectedStudent = listOfStudents.get(selectedRutStudent - 1);
        System.out.println("You want to enroll " + detectedStudent.getName() + " to the course: " + detectedCourse.getName());
        System.out.println("Write yes to enroll or no to cancel");
        String affirmation = ReadConsole.dataInputString();
        Map<Course, List<Student>> courseAssignments = courseAssignmentsCollection.get(assignmentName);
        if (affirmation.equalsIgnoreCase("yes")) {
            if (courseAssignments == null) {
                courseAssignments = new HashMap<>();
                courseAssignmentsCollection.put(assignmentName, courseAssignments);
            }
            List<Student> studentsOfCourse = courseAssignments.getOrDefault(detectedCourse, new ArrayList<>());
            studentsOfCourse.add(detectedStudent);
            courseAssignments.put(detectedCourse, studentsOfCourse);
            System.out.println(detectedStudent.getName() + " has been enrolled in the course: " + detectedCourse.getName());
        } else if (affirmation.equalsIgnoreCase("no")) {
            System.out.println("Enrollment process canceled");
        } else {
            System.out.println("No valid option");
        }
    }

    public void listOfStudentFromCourse(int selectedIdCourse, String assignmentName) {
        Course detectedCourse = listOfCourses.get(selectedIdCourse - 1);
        Map<Course, List<Student>> courseAssignments = courseAssignmentsCollection.get(assignmentName);
        System.out.println("The course " + detectedCourse.getName() + " has the following students enrolled:");
        try {
            List<Student> enrolledStudents = courseAssignments.get(detectedCourse);
            if (enrolledStudents != null) {
                for (Student student : enrolledStudents) {
                    System.out.println("  - " + student.getName() + " - Rut: " + student.getRut());
                }
            } else {
                System.out.println("No students enrolled yet.");
            }
        } catch (NullPointerException e) {
            System.out.println("No students enrolled yet");
        }
    }
}

