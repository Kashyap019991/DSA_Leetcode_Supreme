package com.kas.dsasupreme.BinarySearchTree;

class Heap {
	int[] arr = new int[100];
	int size;

	Heap() {
		arr[0] = -1;
		size = 0;

	}

	void insert(int elem) {

		size = size + 1;
		int index = size;
		arr[index] = elem;

		while (index > 1) {
			int par = index / 2;
			if (arr[par] < arr[index]) {
				int k = arr[par];
				arr[par] = arr[index];
				arr[index] = k;
				index = par;
			} else
				return;
		}
	}

	void swap(int index, int lr){
		int k = arr[lr];
		arr[lr] = arr[index];
		arr[index] = k;
	}
	void deleteFromHeap() {

		// put last elem to root and remove last element
		arr[1] = arr[size];
		size = size - 1;

		// move r oot to appropriate pos
		int index = 1;
		while (index < size) {
			int left = (2 * index);
			int right = (2 * index) + 1;

			
			if (left < size && right < size && arr[left] > arr[right]) {
				swap(index, left);
				index = left;
			}
			else if (left < size && right < size && arr[left] < arr[right]) 
			{
				swap(index, right);
				index = right;
				
			}
			else 
				return;

		}

	}

	void print() {
		for (int i = 1; i <= size; i++)
			System.out.println(arr[i]);
	}
}

public class Lect74_1_InsertionInHeap {

	public static void main(String[] args) {

		Heap h = new Heap();
		/*h.insert(50);
		h.insert(55);
		h.insert(53);
		h.insert(52);
		h.insert(54);*/
		h.insert(55);
		h.insert(52);
		h.insert(53);
		h.insert(50);
		h.insert(51);
		h.print();
		h.deleteFromHeap();
		System.out.println();
		h.print();
	}
}