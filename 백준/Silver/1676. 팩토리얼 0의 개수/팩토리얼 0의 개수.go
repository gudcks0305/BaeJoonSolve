package main

import (
	"fmt"
)

func main() {
	var n int
	fmt.Scan(&n)
	cnt := 0
	for n > 0 {
		cnt += n / 5
		n /= 5
	}
	fmt.Println(cnt)
}
