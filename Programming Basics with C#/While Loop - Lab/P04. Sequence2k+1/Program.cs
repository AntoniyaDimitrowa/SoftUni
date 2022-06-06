using System;

namespace P04._Sequence2k_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int currNumber = 1;
            while(currNumber <= number)
            {
                Console.WriteLine(currNumber);
                currNumber = currNumber * 2 + 1;
            }
        }
    }
}
