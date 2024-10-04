#pragma once
typedef int element;

typedef struct QNode { //���μ����� �ش��ϴ� ��� ����ü
	element id; //���μ��� ID���� ��Ÿ���� ���� (10~100)
	element repeat;  //���μ����� �ݺ� ���� ��Ÿ���� ���� (1~5������ ����)
	struct QNode* link; //�ش� ���μ����κ��� ���� ���μ����� ����Ű�� link ������
}QNode;

typedef struct { //����ť���� ���� ����� ���μ����� ����Ű�� �����Ϳ�, ������ ���μ����� ����Ű�� �����͸� ���� ����ü
	QNode* head, * tail; //���� ����� ���μ����� ����Ű�� head ������, ������(����) ���μ����� ����Ű�� tail ������
}LQueueType;

LQueueType* createLinkedQueue(void); // ���� ť�� �����ϴ� �Լ� ����
QNode* createQNode(element id, element r); // ���� ť�� �� ���μ��� ��带 �����ϴ� �Լ� ����
int isLQEmpty(LQueueType* LQ); // ����ť�� ������ ���� ��Ÿ���� �Լ� ����
void insert(LQueueType* LQ, QNode*Q); // ���� ť�� ���μ��� ��带 �����ϴ� �Լ� ����
element delete(LQueueType* LQ); // ���� ť���� ���μ����� �����Ͽ� �����ϴ� �Լ� ����
void printLQ(LQueueType* LQ); // ���� ť�� ���� ���¸� ��Ÿ���� �Լ� ����

