using System;

namespace _03._New_House
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string flower = Console.ReadLine();
            int num = int.Parse(Console.ReadLine());
            int budget = int.Parse(Console.ReadLine());
            double priceWithoutDiscount = 0;
            double priceWithDiscount = 0;
            switch (flower)
            {
                case "Roses": priceWithoutDiscount = num * 5;break;
                case "Dahlias": priceWithoutDiscount = num * 3.8;break;
                case "Tulips": priceWithoutDiscount = num * 2.8;break;
                case "Narcissus": priceWithoutDiscount = num * 3;break;
                case "Gladiolus": priceWithoutDiscount = num * 2.5;break;
            }

            if(num>80 && flower=="Roses")
            {
                priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.1;
            }
            else if (num > 90 && flower == "Dahlias")
            {
                priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.15;
            }
            else if (num > 80 && flower == "Tulips")
            {
                priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.15;
            }
            else if (num < 120 && flower == "Narcissus")
            {
                priceWithDiscount = priceWithoutDiscount + priceWithoutDiscount * 0.15;
            }
            else if (num < 80 && flower == "Gladiolus")
            {
                priceWithDiscount = priceWithoutDiscount + priceWithoutDiscount * 0.2;
            }
            else { priceWithDiscount = priceWithoutDiscount; }

            if(priceWithDiscount <= budget)
            {
                Console.WriteLine($"Hey, you have a great garden with {num} {flower} and {budget-priceWithDiscount:F2} leva left.");
            }
            else
            {
                Console.WriteLine($"Not enough money, you need {priceWithDiscount - budget:F2} leva more.");
            }
        }
    }
}
