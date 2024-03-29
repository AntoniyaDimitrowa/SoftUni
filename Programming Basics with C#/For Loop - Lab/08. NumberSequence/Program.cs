﻿using System;

namespace _08._NumberSequence
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int min = int.MaxValue;
            int max = int.MinValue;
            for (int i = 1; i <= n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (num < min)
                {
                    min = num;
                }
                if (num > max)
                {
                    max = num;
                }
            }
            Console.WriteLine($"Max number: {max}");
            Console.WriteLine($"Min number: {min}");
        }
    }
}
