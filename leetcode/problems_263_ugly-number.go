package main

func isUgly(num int) bool {
	if num == 0 {
		return false
	}

	for _, dividor := range []int{2,3,5} {
		for num % dividor == 0 {
			num /= dividor
		}
	}

	return num == 1
}

func main () {
}
