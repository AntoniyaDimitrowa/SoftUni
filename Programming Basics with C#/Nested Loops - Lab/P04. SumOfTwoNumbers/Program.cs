using System;

namespace P04._SumOfTwoNumbers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int intervalBeginning = int.Parse(Console.ReadLine());
            int intervalEnd = int.Parse(Console.ReadLine());
            int magicalNumber = int.Parse(Console.ReadLine());
            int combinations = 0;
            bool isFound = false;

            for (int x1 = intervalBeginning; x1 <= intervalEnd; x1++)
            {
                for (int x2 = intervalBeginning; x2 <= intervalEnd; x2++)
                {
                    int sum = x1 + x2;
                    combinations++;
                    if (sum == magicalNumber)
                    {
                        isFound = true;
                        Console.WriteLine($"Combination N:{combinations} ({x1} + {x2} = {magicalNumber})");
                        break;
                    }
                }
                if (isFound)
                {
                    break;
                }
            }
            if (isFound == false)
            {
                Console.WriteLine($"{combinations} combinations - neither equals {magicalNumber}");
            }
        }
    }
}
