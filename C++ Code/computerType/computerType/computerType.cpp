// computerType.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

struct computerType
{
	string manufacturer;
	string modelType;
	string processor;
	int ram;
	int hardDriveSize;
	int yearBuilt;
	double price;
};

void printResults(computerType newComputer);

int main()
{
	
	computerType newComputer;

	cout << "Enter the computer manufacturer: " << endl;
	cin >> newComputer.manufacturer;
	cout << endl;

	cout << "Enter the model type of the computer: " << endl;
	cin >> newComputer.modelType;
	cout << endl;

	cout << "Enter the processor type of the computer: " << endl;
	cin >> newComputer.processor;
	cout << endl;

	cout << "Enter the amount of ram in gigabytes of the computer: " << endl;
	cin >> newComputer.ram;
	cout << endl;

	cout << "Enter the hard drive size in gigabytes of the computer: " << endl;
	cin >> newComputer.hardDriveSize;
	cout << endl;

	cout << "Enter the year when the computer was built: " << endl;
	cin >> newComputer.yearBuilt;
	cout << endl;

	cout << "Enter the price of the computer: " << endl;
	cin >> newComputer.price;
	cout << endl;

	printResults(newComputer);

	return 0;
}

void printResults(computerType newComputer)
{
	cout << "The following specifications were given: " << endl << "...................."
		<< "\nComputer Manufacturer: " << newComputer.manufacturer << endl << "...................."
		<< "\nModel Type: " << newComputer.modelType << endl << "...................."
		<< "\nProcessor Type: " << newComputer.processor << endl << "...................."
		<< "\nRam in GB: " << newComputer.ram << endl << "...................."
		<< "\nHard Drive Size in GB: " << newComputer.hardDriveSize << endl << "...................."
		<< "\nYear the Computer was Built in: " << newComputer.yearBuilt << endl << "...................."
		<< "\nThe Price of the Computer: " << newComputer.price << endl << "...................." << endl;
}
