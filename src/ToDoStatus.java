import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoStatus {
    private static List<TODO> todoList;
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
                ToDoStatus.writeData();
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
        System.out.println("Saved!!");

    }
    public void printList () {
        todoList = ToDoStatus.readData();
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
        System.out.println("Saved!!");
    }
    public void finishList(int index) {
        todoList.set(index , new TODO(todoList.get(index).getTitle()+"(Done)",
                todoList.get(index).getUntil()
                ));
    }

    public void DeleteList(int index) {
        todoList.remove(index-1);
    }

    static List<TODO> readData() {
        List<TODO> toDoList = new ArrayList<>();
        try (FileReader fileReader = new FileReader("ToDoList.csv");
             BufferedReader reader= new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(",");
                LocalDate date = LocalDate.parse(elements[1]);
                toDoList.add(new TODO(elements[0],date));
            }

        } catch (IOException e) {
            System.out.println("Read data error: " + e.getMessage());
            System.out.println(e.getMessage());
        }
        return toDoList;

    }

     static void writeData() {
        try (FileWriter fileWriter = new FileWriter("ToDOList.csv");
        BufferedWriter writer = new BufferedWriter(fileWriter)) {
            StringBuilder lineBuilder = new StringBuilder();
            for (TODO todo : todoList) {
                lineBuilder.append(todo.getTitle()).append(',');
                lineBuilder.append(todo.getUntil());
                writer.write(lineBuilder.toString());
                writer.newLine();
                lineBuilder.setLength(0);
            }
        } catch (IOException e) {
            System.out.println("Write data error: " + e.getMessage() );
        }

    }
    





}