#include <stdio.h>
#include <stdlib.h>
#include "LinkedQueue.h"

int main() {
	LQueueType* Q1 = createLinkedQueue(); //���� ť ����

	QNode* N1 = createQNode(10, (rand() % 5 + 1)); //��� 10�� ���� createQNode(<���μ���ID��>, <1~5������ repeat��>);
	QNode* N2 = createQNode(20, (rand() % 5 + 1));
	QNode* N3 = createQNode(30, (rand() % 5 + 1));
	QNode* N4 = createQNode(40, (rand() % 5 + 1));
	QNode* N5 = createQNode(50, (rand() % 5 + 1));
	QNode* N6 = createQNode(60, (rand() % 5 + 1));
	QNode* N7 = createQNode(70, (rand() % 5 + 1));
	QNode* N8 = createQNode(80, (rand() % 5 + 1));
	QNode* N9 = createQNode(90, (rand() % 5 + 1));
	QNode* N10 = createQNode(100, (rand() % 5 + 1));

	insert(Q1, N1); //������ 10���� ���μ����� ť�� ����
	insert(Q1, N2);
	insert(Q1, N3);
	insert(Q1, N4);
	insert(Q1, N5);
	insert(Q1, N6);
	insert(Q1, N7);
	insert(Q1, N8);
	insert(Q1, N9);
	insert(Q1, N10);

	printf("==>");  printLQ(Q1); printf("\n"); //���� ť ���¸� ����Ͽ� � ���μ����� ���� ������ �� üũ
	while (!isLQEmpty(Q1)) { //ť�� ���� ���°� �� ������ �ݺ�
		int num = delete(Q1); //������ ���μ����� ť���� �����Ͽ� �ش� ���μ��� ID�� int ���� num�� ����
		printf("######���μ��� ���� ����###### ");
		printf("-> ���õ� ���μ��� ID : %d\n\n", num); //������ ���μ����� ���õ� ���μ����� ID : num
		printf("==>");  printLQ(Q1); printf("\n"); //���� ť ���¸� ���
	}
	getchar(); return 0;
}