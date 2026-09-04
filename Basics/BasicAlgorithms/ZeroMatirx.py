def setZeroes(matrix):
    M = len(matrix)
    N = len(matrix[0])
    
    first_row_has_zero = False
    first_col_has_zero = False
    
    # 1. Check if the first row or first column naturally have a 0
    for j in range(N):
        if matrix[0][j] == 0:
            first_row_has_zero = True
    for i in range(M):
        if matrix[i][0] == 0:
            first_col_has_zero = True
            
    # 2. Use the first row and col to store flags for the rest of the matrix
    for i in range(1, M):
        for j in range(1, N):
            if matrix[i][j] == 0:
                matrix[i][0] = 0
                matrix[0][j] = 0
                
    # 3. Zero out cells based on the flags in the first row/col
    for i in range(1, M):
        for j in range(1, N):
            if matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0
                
    # 4. Finally, update the first row and col if they had zeroes originally
    if first_row_has_zero:
        for j in range(N):
            matrix[0][j] = 0
            
    if first_col_has_zero:
        for i in range(M):
            matrix[i][0] = 0