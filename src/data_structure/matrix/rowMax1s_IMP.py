class Mat:
	def __init__(self, 
				row, col, m):
		self.R=row
		self.C=col
		self.mat=m
	def fst(self, 
		rowIdx, lo, hi):
		if hi>=lo:
			mi=lo+(hi-lo)/2
			
			if ((mi==0 
				or (self.mat[rowIdx][mi-1]==0 
				and self.mat[rowIdx][mi]==1))):
				return mi
			#recur for right side
			elif self.mat[rowIdx][mi]==0:
				return fst(rowIdx, mi+1,hi)
			#recur for left side
			else:
				return fst(rowIdx,lo,mi-1)
		return -1
	def rowWithMax1s 
		max_row_idx=0
		j=fst(0,0,C-1)
		if j==-1:
			j=C-1
		
		for i in range(1,R):
			while(j>=0  and self.mat[i][j]==1):
				j=j-1
				max_row_idx=i
		return max_row_idx