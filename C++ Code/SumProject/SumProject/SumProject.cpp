// SumProject.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;
const int LIST_SIZE = 50;

int main()
{
	int list[50];

	cout << "Enter " << LIST_SIZE << "integers: " << endl;
	cout << endl;

	for (int i = 0; i < 50; i++)
		cin >> list[i];
	cout << endl;

	for (int i = 0; i < LIST_SIZE; i++)
	{
		cout << "list[" << i << "] = " << list[i] << " is the sum of: ";
		for (int j = 0; j < LIST_SIZE; j++)
			for (int k = j + 1; k < LIST_SIZE; k++)
				if (list[i] == list[j] + list[k])
					cout << "list[" << j << "], list[" << k << "]; ";
		cout << endl;
		cout << "--------------------" << endl;
	}

    return 0;
}
