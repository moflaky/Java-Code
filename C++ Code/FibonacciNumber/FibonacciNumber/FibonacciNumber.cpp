// FibonacciNumber.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int previous1;
	int previous2;
	int current;
	int counter;
	int nthFibonacci;

	cout << "Enter the first two Fibonacci "
		<< "numbers: ";
	cin >> previous1 >> previous2;
	cout << endl;

	cout << "The first two Fibonacci numbers are "
		<< previous1 << " and " << previous2
		<< endl;

	cout << "Enter the position of the desired "
		<< "Fibonacci number: ";
	cin >> nthFibonacci;
	cout << endl;

	for (counter=3;counter <= nthFibonacci;counter++)
	{
		current = previous2 + previous1;
		previous1 = previous2;
		previous2 = current;
	}

	cout << "The Fibonacci number at position "
		<< nthFibonacci << " is " << current
		<< endl;

    return 0;
}

