import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int tweetCount = sc.nextInt();
        final int keywordCount = sc.nextInt();
        final List<TweetInfo> tweetInfo = new ArrayList<>();
        final List<String> keywords = new ArrayList<>();
        
        for(int i = 0; i < tweetCount; i++) {
            int id = i + 1;
            int len = sc.nextInt();
            String tweet = sc.next();
            // yyyyMMdd形式の文字列にする
            String date = sc.next() + String.format("%02d", sc.nextInt()) + String.format("%02d", sc.nextInt());
            
            tweetInfo.add(new TweetInfo(id, len, tweet, date));
        }

        for(int i = 0; i < keywordCount; i++) {
            // キーワードの長さは不要
            sc.nextInt();

            String keyword = sc.next();
            keywords.add(keyword);
        }

        // つぶやき抽出結果
        List<TweetInfo> result = new ArrayList<>();

        for(int i = 0; i < tweetCount; i++) {
            TweetInfo ti = tweetInfo.get(i);
            String tw = ti.getTweet();
            for(int j = 0; j < keywordCount; j++) {
                String kw = keywords.get(j);
                if(tw.contains(kw)) {
                    result.add(ti);
                    break;
                }
            }
        }

        // 投稿日時（昇順）→ ID（昇順）に並び替え
        List<TweetInfo> sortedList = result.stream()
            .sorted(Comparator.comparing(TweetInfo::getDate)
            .thenComparing(TweetInfo::getId))
            .collect(Collectors.toList());

        if(result.size() == 0) {
            System.out.println("None");
        }
        else {
            for(TweetInfo ti : sortedList) {
                System.out.println(ti.getId());
            }
        }
    }
}

class TweetInfo {
    private int id;
    private int len;
    private String tweet;
    private String date;

    TweetInfo(int i, int l, String t, String d) {
        this.id = i;
        this.len = l;
        this.tweet = t;
        this.date = d;
    }

    public int getId() {
        return this.id;
    }
    public int getLen() {
        return this.len;
    }
    public String getTweet() {
        return this.tweet;
    }
    public String getDate() {
        return this.date;
    }
}
