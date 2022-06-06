using System;

namespace P03._SumNumbers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int desiredSum = int.Parse(Console.ReadLine());
            int sum = 0;
            while(sum< desiredSum)
            {
                int number = int.Parse(Console.ReadLine());
                sum = sum + number;
            }
            Console.WriteLine(sum);
        }
    }
}
