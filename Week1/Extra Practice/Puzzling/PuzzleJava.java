import java.util.Random;
public class PuzzleJava {
    public void getTenRolls(int[] array){
        Random rand = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(21);
            System.out.print(array[i] +", ");
        }
    }
    public char getRandomLetter(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Random rand = new Random();
        return alphabet[rand.nextInt(26)];
    }
    public String generatePassword(int length){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Random rand = new Random();
        String password = "";
        for (int i = 0; i < length; i++){
            password += alphabet[rand.nextInt(26)];
        }
        return password;
    }
    public String getNewPasswordSet(int[] lengths){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Random rand = new Random();
        String passwords = "";
        for (int j = 0; j < lengths.length; j++){
            for (int i = 0; i < lengths[j]; i++){
                passwords += alphabet[rand.nextInt(26)];
            }
            passwords += " ";
        }
        return passwords;
    }
}
