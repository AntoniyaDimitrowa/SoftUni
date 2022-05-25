using System;

namespace RadiansToDegrees
{
    internal class ConverterRadiansDegrees
    {
        static void Main(string[] args)
        {
            double radians = double.Parse(Console.ReadLine());
            
            Console.WriteLine(radians * 180 / Math.PI);
        }
    }
}
