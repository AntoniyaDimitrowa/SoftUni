import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupsCount = Integer.parseInt(scanner.nextLine());
        int numberOfAllPeople = 0;
        int numberOfPeopleMusala = 0;
        int numberOfPeopleMonblan = 0;
        int numberOfPeopleKilimandjaro = 0;
        int numberOfPeopleK2 = 0;
        int numberOfPeopleEverest = 0;

        for(int i = 1; i <= groupsCount; i++) {
            int groupMembersCount = Integer.parseInt(scanner.nextLine());
            numberOfAllPeople = numberOfAllPeople + groupMembersCount;
            if(groupMembersCount <= 5)
            {
                numberOfPeopleMusala = numberOfPeopleMusala + groupMembersCount;
            }
            if (groupMembersCount>5 && groupMembersCount <= 12)
            {
                numberOfPeopleMonblan = numberOfPeopleMonblan + groupMembersCount;
            }
            if (groupMembersCount > 12 && groupMembersCount <= 25)
            {
                numberOfPeopleKilimandjaro = numberOfPeopleKilimandjaro + groupMembersCount;
            }
            if (groupMembersCount > 25 && groupMembersCount <= 40)
            {
                numberOfPeopleK2 = numberOfPeopleK2 + groupMembersCount;
            }
            if (groupMembersCount > 40)
            {
                numberOfPeopleEverest = numberOfPeopleEverest + groupMembersCount;
            }
        }
        System.out.printf("%.2f%%%n", (numberOfPeopleMusala * 1.0) / numberOfAllPeople * 100);
        System.out.printf("%.2f%%%n", (numberOfPeopleMonblan * 1.0) / numberOfAllPeople * 100);
        System.out.printf("%.2f%%%n", (numberOfPeopleKilimandjaro * 1.0) / numberOfAllPeople * 100);
        System.out.printf("%.2f%%%n", (numberOfPeopleK2 * 1.0) / numberOfAllPeople * 100);
        System.out.printf("%.2f%%", (numberOfPeopleEverest * 1.0) / numberOfAllPeople * 100);
    }
}
