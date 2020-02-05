def mm(a,b) :
    if len(a) == len(b) : return a<=b
    else : return a+b <= b+a

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else :
        pivot = arr[0]
        gt = [el for el in arr[1:] if mm(el,pivot)]
        ls = [el for el in arr[1:] if not mm(el,pivot)]
        return quick_sort(ls) + [pivot] + quick_sort(gt)
    

def solution(arr) :
    if set(arr) == {0} :
        return '0'
    else :
        arr = list(map(str,arr))
        answer = quick_sort(arr)
        return ''.join([str(x) for x in answer])