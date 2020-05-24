# Algorithm / Data Structure  
## S. 퀵소트  
> 주어진 배열을 두개로 분할하고, pivot을 기준으로 각각 정렬하는 과정을 반복한다.  
> 시간복잡도 O(nlogn)  
> 최악의 경우, O(n^2)이지만 평균적으로 가장 빠르다.  

### 구현  
 - pivot을 기준으로 pivot 보다 작은 배열과 pivot 보다 큰 배열을 찾는다.
 - pivot을 제외한 나누어진 두 배열에 퀵소트 과정을 반복한다. 
```python
def quick_sort(arr) :
    if len(arr) <= 1 : 
        return arr
    pivot = arr[len(arr)//2]
    less_arr, equal_arr, big_arr = [], [], []
    for i in arr :
        if i < pivot :
            less_arr.append(i)
        elif i > pivot :
            big_arr.append(i)
        else :
            equal_arr.append(i)
    return quick_sort(less_arr) + equal_arr + quick_sort(big_arr)
```
## Q. 큐  
### 선형 큐  
 - front : 저장된 첫번째 원소의 인덱스 (삭제 위치)
 - rear : 저장된 마지막 원소의 인덱스 (삽입 위치)
 - 초기 상태 : ```front = rear = -1```
 - 공백 상태 : ```front = rear```
 - 포화 상태 : ```rear = n-1``` (n은 배열의 크기, n-1은 배열의 마지막 인덱스)  
#### 단점) 배열의 크기가 고정적, full(```rear == n-1```) 상태에서 큐에 원소가 꽉 차 있지 않는 경우가 있다. 이 경우 deQueue 연산으로 인해 생긴 공백만큼 큐의 원소를 앞으로 이동시켜야 하므로 많은 비용이 발생한다.  
```python  

class Queue() :
    def __init__(self,n) :
        self.queue = [None]*n
        self.n = n
        self.front = -1
        self.rear = -1
    
    def isEmpty(self) :
        return self.front == self.rear
    
    def isFull(self) :
        return self.rear == self.n-1

    def Qpeek(self) :
        if self.isEmpty() :
            print('empty')
            return None
        return self.queue[self.front+1]

    def deQueue(self) :
        if self.isEmpty() :
            print('empty')
            return None
        else :
            self.queue[self.front+1] = None
            self.front += 1

    def inQueue(self, value) :
        if self.isFull() :
            if self.queue[0] != None :
                print('full')
                return None
            else :
                noneCnt = self.queue.count(None)

                for i in range(self.n) :
                    if self.queue[i] != None :
                        self.queue[i-noneCnt] = self.queue[i]
                        self.queue[i] = None

                self.front = -1
                self.rear = -1 if self.queue.count(None) == self.n else i-noneCnt
                    
        self.rear += 1
        self.queue[self.rear] = value  
```
### 원형 큐  
 - front와 rear의 위치가 배열의 마지막 인덱스인 n-1을 가리킨 후, 그 다음에는 논리적인 순환을 이루어 배열의 처음 인덱스인 0을 가리키도록 하자.
 - mod연산을 활용
   - front 변수 : 공백상태와 포화상태 구분을 쉽게 하기 위해 front의 자리는 항상 빈자리  
 > 원형 큐의 크기가 n이라면 원형 큐에 넣을 수 있는 값의 수는 n-1개이다.  
 > 만약 n개를 다 채울경우, front와 rear의 값이 같아져서 시작이 어디인지 문제가 발생하게 된다.
```python  
class RoundQueue() :
    def __init__(self,n) :
        self.queue = [None]*n
        self.n = n
        self.front = 0
        self.rear = 0
    
    def isEmpty(self) :
        return self.front == self.rear
    
    def isFull(self) :
        # 원형 큐의 경우 원형을 돌아왔는데 값이 front랑 같다면 full이라고 볼 수 있다.
        return (self.rear+1)%self.n == self.front

    def Qpeek(self) :
        if self.isEmpty() :
            return None
        return self.queue[self.front+1]

    def deQueue(self) :
        if self.isEmpty() :
            return None
        self.front = (self.front+1)%self.n
        value = self.queue[self.front]
        self.queue[self.front] = None
        return value 

    def inQueue(self, value) :
        if self.isFull() :
            print('is Full')
            return 
        self.rear = (self.rear+1)%self.n
        self.queue[self.rear] = value
        
```
## N. 트리  
 - 차수  
   - 노드의 차수 - 노드에 연결된 자식 노드의 수  
   - 트리의 차수 - 트리의 속한 노드의 차수 중 가장 큰 값  
 - 높이  
   - 노드의 높이 - 루트에서 해당 노드에 이르는 간선의 수 (노드의 레벨) 
   - 트리의 높이 - 트리에 속한 노드의 높이 중 가장 큰 레벨  
   
### 이진탐색트리  
 - 탐색을 효율적으로 하기 위한 자료구조  
 - 중복된 키에 대한 접근이 애매하다. 
   - 이진탐색트리 + 연결리스트로 해결할 수 있다. (ex 키가 동일한 노드를 만날 경우 연결리스트로 연결)  
 - 중위순회할 경우 오름차순으로 정렬된 값을 반환
 - 탐색, 삽입, 삭제 시간은 트리의 높이 만큼 소요된다. O(h)
 - 평균 O(log n), 최악 O(n)  
 
#### (1) 탐색  
 - 루트에서 시작
 - 탐색할 key 값과 root 노드의 key를 비교한다. 
   - root == key : 원하는 값 찾음
   - root > key : 왼쪽 서브트리 탐색
   - root < key : 오른쪽 서브트리 탐색  
#### (2) 삽입  
 - **root 노드부터 값을 비교하면서 위치를 찾아나간다.**
  
```python  
class Node(object) :
    def __init__(self, data) :
        self.data = data
        self.left = self.right = None 
        

class BinarySearchTree(object) :
    def __init__(self):
        self.root = None

    def insert(self, data) :
        self.root = self.insert_value(self.root,data)
        return self.root is not None
    
    def insert_value(self, node, data) :
        if node is None :
            node = Node(data)
        else :
            if data <= node.data :
                node.left = self.insert_value(node.left, data)
            else :
                node.right = self.insert_value(node.right, data)
        return node 
    
    def find(self, key) :
        return self.find_value(self.root, key) 
    
    def find_value(self, root, key):
        if root is None or root.data == key:
            return root is not None
        elif key < root.data:
            return self.find_value(root.left, key)
        else:
            return self.find_value(root.right, key)  
```  
### 배열 회전  
```python 
arr = [[col + 1 for col in range(5)] for row in range(5)] # 5x5 배열 생성
rotatedArr_90 = [[arr[i][j] for i in reversed(range(len(arr[j])))] for j in range(len(arr))] # 90도 회전
rotatedArr_180 = [[arr[j][i] for i in reversed(range(len(arr[j])))] for j in range(len(arr))] # 180도 회전
rotatedArr_270 = [[arr[i][j] for i in range(len(arr[j]))] for j in reversed(range(len(arr)))] # 270도 회전
```