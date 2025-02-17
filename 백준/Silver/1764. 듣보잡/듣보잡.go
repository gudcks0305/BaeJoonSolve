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
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	peopleMaps := make(map[string]int)
	for i := 0; i < n; i++ {
		people := getInputLine(rw)
		peopleMaps[people]++
	}
	for i := 0; i < m; i++ {
		people := getInputLine(rw)
		peopleMaps[people]++
	}
	var unknowns []string
	for k, v := range peopleMaps {
		if v != 1 {
			unknowns = append(unknowns, k)
		}
	}

	slices.SortFunc(unknowns, func(a, b string) int {
		return strings.Compare(a, b)
	})
	fmt.Fprintln(rw, len(unknowns))
	for _, v := range unknowns {
		fmt.Fprintln(rw, v)
	}
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
