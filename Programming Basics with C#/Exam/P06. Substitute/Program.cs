using System;

namespace P06._Substitute
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int k = int.Parse(Console.ReadLine());
            int l = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());
            int validCounter = 0;


            for (int i = k; i <= 8; i++)
            {
                for (int j = 9; j >= l; j--)
                {
                    int firstNum = i * 10 + j;

                    for (int x = m; x <= 8; x++)
                    {
                        for (int y = 9; y >= n; y--)
                        {
                            int secondNum = x * 10 + y;
                            if (i % 2 == 0 && j % 2 != 0 && x % 2 == 0 && y % 2 != 0)
                            {

                                if (firstNum == secondNum)
                                {
                                    Console.WriteLine($"Cannot change the same player."); ;
                                    continue;
                                }
                                else
                                {
                                    validCounter++;
                                    Console.WriteLine($"{i}{j} - {x}{y}");
                                }
                            }
                            if (validCounter == 6)
                            {
                                break;
                            }
                        }
                        if (validCounter == 6)
                        {
                            break;
                        }
                    }
                    if (validCounter == 6)
                    {
                        break;
                    }
                }
                if (validCounter == 6)
                {
                    break;
                }
            }
        }
    }
}
