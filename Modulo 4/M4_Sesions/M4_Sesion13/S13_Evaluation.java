package M4_Sesion13;

import M4_Sesion13.utils.ReadConsole;
import M4_Sesion13.modules.Data;

import java.time.LocalDate;

public class S13_Evaluation {
    Data data = new Data();

    public void appCentroEstudios() {
        data.auxiliaryData();
        int option = 0;
        while (option != 8) {
            menu();
            option = ReadConsole.dataInputInt();
            switch (option) {
                case 1:
                    data.getListOfCourses();
                    break;
                case 2:
                    data.getListOfCoursesStream();
                    break;
                case 3:
                    data.getListOfStudents();
                    break;
                case 4:
                    newCourse();
                    break;
                case 5:
                    newStudent();
                    break;
                case 6:
                    enrollStudent();
                    break;
                case 7:
                    studentFromCourse();
                    break;
                case 8:
                    System.out.println("Thanks for using the app");
                    break;
                default:
                    System.out.println("No valid option");
                    break;
            }
        }
    }

    public void menu() {
        System.out.println("_______________________________________________");
        System.out.println("Welcome to 'Centro de Estudios Integrales'");
        System.out.println("Select the option you want:");
        System.out.println("1 - See the list of available courses");
        System.out.println("2 - See the list of available courses using stream method");
        System.out.println("3 - See the list of available students");
        System.out.println("4 - Create new course");
        System.out.println("5 - Create new student");
        System.out.println("6 - Enroll new student into a course");
        System.out.println("7 - See the list of student from a specific course");
        System.out.println("8 - Exit");
        System.out.println("_______________________________________________");
    }

    public void newCourse() {
        System.out.println("Enter the name for the new course:");
        String newCourse = ReadConsole.dataInputString();
        System.out.println("Enter the ID for the new course:");
        String newID = ReadConsole.dataInputString();
        System.out.println("Enter the description for the new course:");
        String newDescription = ReadConsole.dataInputString();
        data.setListOfCourses(newCourse, newID, newDescription);
    }

    public void newStudent() {
        System.out.println("Enter the name for the new student:");
        String newStudent = ReadConsole.dataInputString();
        System.out.println("Enter the RUT for the new student:");
        String newRut = ReadConsole.dataInputString();
        System.out.println("Enter the born data for the new student:");
        LocalDate newBornData = ReadConsole.dataInputLocalDate();
        data.setListOfStudents(newStudent, newRut, newBornData);
    }

    public void enrollStudent() {
        data.getListOfCourses();
        System.out.println("Enter the number from the list to select the course");
        int selectedIdCourse = ReadConsole.dataInputInt();
        data.getListOfStudents();
        System.out.println("Enter the number from the list to select the student");
        int selectedRutStudent = ReadConsole.dataInputInt();
        data.asignationCourse(selectedIdCourse, selectedRutStudent,"courseAssignments");
    }

    public void studentFromCourse() {
        data.getListOfCourses();
        System.out.println("Enter the number from the list to select the course you want to see the students enrolled");
        int selectedIdCourse = ReadConsole.dataInputInt();
        data.listOfStudentFromCourse(selectedIdCourse, "courseAssignments");
    }
}
