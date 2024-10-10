#pragma once
#define TRUE 1
#define FALSE 0
#define INF 10000
#define MAX_VERTICES 5

int distance[MAX_VERTICES];
int S[MAX_VERTICES];

int nextVertex(int n);
int printStep(int step);
void Dijkstra__shortestPath(int start, int n);