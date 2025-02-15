package main

import (
	"fmt"
	"strings"
)

func main() {
	var n int
	fmt.Scan(&n)
	idx := 0
	res := 666
	for i := 666; i <= 1<<62; i++ {
		str := fmt.Sprintf("%d", i)
		if strings.Contains(str, "666") {
			idx++
			res = i
			if idx == n {
				break
			}
		}
	}
	fmt.Println(res)
}
