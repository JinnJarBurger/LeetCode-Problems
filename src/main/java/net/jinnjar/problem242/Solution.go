package problem242

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	stringMap := make(map[rune]int)

	for _, char := range s {
		stringMap[char] = stringMap[char] + 1
	}

	for _, char := range t {
		if _, ok := stringMap[char]; ok {
			stringMap[char] = stringMap[char] - 1
		}
	}

	for _, char := range s {
		if stringMap[char] > 0 {
			return false
		}
	}

	return true
}
