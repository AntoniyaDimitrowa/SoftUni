using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectsCreation
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            int numberOfProjects = int.Parse(Console.ReadLine());
            Console.WriteLine($"The architect {name} will need {numberOfProjects*3} hours to complete {numberOfProjects} project/s.");
        }
    }
}
