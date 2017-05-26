#include <stdio.h>


struct ListNode {
  int val;
  struct ListNode *next;
};

struct ListNode *detectCycle(struct ListNode *head) {
  if (head == NULL) {
    return NULL;
  }

  struct ListNode *slow = head;
  struct ListNode *fast = head;

  do {
    if (fast->next == NULL) {
      return NULL;
    } else {
      fast = fast->next;
      if (fast->next == NULL) {
	return NULL;
      } else {
	fast = fast->next;
      }
    }

    slow = slow->next;
  } while (slow != fast);

  // assert slow == fast
  
  fast = head;
  while (slow != fast) {
    slow = slow->next;
    fast = fast->next;
  }

  return slow;
}

int main() {
  return 0;
}
