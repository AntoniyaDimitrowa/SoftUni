using System;

namespace _08.Cinema_Ticket
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string dayOfWeek = Console.ReadLine();
            switch (dayOfWeek)
            {
                case "Monday":
                case "Tuesday":
                case "Friday":
                    Console.WriteLine("12"); break;
                case "Thursday":
                case "Wednesday":
                    Console.WriteLine("14"); break;
                case "Saturday":
                case "Sunday":
                    Console.WriteLine("16"); break;
                default: Console.WriteLine("Error"); break;
            }
        }
    }
}
