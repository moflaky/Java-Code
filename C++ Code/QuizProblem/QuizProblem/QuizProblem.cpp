// QuizProblem.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	int quarters, dimes, nickels, pennies;

	cout << "Please enter number of quarters, dimes, nickels:";
	cin >> quarters >> dimes >> nickels;

	pennies = 25 * quarters + 10 * dimes + 5 * nickels;

	cout << "The total value in pennies:" << pennies << endl;
	return 0;
}

