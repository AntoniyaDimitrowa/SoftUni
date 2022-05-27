using System;

namespace _05._Godzilla_vs._Kong
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            int numberOfExtras = int.Parse(Console.ReadLine());
            double priceForOneExtrasClothes = double.Parse(Console.ReadLine());
            double priceForDecor = 0.1 * budget;
            double priceForClothes = numberOfExtras * priceForOneExtrasClothes;
            if(numberOfExtras > 150)
            {
                priceForClothes = priceForClothes - 0.1 * priceForClothes;
            }
            double totalPrice = priceForClothes + priceForDecor;

            if(totalPrice > budget)
            {
                Console.WriteLine("Not enough money!");
                Console.WriteLine($"Wingard needs {totalPrice - budget:F2} leva more.");
            }
            else
            {
                Console.WriteLine("Action!");
                Console.WriteLine($"Wingard starts filming with {budget - totalPrice:F2} leva left.");
            }
        }
    }
}
