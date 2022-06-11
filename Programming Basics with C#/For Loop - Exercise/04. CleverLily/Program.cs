using System;

namespace _04._CleverLily
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int age = int.Parse(Console.ReadLine());
            double laundryPrice = double.Parse(Console.ReadLine());
            int toyPrice = int.Parse(Console.ReadLine());
            double birthdayMoney = 0;
            double toys = 0;

            for (int i = 1; i <= age; i++)
            {
                if (i % 2 == 0)
                {
                    birthdayMoney = birthdayMoney + (i * 5) - 1;
                }
                else
                {
                    toys++;
                }
            }

            double totalMoney = birthdayMoney + (toys * toyPrice);

            if (totalMoney >= laundryPrice)
            {
                Console.WriteLine($"Yes! {(totalMoney - laundryPrice):F2}");
            }
            else
            {
                Console.WriteLine($"No! {(laundryPrice - totalMoney):F2}");
            }
        }
    }
}
