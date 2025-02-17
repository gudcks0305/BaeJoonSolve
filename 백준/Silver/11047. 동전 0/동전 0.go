package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	coins := make([]int, n)
	for i := 0; i < n; i++ {
		v := getInputLine(rw)
		vn, _ := strconv.Atoi(v)
		coins[i] = vn
	}

	cur := m
	cnt := 0

	for i := n - 1; i >= 0; i-- {
		numCoins := cur / coins[i]
		cnt += numCoins
		cur -= numCoins * coins[i]
	}

	fmt.Fprintln(rw, cnt)
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}