# Algorithm / Data Structure  

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
