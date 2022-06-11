using System;

namespace P06._Cake
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int length = int.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());
            int cakeS = length * width;
            string command;
            while((command = Console.ReadLine())!= "STOP")
            {
                int currPiecesNumber = int.Parse(command);
                cakeS -= currPiecesNumber;
                if(cakeS < 0)
                {
                    Console.WriteLine($"No more cake left! You need {Math.Abs(cakeS)} pieces more.");
                    break;
                }
            }
            if (cakeS > 0)
            {
                Console.WriteLine($"{cakeS} pieces are left.");
            }
                
        }
    }
}
