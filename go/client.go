package main

import (
	"fmt"

	motan "github.com/weibocom/motan-go"
	motancore "github.com/weibocom/motan-go/core"
)

func main() {
	runClientDemo()
}

func runClientDemo() {
	mccontext := motan.GetClientContext("./clientdemo.yaml")
	mccontext.Start(nil)
	mclient := mccontext.GetClient("golang-example-helloworld")

	args := make(map[string]string, 16)
	args["crop"] = "weibo"
	args["site"] = "idevz.org"
	var reply string
	err := mclient.Call("Hello", args, &reply)
	if err != nil {
		fmt.Printf("motan call fail! err:%v\n", err)
	} else {
		fmt.Printf("motan call success! reply:%s\n", reply)
	}

	// async call
	args["is-async"] = "yes --->>>\n"
	result := mclient.Go("hello", args, &reply, make(chan *motancore.AsyncResult, 1))
	res := <-result.Done
	if res.Error != nil {
		fmt.Printf("motan async call fail! err:%v\n", res.Error)
	} else {
		fmt.Printf("motan async call success! reply:%+v\n", reply)
	}
}