// CodeDetection.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <iomanip>

using namespace std;
const int MAX_CODE_SIZE = 250;
void readCode(int list[], int& length, bool& lenCodeOk);
void compareCode(const int list[], int length);

int main()
{
	int codeArray[MAX_CODE_SIZE];
	int codeLength;
	bool lengthCodeOk;

	cout << "Please enter the received message: " << endl;
	
	readCode(codeArray, codeLength, lengthCodeOk);
	
	if (lengthCodeOk)
		compareCode(codeArray, codeLength);
	else
		cout << "The length of the secret code must be <= " << MAX_CODE_SIZE << endl;
    return 0;
}

void readCode(int list[], int& length, bool& lenCodeOk)
{
	lenCodeOk = true;
	cin >> length;
	if (length > MAX_CODE_SIZE)
	{	
		lenCodeOk = false;
			return;
	}
	for (int count = 0; count < length; count++)
		cin >> list[count];
}

void compareCode(const int list[], int length)
{
	int length2;
	int digit;
	bool codeOk;
	
	codeOk = true;
	
	cin >> length2;
	if (length != length2)
	{
		cout << "The original code and its copy are not of the same length" << endl;
		return;
	}
	cout << "Code Digit     Code Digit Copy" << endl;
	for (int count = 0; count, length; count++)
	{
		cin >> digit;
		cout << setw(5) << list[count] << setw(17) << digit;
		if (digit != list[count])
		{
			cout << " code digits are not the same" << endl;
			codeOk = false;
		}
		else
			cout << endl;
		
	}
	if (codeOk)
		cout << "Message transmitted OK." << endl;
	else
		cout << "Error in transmission. Retransmit!!" << endl;
}