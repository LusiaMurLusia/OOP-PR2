import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public main(){
}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("1) Введите строку и количество повторений букв: ");
        String aWord=sc.nextLine();
        int am=sc.nextInt();
        System.out.println(repeat(aWord,am));
        System.out.println("2) Введите количество элементов массива: ");
        int el= sc.nextInt();
        int[] pArr =new int[el];
        for (int i = 0; i < el; i++) {
            pArr[i] = sc.nextInt();
        }
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(pArr[i]);
        }
        System.out.println("Разница между max и min: " +difMM(pArr));
        System.out.println("3) Введите количество элементов массива: ");
        el= sc.nextInt();
        int[] ppArr =new int[el];
        for (int i = 0; i < el; i++) {
            ppArr[i] = sc.nextInt();
        }
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(ppArr[i]);
        }
        System.out.println("Целое ли число среднее значение массива: " +isAvgW(ppArr));
        System.out.println("4) Введите количество элементов массива: ");
        el=sc.nextInt();

        int[] pppArr =new int[el];
        for (int i = 0; i < el; i++) {
            pppArr[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(pppArr[i]);
        }
        int[] fArr=cumArr(pppArr);
        System.out.println("Полученный массив: ");
        for (int i = 0; i < fArr.length; i++) {
            System.out.println(fArr[i]);
        }
        System.out.println("5) Введите десятичное число (разделитель - точка): ");
        String sNum=sc.nextLine();
        System.out.println("Количество десятичых знаков в числе: " +getDecimal(sNum));
        System.out.println("6) Введите номер числа Фибоначчи: ");
        int fibN =sc.nextInt();
        sc.nextLine();
        System.out.println("Число Фибоначчи: " +Fibo(fibN));
        System.out.println("7) Введите индекс: ");
        String ind=sc.nextLine();
        System.out.println("Реальный ли индекс: " +isRealIndex(ind));
        System.out.println("8) Введите две строки: ");
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        System.out.println("Странная ли пара: " +isStrange(str1,str2));
        System.out.println("9.1) Введите слово и префикс с тире на конце: ");
        String word=sc.nextLine();
        String prefix=sc.nextLine();
        System.out.println("Является ли префиксный аргумент префиксом: " +isPrefix(word,prefix));
        System.out.println("9.2)Введите слово и префикс с тире на конце: ");
        String word1=sc.nextLine();
        String suffix=sc.nextLine();
        System.out.println("Является ли суффиксный аргумент суффиксом: " +isSuffix(word1,suffix));
        System.out.println("10) Введите шаг поледовательности: ");
        int step= sc.nextInt();
        System.out.println("Количество полей на данном шаге: " +boxSeq(step));
    }
    // 1)
    public static String repeat(String word, int am){
        char[] pWord = word.toCharArray();
        String gWord="";
        for (char c : pWord) {
            for (int j = 0; j < am; j++) {
                gWord += c;
            }
        }
        return gWord;
    }
    // 2)
    public static int difMM(int[] nArr){
        int max=-99999;
        int min=99999;
        for (int value : nArr) {
            if (min > value)
                min = value;
            if (max < value)
                max = value;
        }
        return max-min;
    }
    // 3)
    public static boolean isAvgW(int[] nArr){
        double sum=0;
        for (int value : nArr) {
            sum += value;
        }
        return sum/nArr.length%1==0;
    }
    // 4)
    public static int[] cumArr(int[] pArr){
        int[] fArr=new int[pArr.length];
        for (int i = 0; i < pArr.length; i++) {
            for (int j = i; j >= 0; j--) {
                fArr[i]+=pArr[j];
            }
        }
        return fArr;
    }
    // 5)
    public static int getDecimal(String num){
        String[] snum= num.split("\\.");
        return snum[1].toCharArray().length;
    }
    // 6)
    public static int Fibo(int n){
        int[] Fib=new int[n];
        Fib[0]=1;
        Fib[1]=2;
        for (int i = 2; i < n; i++) {
            Fib[i]=Fib[i-1]+Fib[i-2];
        }
        return Fib[n-1];
    }// 7)
    public static boolean isRealIndex(String ind){
        int len=ind.length();
        boolean dig=ind.matches("[\\d]+");
        return (len==5 && dig);
    }
    // 8)
    public static boolean isStrange(String str1, String str2){
        if (str1.isEmpty() && str2.isEmpty())
            return true;
        return str1.toCharArray()[0]==str2.toCharArray()[str2.toCharArray().length-1]
                && str1.toCharArray()[str1.toCharArray().length-1]==str2.toCharArray()[0];

    }
    // 9)
    public static boolean isPrefix(String word, String prefix){
        boolean rez=false;
        int counter=0;
        char[] cPref=prefix.toCharArray();
        int len=cPref.length;
        char[] cWord=word.toCharArray();
        for (int i = 0; i < len-1; i++) {
            if (cPref[i] == cWord[i])
                counter += 1;
        }
        if (counter==len-1)
                rez=true;
        return  rez && cPref[len-1]=='-';
    }

    public static boolean isSuffix(String word, String suffix) {
        boolean rez = false;
        int counter = 0;
        char[] cSuff = suffix.toCharArray();
        int slen = cSuff.length;
        char[] cWord = word.toCharArray();
        int len = cWord.length;
        for (int i = len - 1; i > len - cSuff.length-1; i--) {
            if (cSuff[slen-1] == cWord[i])
                counter += 1;
            slen -= 1;
        }
        if (counter == cSuff.length-1)
            rez = true;
        return rez && cSuff[0] == '-';
    }
    // 10)
    public static int boxSeq(int step){
        int rez=0;
        for (int i = 0; i < step; i++) {
            if ((i+1)%2!=0)
                rez+=3;
            else rez-=1;
        }
        return rez;
    }
}