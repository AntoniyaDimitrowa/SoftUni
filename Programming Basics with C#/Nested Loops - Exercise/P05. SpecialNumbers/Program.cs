using System;

namespace P05._SpecialNumbers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            for (int i = 1111; i < 10000; i++)
            {
                int currNum = i;
                bool isSpecial = true;
                for (int j = 1; j <= 4; j++)
                {
                    int lastDigit = currNum % 10;
                    if (lastDigit == 0)
                    {
                        isSpecial = false;
                        break;
                    }

                    if (number % lastDigit != 0)
                    {
                        isSpecial = false;
                        break;
                    }
                    currNum /= 10;
                }
                if (isSpecial)
                {
                    Console.Write(i.ToString() + " ");
                }
            }
        }
    }
}
