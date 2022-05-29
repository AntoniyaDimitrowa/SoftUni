using System;

namespace _01._Cinema
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string typeProjection =Console.ReadLine();
            int r = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());
            int countOfTickets = r * c;
            switch (typeProjection)
            {
                case "Premiere": Console.WriteLine($"{countOfTickets * 12.00:F2} leva");break;
                case "Normal": Console.WriteLine($"{countOfTickets * 7.50:F2} leva");break;
                case "Discount": Console.WriteLine($"{countOfTickets * 5.00:F2} leva");break;
            }
        }
    }
}
