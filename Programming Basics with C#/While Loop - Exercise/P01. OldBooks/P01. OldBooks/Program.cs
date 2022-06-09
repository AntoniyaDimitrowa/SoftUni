using System;

namespace P01._OldBooks
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string favouriteBook = Console.ReadLine();
            string book;
            int cnt = 0;
            while((book = Console.ReadLine())!= "No More Books")
            {
                if(book == favouriteBook)
                {
                    Console.WriteLine($"You checked {cnt} books and found it.");
                    break;
                }
                cnt++;
            }
            if (book == "No More Books")
            {
                Console.WriteLine($"The book you search is not here!");
                Console.WriteLine($"You checked {cnt} books.");
            }
        }
    }
}
