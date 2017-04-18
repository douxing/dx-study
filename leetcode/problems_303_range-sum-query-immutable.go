package main

type NumArray struct {
    nums []int
}


func Constructor(nums []int) NumArray {
	return NumArray{
		nums: nums,
	}
}


func (this *NumArray) SumRange(i int, j int) int {
	sum := 0
	for _, val := range(this.nums[i:j+1]) {
		sum += val
	}

	return sum
}


func main () {
	return
}
