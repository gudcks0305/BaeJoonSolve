package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
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

	arrays := make([]int, n)
	for i := 0; i < n; i++ {
		rs, _ := br.ReadString('\n')
		rs = strings.TrimSpace(rs)
		k, _ := strconv.Atoi(rs)
		arrays[i] = k
	}
	sort.Ints(arrays)
	for _, v := range arrays {
		bw.WriteString(fmt.Sprintf("%d\n", v))
	}
}
