package problem217

func containsDuplicate(nums []int) bool {
	numsMap := make(map[int]int)

	for _, n := range nums {
		if _, ok := numsMap[n]; ok {
			return true
		}

		numsMap[n] = n
	}

	return false
}
