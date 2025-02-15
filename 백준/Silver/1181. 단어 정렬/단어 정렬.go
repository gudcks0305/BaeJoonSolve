package main

import (
	"bufio"
	"fmt"
	"os"
	"slices"
	"strconv"
	"strings"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()
	readString, _ := br.ReadString('\n')
	readString = strings.TrimSpace(readString)
	n, _ := strconv.Atoi(readString)

	arrays := make([]string, n)
	for i := 0; i < n; i++ {
		readString, _ = br.ReadString('\n')
		readString = strings.TrimSpace(readString)
		arrays[i] = readString
	}
	slices.SortFunc(arrays, func(i, j string) int {
		if len(i) == len(j) {
			return strings.Compare(i, j)
		}
		return len(i) - len(j)
	})
	m := make(map[string]bool)
	for _, v := range arrays {
		if _, ok := m[v]; !ok {
			fmt.Fprintln(bw, v)
			m[v] = true
		}
	}
}
