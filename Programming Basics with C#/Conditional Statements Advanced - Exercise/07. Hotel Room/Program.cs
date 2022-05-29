using System;

namespace _07._Hotel_Room
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int nights = int.Parse(Console.ReadLine());
            double priceOfOneNightApartment = 0;
            double priceOfOneNightStudio = 0;
            switch (month)
            {
                case "May":
                case "October":
                    priceOfOneNightApartment = 65;
                    priceOfOneNightStudio = 50;
                    break;
                case "June":
                case "September":
                    priceOfOneNightApartment = 68.70;
                    priceOfOneNightStudio = 75.20;
                    break;
                case "July":
                case "August":
                    priceOfOneNightApartment = 77;
                    priceOfOneNightStudio = 76;
                    break;
            }
            double priceApartment = nights * priceOfOneNightApartment;
            double priceStudio = nights * priceOfOneNightStudio;

            if (nights > 14 && (month == "May" || month == "October"))
            {
                priceStudio = priceStudio - priceStudio * 0.3;
            }
            else if(nights > 7 && nights<=14 && (month == "May" || month == "October"))
            {
                priceStudio = priceStudio - priceStudio * 0.05;
            }
            if (nights > 14 && (month == "June" || month == "September"))
            {
                priceStudio = priceStudio - priceStudio * 0.2;
            }
            if (nights > 14)
            {
                priceApartment = priceApartment - priceApartment * 0.1;
            }

            Console.WriteLine($"Apartment: {priceApartment:F2} lv.");
            Console.WriteLine($"Studio: {priceStudio:F2} lv.");
        }
    }
}
