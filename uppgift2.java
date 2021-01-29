import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uppgift2 {

    public static int rad = 1;
    public static int antal = 0;



    public static void main(String[] args) {

        String[] omega = {"(?i)abcdefghijlklmnopqrstuvxyz", "Ola",
                "a{3,5}","(?i)[A-Z0-9\\_\\.\\%\\-]+\\@(?i)[A-Z0-9\\-\\_\\.]+\\.(?i)[A-Z]{2,3}",
                 "(018\\s)[0-9]+|(018\\-)[0-9]+|(018\\/)[0-9]+|(018[0-9])[0-9]+", "((?i)[A-Z])\\1\\1\\1", "(?i)[A-Z]{3}\\/[0-9]{3}|(?i)[A-Z]{3}\\_[0-9]{3}",
                 "\\([\\w\\s]+\\)" , "for\\s*\\([\\w\\W\\s]+\\)\\s*\\{[\\w\\W\\s]+\\}|if\\s*\\([\\w\\W\\s]+\\)\\s*\\{[\\w\\W\\s]+\\}"};

        int index = 0;


        while (index < omega.length) {
            try (Scanner lasFil = new Scanner(new File("text.txt"))) {
                while (lasFil.hasNextLine()) {
                    String line = lasFil.nextLine();

                String pattern = omega[index];
                finder(line, pattern);
                rad++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            index++;
            System.out.println(" " + "Antal: " +antal);
            System.out.println("");
            rad = 1;
            antal = 0;
        }

        try (Scanner lasFil = new Scanner(new File("text.txt"))) {
            while (lasFil.hasNextLine()) {
                String line = lasFil.nextLine();

                String pattern4 = "[^A-Za-z0-9]{2,}";
                finder2(line, pattern4);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Strängar som inte tillhör [A-Za-z0-9] finns det "+ antal +" av!");
        antal = 0;





    }


    public static void finder (String myString, String pattern){

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while(matcher.find()){
            antal++;
            if(matcher.group().length() != 0) {
                System.out.print(matcher.group() + " ");
            }
            System.out.print ("Start: "+matcher.start() +" ");
            System.out.print("slut: "+matcher.end() + " ");
            System.out.print("På rad: "+rad + " ");
        }

    }

    public static void finder2 (String myString, String pattern){

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while(matcher.find()){
            antal++;

        }

    }





}
