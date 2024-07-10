import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ToDoStatus {
    private List<TODO> todoList;
    private Scanner scanner;

    public ToDoStatus() {
        todoList = new ArrayList<>();
        scanner = new Scanner(System.in);

    }


    public void create() {
        while (true) {
            System.out.print("Titile: ");
            String titile = scanner.nextLine();
            try {
                System.out.print("Until: ");
                LocalDate until = LocalDate.parse(scanner.nextLine());
                TODO toDO = new TODO(titile, until);
                todoList.add(toDO);
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
    public void printList () {
        if (todoList.isEmpty()) {
            System.out.println("You have no more TODOs left!!!");

        } else {
            int count = 0;
            for (int i = 0; i < todoList.size(); i++){
                if (todoList.get(i).getTitle().contains("(Done)")) count++;
            }
            System.out.println(String.format("You have %d TODOs left.", todoList.size() - count));

        }
        for ( int i = 0; i < todoList.size(); i++) {
            System.out.println(String.format("%d. %s", i +1, todoList.get(i).getTitle()));

        }
        System.out.println();
        System.out.println();

    }
    public void editList (int index) {
        while (true) {
            System.out.print("Titile: ");
            String titile = scanner.nextLine();
            try {
                System.out.print("Until: ");
                LocalDate until = LocalDate.parse(scanner.nextLine());
                TODO toDO = new TODO(titile, until);
                todoList.set(index - 1, toDO);
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
    public void finishList(int index) {
        todoList.set(index , new TODO(todoList.get(index).getTitle()+"(Done)",
                todoList.get(index).getUntil()
                ));
    }

    public void DeleteList(int index) {
        todoList.remove(index-1);
    }

}