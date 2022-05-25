using System;

namespace VacationBooksList
{
    internal class VacationBooksList
    {
        static void Main(string[] args)
        {
            int numberOfPagesInABook = int.Parse(Console.ReadLine());
            int numberOfPagesForOneHour = int.Parse(Console.ReadLine());
            int numberOfDaysForReading = int.Parse(Console.ReadLine());

            int hoursForReading = numberOfPagesInABook / numberOfPagesForOneHour;
            int hoursReadingInOneDay = hoursForReading / numberOfDaysForReading;
            Console.WriteLine(hoursReadingInOneDay);
        }
    }
}
