import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ogya Adyatma Putra
 * <p>
 * Program ini bertujuan untuk memasukkan inputan dari user kedalam database yang telah di sediakan
 * dan kemudian menampilkan isi dari database tersebut.
 * Program ini memiliki dua database yaitu database untuk menyimpan string dan database untuk menyimpan integer.
 */

public class start {

    static String inputan;
    static int check;
    static boolean loop = true;
    static String fileNameString = "dataString.txt";
    static String fileNameInt = "dataInt.txt";
    static String dataString;
    static String dataInt;
    static String[] inString;
    static String[] inNumber;
    static Scanner scan = new Scanner(System.in);
    static Scanner ask = new Scanner(System.in);

    public static void main(String[] args) {

        inputMenu();

    }

    public static void inputMenu(){

        do {
            System.out.println("1. Input new data \n2. Show saved data \n3. Exit \n");
            System.out.print("Piih: ");
            check = ask.nextInt();
            switch (check){
                case 1:
                    inputanUser(scan);
                    cekInputanUser(inputan);
                    break;
                case 2:
                    tampilDataString(fileNameString);
                    tampilDataInt(fileNameInt);
                    break;
                default:
                    break;
            }
        }while(loop);
    }

    public static void inputanUser(Scanner scan) {
        System.out.print("Input angka atau string: ");
        inputan = scan.nextLine();
    }

    public static void cekInputanUser(String inputan) {
        if (inputan.matches("[0-9]+")) {
            System.out.println("Inputan anda adalah integer");
            simpanDatabaseInt(inputan, fileNameInt);
        } else {
            System.out.println("Inputan anda adalah string");
            simpanDatabaseString(inputan, fileNameString);
        }
    }

    public static void simpanDatabaseString(String inputan, String fileNameString) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileNameString, true))) {
            bw.write(inputan);
            bw.write(",");
            System.out.println("Inputan anda berhasil disimpan kedalam database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void simpanDatabaseInt(String inputan, String fileNameInt) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileNameInt, true))) {
            bw.write(inputan);
            bw.write(",");
            System.out.println("Inputan anda berhasil disimpan kedalam database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tampilDataString(String fileNameString) {
        System.out.println("List data String:");
        try (BufferedReader br = new BufferedReader(new FileReader(fileNameString))) {
            dataString = br.readLine();
            inString = dataString.split(",");

            for (int i = 0; i < inString.length; i++) {
                System.out.print(inString[i] + ",");
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tampilDataInt(String fileNameInt) {
        System.out.println("List data Int:");
        try (BufferedReader br = new BufferedReader(new FileReader(fileNameInt))) {
            dataInt = br.readLine();
            inNumber = dataInt.split(",");

            for (int i = 0; i < inNumber.length; i++) {
                System.out.print(inNumber[i] + ",");
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}