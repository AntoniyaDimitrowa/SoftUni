using System;

namespace P03._Vacation
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double neededMoney = double.Parse(Console.ReadLine());
            double ownedMoney = double.Parse(Console.ReadLine());
            int spendingCounter = 0;
            int daysCounter = 0;
            while(true)
            {
                if(spendingCounter >= 5)
                {
                    Console.WriteLine($"You can't save the money.");
                    Console.WriteLine($"{daysCounter}");
                    break;
                }
                if(ownedMoney>=neededMoney)
                {
                    Console.WriteLine($"You saved the money for {daysCounter} days.");
                    break;
                }
                string command = Console.ReadLine();
                double currMoney = double.Parse(Console.ReadLine());   
                if(command=="spend")
                {
                    spendingCounter++;
                    if (currMoney < ownedMoney)
                    {
                        ownedMoney = ownedMoney - currMoney;
                    }
                    else { ownedMoney = 0; }
                }
                else if(command=="save")
                {
                    ownedMoney += currMoney;
                    spendingCounter = 0;
                }
                daysCounter++;
            }
        }
    }
}
