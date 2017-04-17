#include <stdio.h>

/**
 * Definition for a binary tree node.
 */

struct TreeNode {
  int val;
  struct TreeNode *left;
  struct TreeNode *right;
};


int findLeftHeight(struct TreeNode *root) {
  // assert root != NULL
  int height = 0;
  while (root->left != NULL) {
    root = root->left;
    ++height;
  }

  return height;
}

int findRightHeight(struct TreeNode *root) {
  // assert root != NULL
  int height = 0;
  while (root->right != NULL) {
    root = root->right;
    ++height;
  }

  return height;
}

int calcTree(struct TreeNode *root) {
  int leftHeight = findLeftHeight(root);
  int rightHeight = findRightHeight(root);
  if (leftHeight == rightHeight) {
    
    return (2 << leftHeight) - 1;
  } else if (rightHeight == 0) {
    // assert leftHeight == 1
    return 2;
  }

  // assert(root->left != NULL && root->right != NULL)
  return 1 + calcTree(root->left) + calcTree(root->right);
}

int countNodes(struct TreeNode* root) {
  if (root == NULL) {
    return 0;
  }

  return calcTree(root);
}

int main () {
  struct TreeNode *left = (struct TreeNode *)malloc(sizeof(struct TreeNode));
  struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));

  left->left = left->right = NULL;
  left->val = 2;

  root->left = left;
  root->right = NULL;
  root->val = 1;

  printf("result: %d", countNodes(root));
}
