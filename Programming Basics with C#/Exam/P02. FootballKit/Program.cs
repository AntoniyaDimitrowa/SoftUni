using System;

namespace P02._FootballKit
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double shirtPrice = double.Parse(Console.ReadLine());
            double neededSumForBall = double.Parse(Console.ReadLine());

            double shortsPrice = shirtPrice * 0.75;
            double socksPrice = shortsPrice * 0.20;
            double trainersPrice = (shirtPrice + shortsPrice) * 2;
            double totalSum = shirtPrice + shortsPrice + socksPrice + trainersPrice;
            double totalSumWithDiscount = totalSum - totalSum * 0.15;

            if (totalSumWithDiscount >= neededSumForBall)
            {
                Console.WriteLine($"Yes, he will earn the world-cup replica ball!");
                Console.WriteLine($"His sum is {totalSumWithDiscount:F2} lv.");
            }
            else
            {
                Console.WriteLine($"No, he will not earn the world-cup replica ball.");
                Console.WriteLine($"He needs {(neededSumForBall - totalSumWithDiscount):F2} lv. more.");
            }
        }
    }
}
