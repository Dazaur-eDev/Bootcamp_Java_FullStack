package M4_Sesion12;

import M4_Sesion11.utils.ReadConsole;
import M4_Sesion12.utils.ReadFile;
import M4_Sesion12.utils.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class S12_Rebound {
    ReadFile rf = new ReadFile();
    WriteFile wf = new WriteFile();
    String directory = "Modulo 4/M4_Sesions/M4_Sesion12/txtFiles/";
    String file = "participants_Contests.txt";
    String fileWinner = "winner.txt";

    public void sorteo() {
        int option = 0;
        while (option != 3) {
            menu();
            option = ReadConsole.dataInputInt();
            switch (option) {
                case 1:
                    readList(directory, file);
                    break;
                case 2:
                    add(directory, file);
                    break;
                case 3:
                    selectWinner(directory, file);
                    break;
                default:
                    System.out.println("No valid option");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("___________________________________________________________");
        System.out.println("Welcome to the contest for a new Bike ElectricPower6000");
        System.out.println("Select the option you want: ");
        System.out.println("1 - See the participants");
        System.out.println("2 - Add a new participant");
        System.out.println("3 - Select the winner from the participants");
        System.out.println("___________________________________________________________");
    }

    public void readList(String directory, String file) {
        rf.read(directory, file);
    }

    public void add(String directory, String file) {
        System.out.println("Enter the name and last name for the new participant:");
        List<String> listOfParticipants = new ArrayList<>();
        String newParticipant = ReadConsole.dataInputString();
        listOfParticipants.add (newParticipant);
        wf.writeAppend(directory, file, listOfParticipants);
    }

    public void selectWinner(String directory, String file) {
        ReadFile rf = new ReadFile();
        System.out.println("The participants for the contest are: ");
        List listOfParticipants;
        listOfParticipants = rf.extractData(directory, file);
        System.out.println(listOfParticipants);
        System.out.println("We are gonna let the machine select someone randomly...");
        System.out.println("The winner gonna be saved in the file winner.txt");
        Random random = new Random();
        int indexRandom = random.nextInt(listOfParticipants.size());
        String winner = (String) listOfParticipants.get(indexRandom);
        String message = "The winner of a new Bike ElectricPower6000 it is... " + winner + "Congrats !";
        List<String> w = new ArrayList<>();
        w.add(message);
        wf.writeOver(directory, fileWinner, w);
        System.out.println("Thanks for playing in the contest");
    }
}
