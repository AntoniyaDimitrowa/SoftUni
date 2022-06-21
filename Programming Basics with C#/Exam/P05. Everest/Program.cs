using System;

namespace P05._Everest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string command = Console.ReadLine();
            int daysCounter = 1;
            int metersCounter = 5364;
            bool isSucceeded = false;

            while (command != "END")
            {
                string isSpendingTheNight = command.ToLower();
                if (isSpendingTheNight == "yes")
                {
                    daysCounter++;
                }
                int climbedMeters = int.Parse(Console.ReadLine());
                if (daysCounter > 5)
                {
                    isSucceeded = false;
                    break;
                }
                metersCounter += climbedMeters;

                if (metersCounter >= 8848)
                {
                    isSucceeded = true;
                    break;
                }

                command = Console.ReadLine();
            }

            if (isSucceeded)
            {
                Console.WriteLine($"Goal reached for {daysCounter} days!");
            }
            else
            {
                Console.WriteLine("Failed!");
                Console.WriteLine($"{metersCounter}");
            }
        }
    }
}
