using System;

namespace _09._Ski_Trip
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            int nights = days - 1;
            string typeRoom = Console.ReadLine();
            string grade = Console.ReadLine();
            double price = 0;

            if(typeRoom == "room for one person")
            {
                price = nights * 18.00;
            }
            else if(typeRoom == "apartment")
            {
                price = nights * 25.00;
                if(nights<10)
                {
                    price = price - price * 0.3;
                }
                else if(nights>15)
                {
                    price = price - price * 0.5;
                }
                else
                {
                    price = price - price * 0.35;
                }
            }
            else if(typeRoom == "president apartment")
            {
                price = nights * 35.00;
                if (nights < 10)
                {
                    price = price - price * 0.1;
                }
                else if (nights > 15)
                {
                    price = price - price * 0.2;
                }
                else
                {
                    price = price - price * 0.15;
                }
            }
            double finalePrice = 0;
            if (grade == "positive")
            {
                finalePrice = price + price * 0.25; 
            }
            if (grade == "negative")
            {
                finalePrice = price - price * 0.1;
            }
            Console.WriteLine($"{finalePrice:F2}");
        }
    }
}
