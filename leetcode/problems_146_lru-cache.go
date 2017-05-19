package main

import (
	"fmt"
)

type Item struct {
	Val int
	Newer int
	Older int
}

type LRUCache struct {
	counter int
	capacity int
	container map[int]*Item
	newestIndex int
	oldestIndex int
}


func Constructor(capacity int) LRUCache {
	return LRUCache{
		counter: 0,
		capacity: capacity,
		container: make(map[int]*Item, capacity),
		newestIndex: -1,
		oldestIndex: -1,
	}
}


func (this *LRUCache) Get(key int) int {
	result := -1
	if item, ok := this.container[key]; ok {
		result = item.Val

		if key != this.newestIndex {
			// rearrange to the latest
			this.container[item.Newer].Older = item.Older
			if item.Older != -1 {
				this.container[item.Older].Newer = item.Newer
			}

			this.container[this.newestIndex].Newer = key
			item.Older = this.newestIndex
			
			if this.oldestIndex == key {
				this.oldestIndex = item.Newer
			}
			item.Newer = -1
			this.newestIndex = key

		}
	}

	return result
}


func (this *LRUCache) Put(key int, value int)  {
	if this.capacity == 0 {
		return
	}

	if this.Get(key) != -1 {
		// assert this.newstIndex == key
		this.container[key].Val = value
		return
	}

	item := &Item{
		Val: value,
		Newer: -1,
		Older: -1,
	}

	if this.capacity == 1 || this.counter == 0 {
		if this.counter == 0 {
			this.counter = 1
		} else {
			// assert this.newestIndex == this.oldestIndex
			// assert this.counter == 1
			delete(this.container, this.newestIndex)
		}

		this.oldestIndex = key
	} else {
		// assert this.capacity >= 2 && this.counter >= 1
		newestIndex := this.newestIndex
		newestItem  := this.container[newestIndex]
		oldestIndex := this.oldestIndex
		oldestItem  := this.container[oldestIndex]

		if this.counter < this.capacity {
			// add one more item
			this.counter++
		} else {
			// assert this.counter >= 2
			// assert newestIndex != oldestIndex && newestItem != oldestItem
			delete(this.container, oldestIndex)

			// assert oldestItem.Newer != -1
			this.oldestIndex = oldestItem.Newer
			this.container[oldestItem.Newer].Older = -1
		}

		item.Older = newestIndex
		newestItem.Newer = key
	}

	this.newestIndex = key
	this.container[key] = item
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

func main () {
	// cache := Constructor(2)

	// cache.Put(1, 1)
	// fmt.Println("cache: ", cache)
	// fmt.Println("cache[1]: ", cache.container[1])

	// cache.Put(2, 2)
	// fmt.Println("cache: ", cache)
	// fmt.Println("cache[1, 2]: ", cache.container[1], cache.container[2])

	// cache.Get(1)       // returns 1
	// fmt.Println("cache: ", cache)
	// fmt.Println("cache[1, 2]: ", cache.container[1], cache.container[2])

	// cache.Put(3, 3)    // evicts key 2
	// cache.Get(2)       // returns -1 (not found)
	// cache.Put(4, 4)    // evicts key 1
	// cache.Get(1)       // returns -1 (not found)
	// cache.Get(3)       // returns 3
	// cache.Get(4)       // returns 4

	cache := Constructor(1)
	cache.Put(2, 1)
	cache.Get(2)
	cache.Put(3, 2)
	cache.Get(2)
	cache.Get(3)

	fmt.Println("cache: ", cache)
}
