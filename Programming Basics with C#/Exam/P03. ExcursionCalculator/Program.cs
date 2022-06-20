using System;

namespace P03._ExcursionCalculator
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numberOfPeople = int.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            double totalPrice = 0;

            if (numberOfPeople <= 5)
            {
                if (season == "spring")
                {
                    totalPrice = numberOfPeople * 50.00;
                }
                else if (season == "summer")
                {
                    totalPrice = numberOfPeople * 48.50;
                }
                else if (season == "autumn")
                {
                    totalPrice = numberOfPeople * 60.00;
                }
                else if (season == "winter")
                {
                    totalPrice = numberOfPeople * 86.00;
                }
            }
            else
            {
                if (season == "spring")
                {
                    totalPrice = numberOfPeople * 48.00;
                }
                else if (season == "summer")
                {
                    totalPrice = numberOfPeople * 45.00;
                }
                else if (season == "autumn")
                {
                    totalPrice = numberOfPeople * 49.50;
                }
                else if (season == "winter")
                {
                    totalPrice = numberOfPeople * 85.00;
                }
            }

            if (season == "summer")
            {
                totalPrice = totalPrice - totalPrice * 0.15;
            }
            if (season == "winter")
            {
                totalPrice = totalPrice + totalPrice * 0.08;
            }

            Console.WriteLine($"{totalPrice:F2} leva.");
        }
    }
}
