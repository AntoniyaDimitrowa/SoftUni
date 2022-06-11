using System;

namespace _07._TrekkingMania
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numberOfGroups = int.Parse(Console.ReadLine());
            int numberOfAllPeople = 0;
            int numberOfPeopleMusala = 0;
            int numberOfPeopleMonblan = 0;
            int numberOfPeopleKilimandjaro = 0;
            int numberOfPeopleK2 = 0;
            int numberOfPeopleEverest = 0;
            for (int i = 1; i <= numberOfGroups; i++)
            {
                int numberOfGroupMembers = int.Parse(Console.ReadLine());
                numberOfAllPeople = numberOfAllPeople + numberOfGroupMembers;
                if (numberOfGroupMembers <= 5)
                {
                    numberOfPeopleMusala = numberOfPeopleMusala + numberOfGroupMembers;
                }
                if (numberOfGroupMembers > 5 && numberOfGroupMembers <= 12)
                {
                    numberOfPeopleMonblan = numberOfPeopleMonblan + numberOfGroupMembers;
                }
                if (numberOfGroupMembers > 12 && numberOfGroupMembers <= 25)
                {
                    numberOfPeopleKilimandjaro = numberOfPeopleKilimandjaro + numberOfGroupMembers;
                }
                if (numberOfGroupMembers > 25 && numberOfGroupMembers <= 40)
                {
                    numberOfPeopleK2 = numberOfPeopleK2 + numberOfGroupMembers;
                }
                if (numberOfGroupMembers > 40)
                {
                    numberOfPeopleEverest = numberOfPeopleEverest + numberOfGroupMembers;
                }
            }
            Console.WriteLine($"{(numberOfPeopleMusala * 1.0) / numberOfAllPeople * 100:F2}%");
            Console.WriteLine($"{(numberOfPeopleMonblan * 1.0) / numberOfAllPeople * 100:F2}%");
            Console.WriteLine($"{(numberOfPeopleKilimandjaro * 1.0) / numberOfAllPeople * 100:F2}%");
            Console.WriteLine($"{(numberOfPeopleK2 * 1.0) / numberOfAllPeople * 100:F2}%");
            Console.WriteLine($"{(numberOfPeopleEverest * 1.0) / numberOfAllPeople * 100:F2}%");
        }
    }
}
