package main

import (
	"fmt"
	"io"
	"net/http"
	"sync"
)

type Job struct {
	URL string
}
type Result struct {
	URL        string
	StatusCode int
	Size       int
	Err        error
}

func worker(id int, jobs <-chan Job, results chan<- Result, wg *sync.WaitGroup) {
	defer wg.Done()
	for job := range jobs {
		fmt.Printf("Worker %d: downloading %s\n", id, job.URL)

		resp, err := http.Get(job.URL)
		if err != nil {
			results <- Result{URL: job.URL, Err: err}
			continue
		}
		defer resp.Body.Close()
		body, err := io.ReadAll(resp.Body)
		if err != nil {
			results <- Result{URL: job.URL, Err: err}
			continue
		}
		results <- Result{
			URL:        job.URL,
			StatusCode: resp.StatusCode,
			Size:       len(body),
			Err:        nil,
		}
	}
}

func main() {
	urls := []string{
		"https://example.com",
		"https://google.com",
		"https://uottawa.ca",
		"https://github.com",
		"https://golang.org",
	}
	numWorkers := 5
	jobs := make(chan Job, len(urls))
	results := make(chan Result, len(urls))

	var wg sync.WaitGroup

	//start workers
	for i := 1; i <= numWorkers; i++ {
		wg.Add(1)
		go worker(i, jobs, results, &wg)
	}
	//send jobs
	for _, url := range urls {
		jobs <- Job{URL: url}
	}
	close(jobs)
	//wait for all workers to finish
	go func() {
		wg.Wait()
		close(results)
	}()
	//receive results
	for res := range results {
		if res.Err != nil {
			fmt.Printf("%s → ERROR: %v\n", res.URL, res.Err)
		} else {
			fmt.Printf("%s → Status: %d, Size: %d bytes\n",
				res.URL, res.StatusCode, res.Size)
		}
	}
	fmt.Println("all downloads completed")
}
