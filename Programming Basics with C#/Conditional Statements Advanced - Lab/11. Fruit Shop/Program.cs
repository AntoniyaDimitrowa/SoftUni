using System;

namespace _11._Fruit_Shop
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string fruit = Console.ReadLine();
            string dayOfWeek = Console.ReadLine();
            double amount = double.Parse(Console.ReadLine());
            if(fruit =="banana")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount*2.5:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 2.7:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (fruit == "apple")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount * 1.2:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 1.25:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (fruit == "orange")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount * 0.85:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 0.9:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (fruit == "grapefruit")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount * 1.45:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 1.6:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (fruit == "kiwi")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount * 2.7:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 3.0:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (fruit == "pineapple")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount * 5.5:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 5.6:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (fruit == "grapes")
            {
                switch (dayOfWeek)
                {
                    case "Monday":
                    case "Tuesday":
                    case "Friday":
                    case "Thursday":
                    case "Wednesday":
                        Console.WriteLine($"{ amount * 3.85:F2} "); break;
                    case "Saturday":
                    case "Sunday":
                        Console.WriteLine($"{ amount * 4.2:F2} "); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else { Console.WriteLine("error"); }


        }
    }
}
