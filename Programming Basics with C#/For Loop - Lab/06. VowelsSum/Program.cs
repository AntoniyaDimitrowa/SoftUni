﻿using System;

namespace _06._VowelsSum
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            int sum = 0;
            for (int i = 0; i < text.Length; i++)
            {
                if (text[i] == 'a')
                {
                    sum++;
                }
                if (text[i] == 'e')
                {
                    sum = sum + 2;
                }
                if (text[i] == 'i')
                {
                    sum = sum + 3;
                }
                if (text[i] == 'o')
                {
                    sum = sum + 4;
                }
                if (text[i] == 'u')
                {
                    sum = sum + 5;
                }
            }
            Console.WriteLine(sum);
        }
    }
}
