using System;

namespace _12._Trade_Commissions
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string city = Console.ReadLine();
            double salesVolume = double.Parse(Console.ReadLine());

            if(salesVolume >=0 && salesVolume <=500)
            {
                switch(city)
                {
                    case "Sofia":Console.WriteLine($"{0.05 * salesVolume:F2}");break;
                    case "Varna":Console.WriteLine($"{0.045 * salesVolume:F2}");break;
                    case "Plovdiv":Console.WriteLine($"{0.055 * salesVolume:F2}");break;
                    default:Console.WriteLine("error");break;
                }
            }
            else if (salesVolume > 500 && salesVolume <= 1000)
            {
                switch (city)
                {
                    case "Sofia": Console.WriteLine($"{0.07 * salesVolume:F2}"); break;
                    case "Varna": Console.WriteLine($"{0.075 * salesVolume:F2}"); break;
                    case "Plovdiv": Console.WriteLine($"{0.08 * salesVolume:F2}"); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (salesVolume > 1000 && salesVolume <= 10000)
            {
                switch (city)
                {
                    case "Sofia": Console.WriteLine($"{0.08 * salesVolume:F2}"); break;
                    case "Varna": Console.WriteLine($"{0.1 * salesVolume:F2}"); break;
                    case "Plovdiv": Console.WriteLine($"{0.12 * salesVolume:F2}"); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else if (salesVolume > 10000 )
            {
                switch (city)
                {
                    case "Sofia": Console.WriteLine($"{0.12 * salesVolume:F2}"); break;
                    case "Varna": Console.WriteLine($"{0.13 * salesVolume:F2}"); break;
                    case "Plovdiv": Console.WriteLine($"{0.145 * salesVolume:F2}"); break;
                    default: Console.WriteLine("error"); break;
                }
            }
            else { Console.WriteLine("error"); }
        }
    }
}
