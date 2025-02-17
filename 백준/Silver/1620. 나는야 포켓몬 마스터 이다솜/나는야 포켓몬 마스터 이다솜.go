package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Queue = []int

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	pkmBook := make(map[string]string)
	for i := 0; i < n; i++ {
		pkm := getInputLine(rw)
		nums := strconv.Itoa(i + 1)
		pkmBook[pkm] = nums
		pkmBook[nums] = pkm
	}
	for i := 0; i < m; i++ {
		pkm := getInputLine(rw)
		fmt.Fprintln(rw, pkmBook[pkm])
	}

}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
