#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include "LinkedQueue.h"

LQueueType* createLinkedQueue(void) { // ���� ť ����
	LQueueType* LQ = (LQueueType*)malloc(sizeof(LQueueType)); // LQueueType ����ü ũ�⸸ŭ �޸� �����Ҵ�
	LQ->head = NULL; 
	LQ->tail = NULL; 
	return LQ; //������ ���� ť ��ȯ
}
QNode* createQNode(element id, element r) { // ���� ť�� ���� �� ���μ��� ��� ���� id = ���μ��� ID, r = �ݺ� Ƚ����
	QNode* newNode = (QNode*)malloc(sizeof(QNode)); // QNode (���μ��� ���) ����ü ũ�⸸ŭ �޸� �����Ҵ�
	newNode->id = id;
	newNode->repeat = r;
	newNode->link = NULL; // ���� �����̹Ƿ� ����� link ����
	return newNode;
}
int isLQEmpty(LQueueType* LQ) { // ���� ť�� ������ �� 1�� return, ������ �ƴ� �� 0�� return �ϴ� �Լ�
	if (LQ->head == NULL) {
		return 1;
	}
	else return 0;
}
void insert(LQueueType* LQ, QNode* Q) { // ���� ť�� ���μ��� ��带 �����ϴ� �Լ� LQ = ��带 ���� �� ���� ť, Q = ���� �� ���μ��� ���
	QNode* node = Q; // ���� �� ��� = node
	if (LQ->head == NULL) { // ���� ť�� ������ ��
		LQ->head = node;
		LQ->tail = node; 
	}
	else { // ���� ť�� ������ �ƴ� ��
		LQ->tail->link = node; 
		LQ->tail = node; 
		node->link = NULL; //tail ���� node �̹Ƿ� ����� link ����(NULL)
	}
}
element delete(LQueueType* LQ) {
	QNode* selected = LQ->head; // selected�� ���õ� ���μ���
	element num;
	num = selected->id;
	selected->repeat--; // �ش� ���μ����� ���� �Ǿ����Ƿ� �ݺ� Ƚ���� - 1
	LQ->head = LQ->head->link; // ���μ����� �ϳ� �����Ͽ����Ƿ� head��带 ������ head��忡 link�� ���� ���� ��
	if (LQ->head == NULL) {
		LQ->tail = NULL;
	}
	if (selected->repeat != 0) { // �ݺ� Ƚ���� 0�� �ƴҽ�
		insert(LQ, selected); // �ش� ��带 �ٽ� ����ť�� ����
		return num;
	}
	else {// �ݺ� Ƚ���� 0�Ͻ�
		free(selected); // �ش� ��� ����ü�� �޸� ���� �� ����� ���� x
		return num;
	}
}
void printLQ(LQueueType* LQ) {
	QNode* temp = LQ->head;
	printf(" ���� ť ���� : [");
	while (temp) { // ���� ť�� �����ϴ� ��带 ��� link�� ���� �湮�ϸ� NULL�� ���� ������
		printf(" %3d(%d)", temp->id, temp->repeat);
		temp = temp->link;
	}
	printf(" ] ");
}