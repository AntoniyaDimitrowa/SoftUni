using System;

namespace _03._Histogram
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int numbersFirstGroup = 0;
            int numbersSecondGroup = 0;
            int numbersThirdGroup = 0;
            int numbersFourthGroup = 0;
            int numbersFifthGroup = 0;
            for (int i = 1; i <= n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (num<200)
                {
                    numbersFirstGroup++;
                }
                if (num >= 200 && num<400)
                {
                    numbersSecondGroup++;
                }
                if (num >= 400 && num < 600)
                {
                    numbersThirdGroup++;
                }
                if (num >= 600 && num < 800)
                {
                    numbersFourthGroup++;
                }
                if (num >= 800)
                {
                    numbersFifthGroup++;
                }
            }
            //Console.WriteLine(numbersFirstGroup);
            Console.WriteLine($"{(numbersFirstGroup*1.0) / n * 100:F2}%");
            Console.WriteLine($"{(numbersSecondGroup * 1.0) / n * 100:F2}%");
            Console.WriteLine($"{(numbersThirdGroup * 1.0) / n * 100:F2}%");
            Console.WriteLine($"{(numbersFourthGroup * 1.0) / n * 100:F2}%");
            Console.WriteLine($"{(numbersFifthGroup * 1.0) / n * 100:F2}%");
        }
    }
}
