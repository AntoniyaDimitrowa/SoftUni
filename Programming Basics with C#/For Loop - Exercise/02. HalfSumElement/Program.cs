using System;

namespace _02._HalfSumElement
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sum = 0;
            int maxNum = int.MinValue;
            for(int i = 1;i<= n;i++)
            {
                int num = int.Parse(Console.ReadLine());
                sum = sum + num;
                if (maxNum<num)
                {
                    maxNum = num;
                }
            }
            int sumWithoutMaxNum = sum - maxNum;
            if(maxNum== sumWithoutMaxNum)
            {
                Console.WriteLine($"Yes");
                Console.WriteLine($"Sum = {sumWithoutMaxNum}");
            }
            else
            {
                Console.WriteLine($"No");
                Console.WriteLine($"Diff = {Math.Abs(sumWithoutMaxNum - maxNum)}");
            }
        }
    }
}
