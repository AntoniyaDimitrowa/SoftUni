using System;

namespace _07._Shopping
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double petersBudget = double.Parse(Console.ReadLine());
            int numberOfVideoCards = int.Parse(Console.ReadLine());
            int numberOfProcessors = int.Parse(Console.ReadLine());
            int numberOfRAMMemory = int.Parse(Console.ReadLine());
            double videoCardsPrice = numberOfVideoCards * 250;
            double processorsPrice = numberOfProcessors * (0.35*videoCardsPrice);
            double RAMMemoryPrice = numberOfRAMMemory * (0.1 * videoCardsPrice);
            double totalPrice = videoCardsPrice + processorsPrice + RAMMemoryPrice; ;

            if(numberOfVideoCards>numberOfProcessors)
            {
                totalPrice = totalPrice - 0.15 * totalPrice;
            }

            if(petersBudget >= totalPrice)
            {
                Console.WriteLine($"You have {petersBudget - totalPrice:F2} leva left!");
            }
            else
            {
                Console.WriteLine($"Not enough money! You need {totalPrice - petersBudget:F2} leva more!");
            }
        }
    }
}
