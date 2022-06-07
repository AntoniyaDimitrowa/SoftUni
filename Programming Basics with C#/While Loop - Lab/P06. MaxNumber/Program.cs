using System;

namespace P06._MaxNumber
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string command;
            int maxNum = int.MinValue;
            while ((command = Console.ReadLine()) != "Stop")
            {
                int currNumber = int.Parse(command);
                if (currNumber > maxNum)
                {
                    maxNum = currNumber;
                }
                
            }
            Console.WriteLine($"{maxNum}");
        }
    }
}
