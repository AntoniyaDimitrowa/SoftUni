using System;

namespace _10._OddEvenSum
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sumOdd = 0;
            int sumEven = 0;
            for (int i = 1; i <= n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (i % 2 == 0)
                {
                    sumEven = sumEven + num;
                }
                else
                {
                    sumOdd = sumOdd + num;
                }
            }
            if (sumOdd == sumEven)
            {
                Console.WriteLine("Yes");
                Console.WriteLine($"Sum = {sumOdd}");
            }
            else if (sumOdd > sumEven)
            {
                Console.WriteLine("No");
                Console.WriteLine($"Diff = {sumOdd - sumEven}");
            }
            else
            {
                Console.WriteLine("No");
                Console.WriteLine($"Diff = {sumEven - sumOdd}");
            }
        }
    }
}
