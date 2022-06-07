using System;

namespace P08._Graduation
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            int currClass = 1;
            double totalGrades = 0;
            int repeatCounter = 0;
            while(currClass<=12)
            {
                double currClassGrade = double.Parse(Console.ReadLine());
                totalGrades += currClassGrade;

                //If the grade is under 4 we repeat the same class
                if(currClassGrade<4)
                {
                    repeatCounter++;
                    //If we repeat the same class more than once we are expelled
                    if (repeatCounter > 1)
                    {
                        break;
                    }
                    continue;
                }

                //If the grade is higher than 4 I go into the next class
                currClass++;
            }
            

            //If we repeat a class more than once we are expelled
            if (repeatCounter > 1)
            {
                Console.WriteLine($"{name} has been excluded at {currClass} grade");
            }
            else
            {
                double averageGrades = totalGrades/(currClass-1 + repeatCounter);
                Console.WriteLine($"{name} graduated. Average grade: {averageGrades:F2}");
            }
        }
    }
}
