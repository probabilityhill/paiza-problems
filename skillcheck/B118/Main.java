import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int studentCount = sc.nextInt();
        final List<StudentInfo> infoList = new ArrayList<>();
        for(int i = 0; i < studentCount; i++) {
            infoList.add(new StudentInfo(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        // 身長（昇順）→ 誕生月（降順）→ 名前（昇順）に並び替え
        List<StudentInfo> sortedInfoList = infoList.stream()
            .sorted(Comparator.comparing(StudentInfo::getHeight)
            .thenComparing(StudentInfo::getMinusBirthMonth)
            .thenComparing(StudentInfo::getName))
            .collect(Collectors.toList());
        
        // 名前を出力
        for(StudentInfo si : sortedInfoList) {
            System.out.println(si.getName());
        }
    }
}

class StudentInfo {
    private String name;
    private int height;
    private int birthMonth;

    StudentInfo(String name, int height, int birthMonth) {
        this.name = name;
        this.height = height;
        this.birthMonth = birthMonth;
    }

    public String getName() {
        return this.name;
    }
    public int getHeight() {
        return this.height;
    }
    public int getMinusBirthMonth() {
        return -this.birthMonth;
    }
}
