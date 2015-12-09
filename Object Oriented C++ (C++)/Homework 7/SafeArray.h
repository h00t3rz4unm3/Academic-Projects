//
//  SafeArray.h
//  Homework 7
//
//  Created by Alexandru Gutu on 12/11/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Homework_7__SafeArray__
#define __Homework_7__SafeArray__

template <class T>
class SafeArray
{
private:
	T* array;
	int size;
	
public:
	SafeArray();
	SafeArray(int s);
	int length() const;
	T& operator [] (int index);
	~SafeArray();
	SafeArray(const SafeArray<T>& other);
	SafeArray<T>& operator = (const SafeArray<T>& other);
};
#endif /* defined(__Homework_7__SafeArray__) */
