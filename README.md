Array and Linked List based implementations of Doubly Ended Queue (Deque), based on [Berkley’s CS61B](https://sp19.datastructur.es/) assignments ([project 1a](https://sp19.datastructur.es/materials/proj/proj1a/proj1a), [project 1b](https://sp19.datastructur.es/materials/proj/proj1b/proj1b)), and practical usage of the said implementations in palindrome (a word that is the same whether it is read forwards or backwards) checkers.

Technologies used: __Java__, __JUnit__.

Data structure related files:
* __Deque.java__ - interface that contains methods used while implementing Doubly Ended Queue.
* __LinkedListDeque.java__ - Linked List-based implementation of Doubly Ended Queue, using circular sentinel node tracking both the first and the last element.
Time complexity of LinkedListDeque.java methods:
	- *addFirst(T item)*: O(1),
	- *addLast(T item)*: O(1),
	- *size()*: O(1),
	- *printDeque()*: O(n),
	- *removeFirst()*: O(1),
	- *removeLast()*: O(1),
	- *get()*: O(n),
	- *getRecursive()*: O(n).
* __ArrayDeque.java__ - Array-based implementation of Doubly Ended Queue, treating the array as circular, meaning if the front pointer is at position zero invoking addFirst() method loops the pointer back around to the end of the array.
Time complexity of ArrayDeque.java methods:
	- *addFirst(T item)*: O(1), if adding a new item requires resizing the array– O(n),
	- *addLast(T item)*: O(1), if adding a new item requires resizing the array– O(n),
	- *size()*: O(1),
	- *printDeque()*: O(n),
	- *removeFirst()*: O(1), if removing an item requires resizing the array– O(n),
	- *removeLast()*: O(1), if removing an item requires resizing the array– O(n),
	- *get()*: O(1).

Additional files for practical usage of Doubly Ended Queue with palindromes:
* __CharacterComparator.java__ - An interface for comparing characters.
* __Palindrome.java__ - A class for checking whether the word is a palindrome.
* __OffByOne.java__ - A class for off-by-1 comparators, checks whether two characters are exactly one space away from each other in the alphabet (e.g. ‘a’, ‘b’).
* __OffByN.java__ - A class for off-by-N comparators, checks whether two characters are exactly N spaces away from each other in the alphabet (e.g. ‘a’, ‘f’).
* __TestPalindrome.java__ - A class containing JUnit tests for Palindrome.java
* __TestOffByOne.java__ - A class containing JUnit tests for OffByOne.java
* __TestOffByN.java__ - A class containing JUnit tests for OffByN.java
