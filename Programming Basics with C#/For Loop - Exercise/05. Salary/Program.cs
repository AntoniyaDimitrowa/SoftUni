using System;

namespace _05._Salary
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int countOfOpenedWebtabs = int.Parse(Console.ReadLine());
            int salary = int.Parse(Console.ReadLine());
            for(int i = 1;i<= countOfOpenedWebtabs;i++)
            {
                string websiteName = Console.ReadLine();
                if (websiteName== "Facebook")
                {
                    salary = salary - 150;
                }
                if (websiteName == "Instagram")
                {
                    salary = salary - 100;
                }
                if (websiteName == "Reddit")
                {
                    salary = salary - 50;
                }
                if(salary <= 0)
                {
                    Console.WriteLine("You have lost your salary.");
                    break;
                }
            }
            if (salary > 0)
            {
                Console.WriteLine(salary);
            }
        }
    }
}
