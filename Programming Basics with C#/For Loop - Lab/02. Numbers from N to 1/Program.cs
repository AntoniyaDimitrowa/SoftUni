using System;

namespace _02._Numbers_from_N_to_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            for (int i = num; i >= 1; i--)
            {
                Console.WriteLine(i);
            }
        }
    }
}
