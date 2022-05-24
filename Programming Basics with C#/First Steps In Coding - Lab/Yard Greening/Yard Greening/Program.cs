using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Yard_Greening
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double squerMetersForGreening = double.Parse(Console.ReadLine());
            double priceWithoutDiscount = squerMetersForGreening * 7.61;
            double discount = priceWithoutDiscount * 0.18;
            double finalPrice = priceWithoutDiscount - discount;

            Console.WriteLine($"The final price is: {finalPrice} lv.");
            Console.WriteLine($"The discount is: {discount} lv.");
        }
    }
}
