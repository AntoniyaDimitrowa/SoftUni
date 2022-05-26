using System;

namespace _07._Area_of_Figures
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string figures = Console.ReadLine();
            if(figures == "square")
            {
                double a = double.Parse(Console.ReadLine());
                Console.WriteLine($"{a * a:F3}");
            }
            if (figures == "rectangle")
            {
                double a = double.Parse(Console.ReadLine());
                double b = double.Parse(Console.ReadLine());
                Console.WriteLine($"{a * b:F3}");
            }
            if (figures == "circle")
            {
                double r = double.Parse(Console.ReadLine());
                Console.WriteLine($"{Math.PI * r * r:F3}");
            }
            if (figures == "triangle")
            {
                double a = double.Parse(Console.ReadLine());
                double h = double.Parse(Console.ReadLine());
                Console.WriteLine($"{(a * h) / 2:F3}");
            }
        }
    }
}
