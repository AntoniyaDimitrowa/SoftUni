using System;

namespace P06._Building
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int floors = int.Parse(Console.ReadLine());
            int roomsInOneFloor = int.Parse(Console.ReadLine());
            for (int floor = floors; floor >= 1; floor--)
            {
                for (int room = 0; room < roomsInOneFloor; room++)
                {
                    if (floor == floors)
                    {
                        Console.Write($"L{floor}{room} ");
                    }
                    else if (floor % 2 == 0)
                    {
                        Console.Write($"O{floor}{room} ");
                    }
                    else if (floor % 2 != 0)
                    {
                        Console.Write($"A{floor}{room} ");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
