using System;

namespace P03._SumPrimeNonPrime
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int primeNumbersSum = 0;
            int nonPrimeNumbersSum = 0;

            string command;
            while ((command = Console.ReadLine()) != "stop")
            {
                int currNum = int.Parse(command);

                if (currNum < 0)
                {
                    Console.WriteLine("Number is negative.");
                    continue;
                }

                bool isPrime = true;
                for (int divider = 2; divider < currNum; divider++)
                {
                    if (currNum % divider == 0)
                    {
                        isPrime = false;
                        nonPrimeNumbersSum += currNum;
                        break;
                    }
                }
                if (isPrime)
                {
                    primeNumbersSum += currNum;
                }
            }
            Console.WriteLine($"Sum of all prime numbers is: {primeNumbersSum}");
            Console.WriteLine($"Sum of all non prime numbers is: {nonPrimeNumbersSum}");
        }
    }
}
