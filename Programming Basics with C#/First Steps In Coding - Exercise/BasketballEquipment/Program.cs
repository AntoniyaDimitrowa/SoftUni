using System;

namespace BasketballEquipment
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int priceOfBasketballTraining = int.Parse(Console.ReadLine());
            double priceOfBasketBallSneakers = priceOfBasketballTraining - (0.4 * priceOfBasketballTraining);
            double priceOfBasketballOutfit = priceOfBasketBallSneakers - (0.2 * priceOfBasketBallSneakers);
            double priceOfBasketballBall = 0.25 * priceOfBasketballOutfit;
            double priceOfBasketballAccessories = 0.2 * priceOfBasketballBall;

            double wholePrice = priceOfBasketballAccessories + priceOfBasketballTraining + priceOfBasketBallSneakers + priceOfBasketballBall + priceOfBasketballOutfit;
            Console.WriteLine(wholePrice);
        }
    }
}
