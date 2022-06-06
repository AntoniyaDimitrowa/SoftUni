using System;

namespace P05._AccountBalance
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string command;
            double sum = 0.0;
            while ((command = Console.ReadLine())!= "NoMoreMoney")
            {
                double moneyToIncrease = double.Parse(command);
                if (moneyToIncrease < 0)
                {
                    Console.WriteLine("Invalid operation!");
                    break;
                }
                Console.WriteLine($"Increase: {moneyToIncrease:F2}");
                sum += moneyToIncrease;
            }
            Console.WriteLine($"Total: {sum:F2}");
        }
    }
}
