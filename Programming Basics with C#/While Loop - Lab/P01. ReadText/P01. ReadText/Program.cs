using System;

namespace P01._ReadText
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string text;
            while((text = Console.ReadLine()) != "Stop")
            {
                Console.WriteLine(text);
            }
        }
    }
}
