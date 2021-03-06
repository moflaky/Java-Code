// ClassifyNumbers.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;
const int N = 20;
void initialize(int& zeroCount, int& evenCount, int& oddCount);
void getNumber(int& num);
void classifyNumber(int num, int& zeroCount, int& oddCount, int& evenCount);
void printResult(int zeroCount, int oddCount, int evenCount);

int main()
{
	int counter;
	int number;
	int zeros;
	int odds;
	int evens;

	initialize(zeros, odds, evens);

	cout << "Please enter " << N << " integers, "
		<< "positive or zeros."
		<< endl;

	cout << "The numbers you entered are:" << endl;

	for (counter = 1; counter <= N; counter++)
	{
		getNumber(number);
		cout << number << " ";
		classifyNumber(number, evens, zeros, odds);
	}

	cout << endl;

	printResult(zeros, odds, evens);

	return 0;
}

void initialize(int& zeroCount, int& oddCount, int& evenCount)
{
	zeroCount = 0;
	oddCount = 0;
	evenCount = 0;

}
void getNumber(int& num)
{
	cin >> num;
}
void classifyNumber(int num, int& zeroCount, int& oddCount, int& evenCount)
{
	switch (num % 2)
	{
	case 0:
		evenCount++;
		if (num == 0)
			zeroCount++;
		break;
	case 1:
		oddCount++;
	}
}
void printResult(int zeroCount, int oddCount, int evenCount)
{
	cout << "There are " << evenCount << " evens, "
		<< "which includes " << zeroCount << " zeros."
		<< endl;
	cout << "The number of odd numbers is: " << oddCount
		<< endl;
}