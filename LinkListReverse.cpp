//https://www.cnblogs.com/kubixuesheng/p/4394509.html
#include <iostream>
using namespace std;

typedef struct Node{
    int data;
    Node *next;
} Node, *List;

Node * reverseList(List head){
    //定义三个指针，保存原来的连接的状态
    //当前结点指针
    Node *pnow = head;
    //当前结点的前驱指针，初始化是 NULL
    Node *pre = NULL;
    //当前结点的后继指针，初始化也是 null
    Node *pnext = NULL;
    //定义尾指针
    Node *tail = NULL;
    //开始遍历链表
    while(pnow != NULL){
        //如果当前结点不是 null，那么初始化 pnext 指针指向当前结点的下一个结点
        pnext = pnow->next;
        //如果找到了尾结点，初始化 tail 指针
        if(NULL == pnext){
            tail = pnow;
        }
        //进行链表的反转，当前结点的 next 指针指向前一个结点，实现链表方向的反转，此时发生了断链
        pnow->next = pre;
        //勿忘断链的情形，需要使用 pre 指针保存状态，pre 等价于是后移一个结点
        pre = pnow;
        //pnow 后移一个结点
        pnow = pnext;
    }

    return tail;
}

//递归方式
Node * reverseList(List head)
{
    //如果链表为空或者链表中只有一个元素
    if(head == NULL || head->next == NULL)
    {
        return head;
    }
    else
    {
        //先反转后面的链表，走到链表的末端结点
        Node *newhead = reverseList(head->next);
        //再将当前节点设置为后面节点的后续节点
        head->next->next = head;
        head->next = NULL;

        return newhead;
    }
}