package ru.itis;

public class Main {

    public static void main(String[] args) throws Exception{
        MyNewScanner scanner = new MyNewScanner("C:/Users/bloof/Desktop/PASHAEV_11_702/MyScanner/src/ru/itis/inputString.txt");
        String line = scanner.nextLine();
        System.out.println(line);
        scanner = new MyNewScanner("C:/Users/bloof/Desktop/PASHAEV_11_702/MyScanner/src/ru/itis/inputInteger.txt");
        int numb = scanner.nextInt();
        String s = scanner.nextLine();
        System.out.println(s);
        System.out.println(numb);
    }
}
