using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pet_Shop
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numberOfPacketsWithDogFood = int.Parse(Console.ReadLine()); 
            int numberOfPacketsWithCatFood = int.Parse(Console.ReadLine());
            Console.WriteLine($"{numberOfPacketsWithCatFood * 4 + numberOfPacketsWithDogFood * 2.5} lv.");
        }
    }
}
