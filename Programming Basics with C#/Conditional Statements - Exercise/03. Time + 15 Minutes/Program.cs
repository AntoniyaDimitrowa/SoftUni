using System;

namespace _03._Time___15_Minutes
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int hoursAtTheBeginning = int.Parse(Console.ReadLine());
            int minutesAtTheBeginning = int.Parse(Console.ReadLine());
            int minutes = minutesAtTheBeginning + 15;
            int hours;
            if(minutes >60)
            {
                hours = minutes / 60 + hoursAtTheBeginning;
                minutes = minutes % 60;
                
            }
            else if(minutes==60)
            {
                hours = hoursAtTheBeginning + 1;
                minutes = 0;
            }
            else
            {
                hours = hoursAtTheBeginning;
                
            }
            if (hours > 23)
            {
                hours = 0 + hours - 24;
            }

            if (minutes < 10)
            {
                Console.WriteLine($"{hours}:0{minutes}");
            }
            else
            {
                Console.WriteLine($"{hours}:{minutes}");
            }
            

        }
    }
}
