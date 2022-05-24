using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InchInCentimeters
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double inch = double.Parse(Console.ReadLine());
            Console.WriteLine(inch*2.54);
        }
    }
}
