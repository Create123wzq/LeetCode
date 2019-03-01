#include <stack>

struct BiTreeNode{
    int data;
    BiTreeNode* left;
    BiTreeNode* right;
};
struct RESULT{
    int maxDistance;
    int maxDepth;
};
//后序遍历
void PostOrder(BiTreeNode* node){
    stack<BiTreeNode*> s;
    BiTreeNode* p = node, *r = NULL;
    while(p||!s.empty()){
        if(p){
            s.push(p);
            p = p->left;
        }else{
            p = s.top();
            if(p->right&&p->right!=r){
                p = p->right;
                s.push(p);
                p = p->left;
            }else{
                s.pop();
                std::cout << p->data;
                r = p;
                p = NULL;
            }
        }
    }
}
//中序遍历
void inOrder(BiTreeNode* node){
    if(node==NULL){
        return;
    }
    stack<BiTreeNode*> s;
    BiTreeNode* p = node;
    s.push(p);
    while(p||!s.empty()){
        if(p){
            s.push(p);
            p = p->left;
        }else{
            p = s.top();
            s.pop();
            std::cout << p->data << " ";
            p = p->right;
        }
    }
}
//前序遍历
void preOrder(BiTreeNode* node){
    if(node==NULL){
        return;
    }
    stack<BiTreeNode*> s;
    BiTreeNode* p = node;

    while(p||!s.empty()){
        if(p){
            std::cout << p->data << " ";
            s.push(p);
            p = p->left;
        }else{
            p = s.top();
            s.pop();
            p = p->right;
        }
    }
}
//创建树
BiTreeNode* createBiTree(int height, int level, int data){
    if(height==level){
        return NULL;
    }
    BiTreeNode* node = new BiTreeNode();
    node->data = data;
    node->left = createBiTree(height, level+1, data*2);
    node->right = createBiTree(height, level+1, data*2+1);
    return node;

}
//判断两棵树是否相同
bool isEqual(BiTreeNode* node1, BiTreeNode* node2){
    if(node1==NULL && node2==NULL){
        return true;
    }
    if(node1==NULL || node2==NULL){
        return false;
    }
    if(node1->data==node2->data){
        return isEqual(node1->left, node2->left) && isEqual(node1->right, node2->right);
    }else{
        return false;
    }
}
//求一棵树的高度
int height(BiTreeNode* node){
    if(node==NULL){
        return 0;
    }
    int left = height(node->left)+1 ;
    int right = height(node->right)+1;
    return left > right ? left : right;
}
//求一棵树中两个结点的最大距离
RESULT maxDistance(BiTreeNode* node){
    if(node==NULL){
        RESULT empty = {0, -1};
        return empty;
    }
    RESULT lhs = maxDistance(node->left);
    RESULT rhs = maxDistance(node->right);
    RESULT res;
    res.maxDepth = max(lhs.maxDepth+1, rhs.maxDepth+1);
    res.maxDistance = max(max(lhs.maxDistance, rhs.maxDistance), lhs.maxDepth+rhs.maxDepth+2);
    return res;
}

void printBuffer(vector<int> buffer){
    for(int i=0;i<buffer.size();i++){
        std::cout << buffer[i] << " ";
    }
    std::cout << std::endl;
}
//求所有和为指定值的路径
void findSum(BiTreeNode* node, int sum, vector<int> buffer, int level){
    if(node==NULL){
        return;
    }
    int tmp = sum;
    buffer.push_back(node->data);
    for(int i=level;i>-1;i--){
        tmp -= buffer[i];
        if(tmp == 0){
            printBuffer(buffer);
        }
    }
    findSum(node->left, sum, buffer, level+1);
    buffer.pop_back();
    level -= 1;
    findSum(node->right, sum, buffer, level+1);
}
//从根节点开始到叶节点
void findSum2(BiTreeNode* node, int sum, vector<int> buffer){
    if(node==NULL){
        return;
    }
    buffer.push_back(node->data);
    if(!node->left && !node->right){
        if(sum-(node->data)==0){
            printBuffer(buffer);
        }
    }else{
        if(node->left){
            findSum2(node->left, sum-node->data, buffer);
        }
        if(node->right){
            findSum2(node->left, sum-node->data, buffer);
        }
    }
    if(!buffer.empty()){
        buffer.pop_back();
    }
}
//判断是否为平衡二叉树
int IsBalance(BiTreeNode *root,int *pHeight)
{
    if (root == NULL)
    {
        *pHeight = 0;
        return 1;
    }
    int leftHeight;
    int rightHeight;
    int leftBalance = IsBalance(root->left, &leftHeight);
    int rightBalance = IsBalance(root->right, &leftHeight);
    *pHeight = MAX(leftHeight, rightHeight) + 1;
    if (leftBalance == 0 || rightBalance == 0)
    {
        return 0;
    }
    int diff = leftHeight - rightHeight;
    if (diff < -1 && diff>1)
    {
        return 0;
    }
    else {
        return 1;
    }
}

int main(){
    BiTreeNode* node1 = createBiTree(4, 0, 1);
    int* p;
    std::cout << IsBalance(node1, p);
}