import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args, Object fileData) {
        System.out.println("Введите Фамилию Имя Отчество через пробел:");
        Scanner scan = new Scanner(System.in);
        String newFIO = scan.nextLine();
        System.out.println("Введите дату рождения в формате dd.mm.yyyy");
        scan = new Scanner(System.in);
        String newDataBirthday = scan.nextLine();
        System.out.println("Введите номер телефона как единое целое число");
        scan = new Scanner(System.in);
        String numberPhone = scan.nextLine();
        System.out.println("Введите пол одной буквой: f - женский, m - мужской");
        scan = new Scanner(System.in);
        String sex = scan.nextLine();
        scan.close();
        
        String[] arrNewFio = newFIO.split(" ");
        try {
            checkNumberWord(arrNewFio);
        } catch (Exception e) {
             e.printStackTrace();
        }
        String[] numberFIO = newFIO.split("");
        for (int i = 0; i < numberFIO.length; i++) {
        
            try {
                    
                int num = Integer.parseInt(numberFIO[i]);
                }
                catch (NumberFormatException err) {
                continue;
                }
            int num = Integer.parseInt(numberFIO[i]);    
            if (num == Integer.parseInt(numberFIO[i])) {
                
                System.out.println("Введите ФИО без числовых значений");
                break;
            }
        }
        
        String dataBirthday = newDataBirthday.replace(".", "/");
        String[] arrDataBirthday = dataBirthday.split("/");
        try {
                checkNumberWord(arrDataBirthday);
            } catch (Exception e) {
                e.printStackTrace();
            }
        try {
            for (int i = 0; i < arrDataBirthday.length; i++) {
                int num = Integer.parseInt(arrDataBirthday[i]);
            }
        }
        catch (NumberFormatException err) {
            System.out.println("Введите только числовые значения");
        }
        try {
            numberDayMounth(arrDataBirthday);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String[] arrNumberPhone = numberPhone.split("");
        try {
            for (int i = 0; i < arrNumberPhone.length; i++) {
                int num = Integer.parseInt(arrNumberPhone[i]);
            }
        }
        catch (NumberFormatException err) {
            System.out.println("Введено не цифровое значение");
        }
        try {
            designSex(sex);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
        File file = new File("fileData.txt");
        if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        } 
        
        try {
            FileWriter fw = new FileWriter("fileData.txt");
            fw.write(newFIO + ", " + newDataBirthday + ", " + numberPhone + ", " + sex + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }

        
     
    }
    private static void checkNumberWord(String[] arr) throws Exception {
        try {
            
                if (arr.length != 3) {
                    throw new Exception();
            }
        }
        catch (Exception err) {
            System.out.println("Введено неправильное колличество  данных или данные введены  через неправильный разделитель");
        }
    }
    private static void numberDayMounth(String[] arr) throws Exception{
        int[] arrNumDay = new int [3];
        for (int i = 0; i < arr.length; i++) {
            arrNumDay[i] = Integer.parseInt(arr[i]);
        }
        try {
            if (arrNumDay[0] > 31 || arrNumDay[1] > 12) {
                throw new Exception();
            }
           
        }
        catch (Exception err) {
            System.out.println("Введите правильную дату");
        }
    }
    private static void designSex(String sex) throws Exception{
        String f = "f";
        String m = "m";
        try {
            if (sex.equals(f) || sex.equals(m)) {
                return;
            } else throw new Exception();
           
        }
        catch (Exception err) {
            System.out.println("Введите пол правильной буквой");
        }
    }
}