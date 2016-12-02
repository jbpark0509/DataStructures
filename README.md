# DataStructures
Implementations of common data structures using Java.

## Array List

#### Advantages

* Fast search when index is known.
* Fast insertion and removal at the end of list.

#### Disadvantages

* Static size. Resize must occur when no space available in Array List.
* Bad Memory Management. We may need to allocate more memory than is required.
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

## Author
Jeong Park <jbpark0509@hotmail.com>