#include <stdbool.h> 
#include <stdio.h>

struct ListNode {
  int val;
  struct ListNode *next;
};

bool hasCycle(struct ListNode *head) {
  if (head == NULL) {
    return false;
  }

  struct ListNode *slow = head;
  struct ListNode *fast = head;
  
  do {
    if (fast->next == NULL || fast->next->next == NULL) {
      return false;
    } else {
      fast = fast->next->next;
    }

    slow = slow->next;
  } while(slow != fast);

  return true;
}

int main() {
  return 0;
}
