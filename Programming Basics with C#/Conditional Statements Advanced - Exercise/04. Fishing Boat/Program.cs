using System;

namespace _04._Fishing_Boat
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int budget = int.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            int fishers = int.Parse(Console.ReadLine());
            int priceWithoutDiscount = 0;
            switch (season)
            {
                case "Spring":priceWithoutDiscount = 3000;break;
                case "Summer":
                case "Autumn":
                    priceWithoutDiscount = 4200;break;
                case "Winter":priceWithoutDiscount = 2600;break;
            }
          //  Console.WriteLine(priceWithoutDiscount);

            double priceWithDiscount = 0;
            if(fishers<=6)
            {
                priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount*10/100;
            }
            else if (fishers >=7 && fishers <= 11)
            {
                priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.15;
            }
            else
            {
                priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.25;
            }
           // Console.WriteLine(priceWithDiscount);

            double finalePrice = 0;
            if(fishers%2==0 && season!="Autumn")
            {
                finalePrice = priceWithDiscount - priceWithDiscount * 0.05;
            }
            else
            {
                finalePrice = priceWithDiscount;
            }
           // Console.WriteLine(finalePrice);

            if(budget>=finalePrice)
            {
                Console.WriteLine($"Yes! You have {budget - finalePrice:F2} leva left.");
            }
            else
            {
                Console.WriteLine($"Not enough money! You need {finalePrice-budget:F2} leva.");
            }

        }
    }
}
