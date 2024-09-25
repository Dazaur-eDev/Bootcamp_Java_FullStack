package M4_Sesion14;

import M4_Sesion14.modules.ClubFullException;
import M4_Sesion14.modules.DuplicateMemberException;
import M4_Sesion14.modules.Member;
import M4_Sesion14.utils.ReadConsole;


import java.util.ArrayList;
import java.util.List;

public class S14_Evaluation {

    private List<Member> listOfMembers = new ArrayList<>();
    private final int MAX_MEMBERS = 7;
    private boolean memberExists = false;

    public void appMembersClub() throws ClubFullException, DuplicateMemberException {
        int option = 0;
        while (option != 4) {
            menu();
            option = ReadConsole.dataInputInt();
            switch (option) {
                case 1:
                    addMember();
                    break;
                case 2:
                    listOfMember();
                    break;
                case 3:
                    removeMember();
                    break;
                case 4:
                    System.out.println("Thanks for using our Members Club Application");
                    break;
                default:
                    System.out.println("No valid option");
                    break;
            }
        }
    }

    public void menu() {
        System.out.println("_______________________________________________________");
        System.out.println("Welcome to the Members Club Application");
        System.out.println("Current number of Members in the Club : " + listOfMembers.size());
        System.out.println("1.- Enter a new member for the Club");
        System.out.println("2.- See the list for current Members");
        System.out.println("3.- Delete a member from the Club");
        System.out.println("4.- Quit");
        System.out.println("_______________________________________________________");
    }

    public void addMember() throws ClubFullException, DuplicateMemberException {
        memberExists = false;
        System.out.println("Enter the name for the new member");
        String newMember = ReadConsole.dataInputString();
        System.out.println("Enter the age for the new member");
        int newAge = ReadConsole.dataInputInt();
        System.out.println("Enter the position for the new member");
        String newPosition = ReadConsole.dataInputString();
        for (Member member : listOfMembers) {
            if (member.getName().equalsIgnoreCase(newMember)) {
                if (member.getAge() == newAge) {
                    memberExists = true;
                    break;
                }
            }
        }
        if (memberExists) {
            try {
                throw new DuplicateMemberException("");
            } catch (DuplicateMemberException e) {
                System.out.println("Member already exists, please check the information.");
            }

        } else if (listOfMembers.size() >= MAX_MEMBERS) {
            try {
                throw new ClubFullException("");
            } catch (ClubFullException e) {
                System.out.println("Cannot add more members, the club is full.");
            }
        } else {
            listOfMembers.add(new Member(newMember, newAge, newPosition));
            System.out.println("New member added successfully!");
        }
    }

    public void listOfMember() {
        int index = 0;
        for (Member member : listOfMembers) {
            System.out.println((index + 1) + " - " + member.getName() + " - Age: " + member.getAge() + " - Position: " + member.getPositionInClub());
            index++;
        }
    }

    public void removeMember() {
        listOfMember();
        System.out.println("Select the member you want to delete");
        int memberToDelete = ReadConsole.dataInputInt();
        try {
            listOfMembers.remove(memberToDelete + -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Number entered it's not in the list above, details of error: " +  e.getMessage());
        }

    }
}
