import java.util.Scanner;

public class Deal {

	public static void main(String[] args) {

		// step 1 -- create and init variables
		int cardsPerPlayer = 5, players = 0;

		String[] suits = { " ♠", " ♦", " ♥", " ♣" };

		String[] rank = { " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K", " A" };

		int countOfCards = suits.length * rank.length; // count of cards

		// step 2 -- console input

		Scanner sc = new Scanner(System.in);
		System.out.println("Type in count of players ");

		if (sc.hasNextInt()) {

			players = sc.nextInt();

			if (cardsPerPlayer * players > countOfCards) {

				if (players == 0) {

					System.out.println("Game over");

				} else if (players < 0) {

					System.out.println("Count of players cannot be < 0");

				} else {

					System.out.println("Too many players");
				}

			} else {

				// step 3 -- deck init

				String[] deck = new String[countOfCards];

				for (int i = 0; i < rank.length; i++) {

					for (int j = 0; j < suits.length; j++) {

						deck[suits.length * i + j] = rank[i] + " " + suits[j];

					}

				}

				// step 4 -- cards mix
				for (int i = 0; i < countOfCards; i++) {

					int r = i + (int) (Math.random() * (countOfCards - i)); // random card in deck
					String tempCard = deck[r];
					deck[r] = deck[i];
					deck[i] = tempCard;

				}

				// step 5 -- mixed deck output

				System.out.println();

				int cardNo = 0;
				
				for (int j = 0; j < players; j++) {

					System.out.println((j+1) +". player: ");

					for (int i = 0; i < cardsPerPlayer; i++) {
						cardNo++;
						System.out.println(deck[cardNo]);
					}

					System.out.println();
				}


				/* for (int j = 0; j < players * cardsPerPlayer; j++) {

					System.out.println(deck[j]);
					if (j % cardsPerPlayer == cardsPerPlayer - 1) {
						System.out.println();
						System.out.println(++player +". player: ");
					}

				} */




			}

		} else {
			System.out.println("Input error");
		}

		sc.close();

		
	}

}