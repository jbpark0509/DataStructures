# Data Structures
Implementations of common data structures using Java.

## Array List

#### Advantages

* Random index accessing. O(1) search when index is known.
* O(1) insertion and removal at the end of list.

#### Disadvantages

* Static size. Resize must occur when no space available in Array List.
* Bad Memory Management. We may need to allocate more memory than is required.
* O(n) insertion and removal by index.
* O(n) search by element.

#### Run Time

Process | Run Time
------ | -----------
Insert at the end of list | O(1) assuming resize is not needed. O(n) if resize is needed.
Insert at specific index(i) | O(n) to increment all elements at index > i. 
Remove at the end of list | O(1) assuming resize is not needed. O(n) if resize is needed.
Remove at specific index(i) | O(n) to decrement all elements at index > i.
Search by element | O(n) to traverse through array.
Search by index | O(1).


## Single Linked List

#### Advantages

* O(1) insertion and deletion in the beginning of list.
* Dynamic sizing.

#### Disadvantages
* Needs to store reference to the next node.
* O(n) to insert, remove, and search at specific index.
* No random index access. Slow search even if index is known.

#### Run Time

Process | Run Time
------ | -----------
Insert at the beginning of list | O(1) to change root reference.
Insert at specific index(i) | O(n) to traverse through list and find node at index i.
Remove at the beginning of list | O(1) to change root reference.
Remove at specific index(i) | O(n) to traverse through list and find node at index i.
Search by element | O(n) to traverse through list and find element.
Search by index | O(n) to traverse through list and find node at index i.


## Double Linked List

#### Advantages

* O(1) insertion and deletion in the beginning and end of list.
* Dynamic sizing.

#### Disadvantages
* Needs to store references to the next node.
* O(n) to insert, remove, and search by at specific index.
* No random index access. Slow search even if index is known.

#### Run Time

Process | Run Time
------ | -----------
Insert at the beginning of list | O(1) to change head reference.
Insert at the end of list | O(1) to change tail reference.
Insert at specific index(i) | O(n) to traverse through list and find node at index i.
Remove at the beginning of list | O(1) to change head reference.
Remove at the end of list | O(1) to change tail reference.
Remove at specific index(i) | O(n) to traverse through list and find node at index i.
Search by element | O(n) to traverse through list and find element.
Search by index | O(n) to traverse through list and find node at index i.

## Stack (Implemented with Linked List)

#### Run Time

Process | Run Time
------ | -----------
Push | O(1)
Pop | O(1)
Peek | O(1)

## Queue (Implemented with Linked List)

#### Run Time

Process | Run Time
------ | -----------
Enqueue | O(1)
Dequeue | O(1)

## Binary Search Tree

#### Advantages

* Keeps the nodes in sorted order. (Can traverse the tree in different orders e.g. pre-order, in-order, post-order traversals)
* Insert, remove, and search operations take O(lg n) if tree is balanced.
* Dynamically sized.

#### Disadvantages

* Insert, remove, and search operations can take up to O(n) in the worst case if tree is not balanced.

#### Run Time

Process | Run Time
------ | -----------
Insert | O(lg n) average. O(n) worst case.
Remove | O(lg n) average. O(n) worst case.
Search | O(lg n) average. O(n) worst case.


## Avl Tree

#### Advantages

* Keeps the tree balanced.
* Keeps the nodes in sorted order. (Can traverse the tree in different orders e.g. pre-order, in-order, post-order traversals)
* Insert, remove, and search operations take O(lg n).
* Dynamically sized.

#### Disadvantages

* Time to balance tree.
* Implementation difficulty.

#### Run Time

Process | Run Time
------ | -----------
Insert | O(lg n)
Remove | O(lg n)
Search | O(lg n)

## Avl Tree

#### Advantages

* Fast search operation for frequently accessed nodes (caching).
* Keeps the nodes in sorted order. (Can traverse the tree in different orders e.g. pre-order, in-order, post-order traversals)
* Dynamically sized.

#### Disadvantages

* Insert, remove, and search operations can take up to O(n) in the worst case if tree is not balanced.

#### Run Time

Process | Run Time
------ | -----------
Insert | O(lg n) average. O(n) worst case.
Remove | O(lg n) average. O(n) worst case.
Search | O(lg n) average. O(n) worst case.

## Author
Jeong Park <jbpark0509@hotmail.com>