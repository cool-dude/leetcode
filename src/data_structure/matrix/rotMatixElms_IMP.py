def rotMatrix(mat):
	if not len(mat):
		return;
	
	top=0
	bot=len(mat)-1
	lft=0
	rgt=len(mat)-1
	
	while(lft<rgt and top<bot):
		#prv element to move
		prv=mat[top+1][lft]
		
		for i in range(lft,rgt+1):
			cur=mat[top][i]
			mat[top][i]=prv
			prv=cur
		top+=1
		
		for i in range(top,bot-1):
			cur=mat[i][rgt]
			mat[i][rgt]=prv
			prv=cur
		rgt-=1
		
		for i in range(rgt,lft-1,-1):
			cur=mat[bot][i]
			mat[bot][i]=prv
			prv=cur
		bot-=1
		
		for i in range(bot,top-1,-1):
			cur=mat[i][lft]
			mat[i][lft]=prv
			prv=cur
		lft+=1
	return mat