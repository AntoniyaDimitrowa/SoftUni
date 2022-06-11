using System;

namespace P07._Moving
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int length = int.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());
            int emptyArea = length * width * height;
            string command;
            while ((command = Console.ReadLine()) != "Done")
            {
                int currBoxesNumber = int.Parse(command);
                emptyArea -= currBoxesNumber;
                if(emptyArea < 0)
                {
                    Console.WriteLine($"No more free space! You need {Math.Abs(emptyArea)} Cubic meters more.");
                    break;
                }
            }
            if (emptyArea > 0)
            {
                Console.WriteLine($"{emptyArea} Cubic meters left.");
            }
        }
    }
}
