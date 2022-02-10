public class PuzzleTest {
    public static void main(String[] args) {
        PuzzleJava Puzzle = new PuzzleJava();

        int[] arr = new int[10];
        Puzzle.getTenRolls(arr);

        System.out.println("\n"+Puzzle.getRandomLetter());

        System.out.println(Puzzle.generatePassword(8));

        int[] words = {8, 10, 14, 24, 5, 2, 5, 7, 19};
        System.out.println(Puzzle.getNewPasswordSet(words));
    }
}
