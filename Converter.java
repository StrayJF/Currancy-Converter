//Import decimal format (#.00)
import java.text.DecimalFormat;
//Import Locale to use the full stop to separate decimals
import java.util.Locale;
//Import scanner
import java.util.Scanner;
public class Converter {
    public static void main(String[] args) {
        //Define scanner variable
        Scanner sc = new Scanner(System.in);
        //amount is the variable where the amount of money will save
        double amount = 0.0;
        //validInput helps in the next loop
        boolean validInput = false;
        System.out.println("Welcome to the international currency converter. \nIn order to use you must enter an amount in US Dollar using the 'full stop (.)' to separate decimals.");
        //Define the language (useful because my windows settings are setted up in Spanish)
        sc.useLocale(Locale.US);
        //Loop to know if the number could be a Double
        while (!validInput) {
            //Function to know if the scanner has a Double
            if (sc.hasNextDouble()) {
                //If yes, amount take the number of the scanner
                amount = sc.nextDouble();
                //validInput if true
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                //Clean the scanner
                sc.next();
            }
        }//End loop
        //Clean the next line scanner
        sc.nextLine();
        System.out.println("Now write below the coin you are interested in switch your amount. \nToday are available: \nEuros. \nPounds Sterling. \nSouth Korean Won. \nBitCoin. \nSucre. \nPeso Mexicano. \nPeso argentino. \n\n\nType 'exit' to finish the session.");
        //The variable coin gets a string and change everything to lowercase in order to compare it
        String coin = (sc.nextLine()).toLowerCase();
        //Loop to verify if the variable coin has a valid option
        while (!coin.equals("euros") && !coin.equals("pounds sterling") && !coin.equals("south korean won") && !coin.equals("bitcoin") && !coin.equals("exit") && !coin.equals("sucre") && !coin.equals("peso mexicano") && !coin.equals("peso argentino")) {
            System.out.println("Check your writing and try again. \nToday options are: \nEuros. \nPounds Sterling. \nSouth Korean Won. \nBitCoin. \nSucre. \nPeso Mexicano. \nPeso argentino. \n\n\nType 'exit' to finish the session.");
            coin = (sc.nextLine()).toLowerCase();
        } //End loop
        //Currancy transformation decimal to integers
        //Define div as int
        int div = 1;
        //The variable amountstring uses the funtion Doble.toString to transform the content of the variable amount (Double) to a String
        String amountstring = Double.toString(amount);
        //Create a list call decimal that split the string in two parts (0, 1) the first before the "." and the second after the "."
        String[] decimal = amountstring.split("\\.");
        //runner get the number of elements after the "."
        int runner = decimal[1].length();
        //Divide by 10 or 100 based in the number of 'decimals'
        if (runner == 1) {
            div *= 10;
        } else {
            div *= 100;
        }
        //coinconverter multiply the value of 'amount' with 'div' and change it to int
        double coinconverter = (int) amount * div;
        //Define the variable for DecimalFormat and the numbers of decimals wanted
        DecimalFormat df = new DecimalFormat("#.00");
        //Switch structure for 'coin' options
        switch (coin) {
            //euros option
            case "euros":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 0.89582) / div) + " Euros today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //pounds sterling option
            case "pounds sterling":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 0.74783 / div)) + " Pounds Sterling today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //South Korea won option
            case "south korea won":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 1312.22 / div)) + " South Korea Wons today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //bitcoin option
            case "bitcoin":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 0.00002 / div)) + " BitCoins today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //Sucre option
            case "sucre":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 25587 / div)) + " Sucres today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //Peso mexicano option
            case "peso mexicano":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 19.6754 / div)) + " Pesos mexicanos today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //Peso argentino option
            case "peso argentino":
                System.out.println("Your $" + amount + " USD are " + df.format((coinconverter * 967.82 / div)) + " Pesos argentinos today 09/30/2024. Be aware, it could change due to external factors.");
                break;
            //Exit option
            case "exit":
                break;
            }
        }
    }



//Juan (Stray) Fernández, 09 sep 2024