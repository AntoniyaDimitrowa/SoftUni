using System;

namespace P05._Travelling
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string command;
            while ((command = Console.ReadLine()) != "End")
            {
                decimal minBudget = decimal.Parse(Console.ReadLine());
                decimal savings = 0.00m;
                while (savings < minBudget)
                {
                    decimal currSavings = decimal.Parse(Console.ReadLine());
                    savings += currSavings;
                }
                Console.WriteLine($"Going to {command}!");
            }
        }
    }
}
