using System;

namespace _09._LeftAndRightSum
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 1; i <= n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                sum1 = sum1 + num;
            }

            for (int i = n; i < 2 * n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                sum2 = sum2 + num;
            }

            //Console.WriteLine(sum1);
            //Console.WriteLine(sum2);

            if (sum1 == sum2)
            {
                Console.WriteLine($"Yes, sum = {sum1}");
            }
            else if (sum2 > sum1)
            {
                Console.WriteLine($"No, diff = {sum2 - sum1}");
            }
            else
            {
                Console.WriteLine($"No, diff = {sum1 - sum2}");
            }
        }
    }
}
