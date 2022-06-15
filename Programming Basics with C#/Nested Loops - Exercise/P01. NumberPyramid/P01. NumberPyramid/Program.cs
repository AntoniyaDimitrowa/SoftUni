using System;

namespace P01._NumberPyramid
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int num = 1;

            for (int row = 1; row <= n; row++)
            {
                for (int col = 1; col <= row; col++)
                {
                    if (num > n)
                    {
                        break;
                    }
                    Console.Write(num + " ");
                    num++;
                }
                if (num > n)
                {
                    break;
                }
                Console.WriteLine();
            }
        }
    }
}
