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
	sitePassword := make(map[string]string)
	for i := 0; i < n; i++ {
		sitepass := strings.Split(getInputLine(rw), " ")
		site := sitepass[0]
		password := sitepass[1]
		sitePassword[site] = password
	}
	for i := 0; i < m; i++ {
		site := getInputLine(rw)
		fmt.Fprintln(rw, sitePassword[site])
	}
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
