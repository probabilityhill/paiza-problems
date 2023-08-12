import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int wordNum = sc.nextInt();
        final String[] words = new String[wordNum];
        for(int i = 0; i < wordNum; i++) {
            words[i] = sc.next();
        }

        // しりとりの結果
        String result = "Yes";

        // しりとりをする
        String currWord, nextWord;
        char lastChar, firstChar;
        for(int i = 0; i < wordNum - 1; i++) {
            currWord = words[i];
            nextWord = words[i + 1];
            lastChar = currWord.charAt(currWord.length() - 1);
            firstChar = nextWord.charAt(0);
            // しりとりが成立しなければ終了
            if(lastChar != firstChar) {
                result = lastChar + " " + firstChar;
                break;
            }
        }

        // 出力
        System.out.println(result);
    }
}
