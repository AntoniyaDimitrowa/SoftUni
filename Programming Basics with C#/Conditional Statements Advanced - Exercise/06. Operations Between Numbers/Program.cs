using System;

namespace _06._Operations_Between_Numbers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            char operators = char.Parse(Console.ReadLine());
            double result = 0;
            if(operators == '+' || operators == '-' || operators == '*')
            {
                if (operators == '+')
                {
                    result = num1 + num2;
                }
                else if (operators == '-')
                {
                    result = num1 - num2;
                }
                else if (operators == '*')
                {
                    result = num1 * num2;
                }
                if (result % 2 == 0)
                {
                    Console.WriteLine($"{num1} {operators} {num2} = {result} - even");
                }
                else
                {
                    Console.WriteLine($"{num1} {operators} {num2} = {result} - odd");
                }
            }
            else if(operators =='/' || operators=='%')
            {
                if (num2 == 0)
                {
                    Console.WriteLine($"Cannot divide {num1} by zero");
                }
                else
                {
                    if (operators == '/')
                    {
                        result = (num1*1.0) / num2;
                        Console.WriteLine($"{num1} {operators} {num2} = {result:F2}");
                    }
                    else if (operators == '%')
                    {
                        result = num1 % num2;
                        Console.WriteLine($"{num1} {operators} {num2} = {result}");
                    }
                }

            }
        }
    }
}
