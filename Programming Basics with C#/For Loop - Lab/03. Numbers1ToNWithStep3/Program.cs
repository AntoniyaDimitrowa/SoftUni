using System;

namespace _03._Numbers1ToNWithStep3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            for (int i = 1; i <= num; i = i+3)
            {
                Console.WriteLine(i);
            }
        }
    }
}
