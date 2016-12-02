# DataStructures
Implementations of common data structures using Java.

## Array List

#### Advantages

* Random index accessing. Fast search when index is known.
* Fast insertion and removal at the end of list.

#### Disadvantages

* Static size. Resize must occur when no space available in Array List.
* Bad Memory Management. We may need to allocate more memory than is required.
* Slow insertion and removal by index.
* Slow search by element.

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

## Author
Jeong Park <jbpark0509@hotmail.com>