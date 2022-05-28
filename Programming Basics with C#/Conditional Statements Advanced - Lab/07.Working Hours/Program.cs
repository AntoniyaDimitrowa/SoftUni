using System;

namespace _07.Working_Hours
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            string dayOfWeek = Console.ReadLine();
            if(hour >=10 && hour<=18)
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Wednesday":
                    case "Thursday":
                    case "Friday":
                    case "Saturday":
                        Console.WriteLine("open"); break;
                    case "Sunday":
                        Console.WriteLine("closed"); break;
                    default: Console.WriteLine("Error"); break;
                }
            }
            else
            {
                Console.WriteLine("closed");
            }
        }
    }
}
