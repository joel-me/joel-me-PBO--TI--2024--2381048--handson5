import java.util.Scanner;

public class Main {
    public static String[]todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        todos[0]="membaca";
        todos[1]="menggambar";
        todos[2]="menulis";
        showTodosList();

    }
    public static void showTodosList(){
        System.out.println("todo list");
        for (int i = 0; i < todos.length;i++) {
            String todo = todos[i];
            if (todos[i] != null) {
                System.out.println((i + 1) + "." + todo);
            }
        }
    }

    public static void addTodoList(String todo) {
        boolean isfull =true;
        for (int i= 0; i< todos.length;i++){
            if(todos[i]==null) {
                isfull = false;
                break;
            }
        }

            if (isfull){
                String[] temp = todos;
                todos = new String[todos.length*2];
                for( int i =0; i< temp.length; i++){
                    todos[i] = temp[i];
                }
            }

            for (int i= 0; i< todos.length;i++){
            if(todos[i]==null){
                todos[i]=todo;
                break;
            }
        }

    }
    public static boolean removeTodoList(Integer number){
        if(number<=0){
            return false;
        }
        if (number-1> todos.length-1){
            return false;
        }
        if (todos[number-1]==null){
            return false;
        }
        for (int i =  number-1;i< todos.length; i++){
            if (i == (todos.length-1)){
                todos[i]=null;
            }else {
                todos[i]=todos[i+1];
            }
        }
        return true;
    }
    public static boolean editTodoList(Integer number, String newTodo){
        if (isSelectedTodoNotValid(number)){
            return false;
        }
        todos[number-1] = newTodo;
        return true;
    }

    public static void showMainMenu(){
        boolean isRunning = true;
        while (isRunning){
            showTodosList();
            System.out.println("mennu ");
            System.out.println("1. tambah");
            System.out.println("2. hapus");
            System.out.println("3. edit");
            System.out.println("4. keluar");
            System selectedMenu = scanner.nextLine();
            switch (selectedMenu){
                case "1":
                    System.out.println("Menu add todo list");
                    break;
                case "2":
                    System.out.println("Menu remove todo list");
                    break;
                case "3":
                    System.out.println("Menu edit todo list");
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("pillih menu yang benar");
            }
        }
    }
}
