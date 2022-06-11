using System;

namespace DepositCalculator
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double depositSum = double.Parse(Console.ReadLine());
            int termInMonths = int.Parse(Console.ReadLine());
            double rate = double.Parse(Console.ReadLine());

            Console.WriteLine(depositSum + termInMonths * ((depositSum * (rate / 100)) / 12));
        }
    }
}
