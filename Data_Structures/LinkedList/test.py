nums = [1,2,0,-1,-2,3,4,0,1,2,3,0,2,2,2,-1]
output = []
curr = 0
left = 0
right = 0

while curr <= len(nums)-1:
    if nums[curr] != 0 and curr != len(nums)-1:
        right += 1
        curr += 1
    elif nums[curr] == 0:
        output.append([nums[i] for i in range(left, right)])
        curr += 1
        left = curr
        right = curr
    elif curr == len(nums)-1:
        right += 1
        output.append([nums[j] for j in range(left, right)])
        curr += 1
                