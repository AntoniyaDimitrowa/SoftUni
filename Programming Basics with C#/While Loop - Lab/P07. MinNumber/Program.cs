using System;

namespace P07._MinNumber
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string command;
            int minNum = int.MaxValue;
            while ((command = Console.ReadLine()) != "Stop")
            {
                int currNumber = int.Parse(command);
                if (currNumber < minNum)
                {
                    minNum = currNumber;
                }

            }
            Console.WriteLine($"{minNum}");
        }
    }
}
