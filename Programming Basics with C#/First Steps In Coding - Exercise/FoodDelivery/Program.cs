using System;

namespace FoodDelivery
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numberOfChickenMenus = int.Parse(Console.ReadLine());
            int numberOfFishMenus = int.Parse(Console.ReadLine());
            int numberOfVegeterianMenus = int.Parse(Console.ReadLine());
            double sumOfPriceForMainDishes = numberOfChickenMenus * 10.35 + numberOfFishMenus * 12.40 + numberOfVegeterianMenus * 8.15;
            double priceForDeserts = sumOfPriceForMainDishes * 0.2;
            double finaleSum = priceForDeserts + sumOfPriceForMainDishes + 2.50;
            Console.WriteLine(finaleSum);
        }
    }
}
