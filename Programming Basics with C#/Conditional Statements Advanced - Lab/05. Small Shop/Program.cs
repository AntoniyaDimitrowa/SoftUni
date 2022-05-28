using System;

namespace _05._Small_Shop
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string product = Console.ReadLine();
            string city = Console.ReadLine();
            double amount = double.Parse(Console.ReadLine());

            if(product == "coffee")
            {
                if(city =="Sofia")
                {
                    Console.WriteLine(amount * 0.5);
                }
                if (city == "Plovdiv")
                {
                    Console.WriteLine(amount * 0.4);
                }
                if (city == "Varna")
                {
                    Console.WriteLine(amount * 0.45);
                }
            }
            if (product == "water")
            {
                if (city == "Sofia")
                {
                    Console.WriteLine(amount * 0.8);
                }
                if (city == "Plovdiv")
                {
                    Console.WriteLine(amount * 0.7);
                }
                if (city == "Varna")
                {
                    Console.WriteLine(amount * 0.7);
                }
            }
            if (product == "beer")
            {
                if (city == "Sofia")
                {
                    Console.WriteLine($"{amount * 1.2:F1}");
                }
                if (city == "Plovdiv")
                {
                    Console.WriteLine($"{amount * 1.15:F1}");
                }
                if (city == "Varna")
                {
                    Console.WriteLine($"{amount * 1.1:F1}");
                }
            }
            if (product == "sweets")
            {
                if (city == "Sofia")
                {
                    Console.WriteLine(amount * 1.45);
                }
                if (city == "Plovdiv")
                {
                    Console.WriteLine(amount * 1.3);
                }
                if (city == "Varna")
                {
                    Console.WriteLine(amount * 1.35);
                }
            }
            if (product == "peanuts")
            {
                if (city == "Sofia")
                {
                    Console.WriteLine(amount * 1.6);
                }
                if (city == "Plovdiv")
                {
                    Console.WriteLine(amount * 1.5);
                }
                if (city == "Varna")
                {
                    Console.WriteLine(amount * 1.55);
                }
            }
        }
    }
}
