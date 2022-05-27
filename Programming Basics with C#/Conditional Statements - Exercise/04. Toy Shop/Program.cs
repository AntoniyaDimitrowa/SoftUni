using System;

namespace _04._Toy_Shop
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double tripPrice = double.Parse(Console.ReadLine());
            double puzzlesCount = double.Parse(Console.ReadLine());
            double talkingDollsCount= double.Parse(Console.ReadLine());
            double teddyBearsCount = double.Parse(Console.ReadLine());
            double minionCount = double.Parse(Console.ReadLine());
            double truckCount = double.Parse(Console.ReadLine());
            double priceWithoutDiscount = puzzlesCount * 2.6 + talkingDollsCount * 3 + teddyBearsCount * 4.1 + minionCount * 8.2 + truckCount * 2;
            double finalePrice;

            if ((puzzlesCount + talkingDollsCount + teddyBearsCount + minionCount + truckCount) >= 50)
            {
                 finalePrice = priceWithoutDiscount - priceWithoutDiscount * 0.25;
            }
            else
            {
                 finalePrice = priceWithoutDiscount;
            }
            double priceForRent = finalePrice * 0.1;
            double moneySheHas = finalePrice - priceForRent;

            if(moneySheHas >= tripPrice)
            {
                Console.WriteLine($"Yes! {(moneySheHas - tripPrice):F2} lv left.");
            }
            else
            {
                Console.WriteLine($"Not enough money! {(tripPrice - moneySheHas):F2} lv needed.");
            }

        }
    }
}
