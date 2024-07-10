import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//         while (true) {
//             switch (ToDoStatus) {
//                 case 1:
//                     CreateTODO();
//                     break;
//                 case 2:
//                     EditTODO();
//                     break;
//                 case 3:
//                     FinishTODO();
//                     break;
//                 case 4:
//                     DeleteTODO();
//                     break;
//                 case 5:
//                     Exit();
//                     break;
//                 default:
//                     return;
//
//
//
//             }
        System.out.println("Welcome!");
        Scanner scanner = new Scanner(System.in);
        ToDoStatus toDoStatus = new ToDoStatus();
        int index = 0;
        while (true) {
            toDoStatus.printList();
            System.out.println("1. Create TODO");
            System.out.println("2. EditTODO ");
            System.out.println("3. Finish TODO");
            System.out.println("4. Delete TODO");
            System.out.println("5. Exit");

            System.out.print("Input: ");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    toDoStatus.create();
                    break;
                case 2:
                     System.out.print("edit to number:");
                     index = scanner.nextInt();
                    toDoStatus.editList(index);
                    break;

                case 3:
                    System.out.print("finish to number: ");
                    index = scanner.nextInt();
                    toDoStatus.finishList(index- 1);

                    break;
                case 4:
                    System.out.println("delete to number: ");
                    index = scanner.nextInt();
                    toDoStatus.DeleteList(index);
                    break;
                case 5:
                    return;

            }
        }

    }
}
