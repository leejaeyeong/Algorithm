def solution(genres, plays):
    uniq_genre=set(genres)
    total_genre_playtime={}
    total_genre_pks={}
    answer=[]

    # 장르별 재생시간과 고유번호 리스트 자료구조 생성
    for genre in uniq_genre:
        genre_pks=[]
        for idx,val in enumerate(genres):
            if genre==val:
                genre_pks.append(idx)

        play_time=0
        for j in genre_pks:
            play_time+=plays[j]
        total_genre_playtime[genre]=play_time
        total_genre_pks[genre]=genre_pks
    
    
    # 가장 많이 재생딘 장르를 찾기위해 재생시간 기준 정렬
    total_play_time=sorted(total_genre_playtime.items(), key = lambda item: item[1],reverse=True)
    for i in total_play_time:
        pks=total_genre_pks[i[0]]
        
        music_list={} # 노래별 재생시간 정보  
        for pk in pks:
            music_list[pk]=plays[pk]

        # 장르 내에서 가장 많이 재생된 노래를 찾기위해 재생시간 기준 정렬 
        music_list=sorted(music_list.items(), key = lambda item: item[1],reverse=True)
        
        if len(music_list)>1:
            answer.append(music_list[0][0])
            answer.append(music_list[1][0])
        else:
            answer.append(music_list[0][0])
    return answer
print(solution(['classic', 'pop', 'classic', 'classic', 'pop'],[500, 600, 150, 800, 2500]))