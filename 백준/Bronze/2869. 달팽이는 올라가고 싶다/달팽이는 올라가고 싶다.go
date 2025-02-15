package main

import "fmt"

func main() {
	var a, b, v int
	fmt.Scan(&a, &b, &v)
	dt := (v - b) / (a - b)
	remain := (v - b) % (a - b)
	if remain != 0 {
		dt++
	}
	fmt.Println(dt)
}

// 점화식 V <= Ax - Bx , V <= Ax - B(x-1)
// (A-B)
//  (A-B)x + (A-B+1) >= V
