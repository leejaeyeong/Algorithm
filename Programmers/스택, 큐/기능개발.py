def solution(progresses, speeds):
    baefo = []
    delete = []
    day = 0
    cnt = 0
    uncomplete = len(progresses)
    
    while (uncomplete > 0) :
    
        day = day + 1
        for i in range(uncomplete) :
            progresses[i] = progresses[i] + speeds[i]
        
      
        if progresses[0] >= 100 :
            for i in range(uncomplete) :
                if progresses[i] >= 100 :
                    cnt = cnt + 1
                    delete.append(i);
                elif progresses[i] < 100 :
                    break
            
        if cnt > 0 :
            del_count = 0
            baefo.append(cnt)
            uncomplete = uncomplete - cnt
            for i in range(len(delete)) :
                del progresses[delete[i]+del_count]
                del speeds[delete[i]+del_count]
                del_count = del_count - 1
            delete = []
            cnt = 0
        
        
            
    return baefo